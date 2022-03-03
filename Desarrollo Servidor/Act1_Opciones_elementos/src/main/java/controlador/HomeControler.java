package controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.beans.Evento;
import modelo.dao.GestionEventoImpList;
import modelo.dao.IntEventoDao;

/**
 * Servlet implementation class HomeControler
 */
@WebServlet("/HomeControler")
public class HomeControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeControler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IntEventoDao edao = new GestionEventoImpList();//hace cntacto cn la bas de datos
		List<Evento> lista = edao.findAll();//busca la lista de los libros
		request.getSession().setAttribute("listaeventos", lista);//los mete en un atribt de peticion
		request.getRequestDispatcher("index.jsp").forward(request, response);//llama al jsp y le da el reqst y responsv para los parametros... ip de la maquina...
	}

}
