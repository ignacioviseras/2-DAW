package controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.beans.Evento;
import modelo.beans.Tipo;
import modelo.dao.GestionEventoImpList;
import modelo.dao.IntEventoDao;

/**
 * Servlet implementation class GestionEventos
 */
@WebServlet(description = "peticiones asociadas a Eventos", urlPatterns = { "/eventos" })
public class GestionEventos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionEventos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("pasando por init");
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opcion = request.getParameter("opcion");
		switch(opcion) {
		case "editar":
			List<Evento> lista = (List<Evento>)request.getSession().getAttribute("listaeventos");
			int id = (Integer.parseInt(request.getParameter("id")));
			
			Evento aux = new Evento();
			aux.setId(id);
			int pos = lista.indexOf(aux);//le damos la pos dnd se encuentra nuestro id
			
			if(pos != -1) {
			Evento event = lista.get(pos);//Lo que hacemos es optener el dato de la posicion dnd se encuentra el dato q nos pasan y
			System.out.println(event);
			request.setAttribute("evento", event);//les pasas lso datso para que s e guarden
			request.getRequestDispatcher("editarEvento.jsp").forward(request, response);
			}else {//si no existe no hacemos nada y lo metemops a inicio
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
			break;
		case "Borrar":
			BorrarEvento(request, response);
			break;
		case "Cancelar":
			CancelarEvento(request, response);
			break;
		case "AltaEvento":
			//index.jsp linea 34 Si se deja puesto el if el alta no funciona
			AltaEvento(request, response);
			break;
		default:
			System.out.println("opcion incorrecta -> " + opcion);
		}
		
		
	}
	private void BorrarEvento(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
								//Casteamos el dat
		//List<Evento> listaeve = (List<Evento>)request.getSession().getAttribute("listaeventos");
		List<Evento> lista = (List<Evento>)request.getSession().getAttribute("listaeventos");
		int id=(Integer.parseInt(request.getParameter("id")));//optenemos el id y lo convertimos en int
		Evento ax = new Evento();//Basicamente creamos un aux de evento vacio lo guardamos ahi optenemos el id que queremos
		ax.setId(id);
		int posi = lista.indexOf(ax);//optenemos la posicion de ese id
		if(posi != -1){//lo buscamos si esta y si esta lo eliminamos y refrescamos la lista de elementos
			lista.remove(posi);
			request.getSession().setAttribute("listaeventos", lista);//dices dnd vas a almacenar el dato
			request.getRequestDispatcher("index.jsp").forward(request, response);//una vez terminado lo volvemos a meter en la pag de inicio
		}else {//si no existe no hacemos nada y lo metemops a inicio
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}
	
	private void CancelarEvento(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Evento> listacan = (List<Evento>) request.getSession().getAttribute("listaeventos");
		int idcan = (Integer.parseInt(request.getParameter("id")));
		Evento aux = new Evento();
		aux.setId(idcan);
		int pos = listacan.indexOf(aux);//le damos la pos dnd se encuentra nuestro id
		
		if(pos != -1) {
			aux = listacan.get(pos);//Lo que hacemos es optener el dato de la posicion dnd se encuentra el dato q nos pasan y
			aux.setEstado("cancelado");//le escribimos cancelado en el aux 
			listacan.set(pos, aux);//y le cambiamos el valor que tenia al de aux
			
			request.getSession().setAttribute("listaeventos", listacan);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
		
	}
	private void AltaEvento(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//index.jsp linea 34 Si se deja puesto el if el alta no funciona
		List<Evento> listacan = (List<Evento>) request.getSession().getAttribute("listaeventos");
		if(listacan == null) {
			listacan = new ArrayList<Evento>();
		}
		
		Evento ax = new Evento();
		ax = listacan.get(listacan.size()-1);//miramos como de grande es el array y le quitamos 1 para saber cuantos hay
		long nv= ax.getId()+1;//y le sumamos 1 ya que los numeros de id empiezan desde 1
		
		Evento event = new Evento();
		Tipo tip = new Tipo();
		
		event.setId(nv);//le damos el id de la linea 115
		event.setNombre(request.getParameter("nombre"));//y aqui solo optenemos los datos de los campos del submit
		event.setPrecio(Integer.parseInt(request.getParameter("precio")));//y en algunos casos lo pasamos al dato que es en este caso a int
		event.setDescripcion(request.getParameter("descripcion"));
		event.setFechaInicio(request.getParameter("fechaInicio"));
		event.setDuracion_dias(Integer.parseInt(request.getParameter("duracion_dias")));
		event.setEstado(request.getParameter("estado"));
		event.setDestacado(request.getParameter("destacado"));
		event.setMaxAforo(Integer.parseInt(request.getParameter("maxAforo")));
		event.setMinAforo(Integer.parseInt(request.getParameter("minAforo")));
		
		listacan.add(event);//una vez terminado lo añadimos a evento
		request.getSession().setAttribute("listaeventos", listacan);//dices dnd vas a almacenar el dato
		request.getRequestDispatcher("index.jsp").forward(request, response);//una vez terminado lo volvemos a meter en la pag de inicio
		
	}
}
