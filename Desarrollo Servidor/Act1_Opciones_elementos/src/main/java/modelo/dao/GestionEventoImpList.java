package modelo.dao;
//			 Gestion de eventos implementados en lista

import java.util.ArrayList;
import java.util.List;



import modelo.beans.Evento;

public class GestionEventoImpList implements IntEventoDao{

	List<Evento> lista;
	
	public GestionEventoImpList() {
		lista = new ArrayList<Evento>();
		cargarEvento();
		
	}
	
	private void cargarEvento() {
		InterfTipo intfTipos = new GestionTipo();
		lista.add(new Evento(1111, "Paco", 400, "Cumple", "2021-10-21", 1, "activo", "s", 20, 10, intfTipos.findById(1)));
		lista.add(new Evento(2222, "Fran", 600, "Boda", "2021-05-05", 1, "activo", null, 20, 10, intfTipos.findById(2)));
		lista.add(new Evento(3333, "Manolo", 500, "Comunion", "2021-10-20", 1, "", "s", 20, 10, intfTipos.findById(3)));
		lista.add(new Evento(4444, "Elisa", 200, "Despedida", "2021-02-10", 1, "activo", null, 20, 10, intfTipos.findById(4)));
		lista.add(new Evento(5555, "Jose", 350, "Despedida", "2021-09-15", 1, "", "s", 20, 10, intfTipos.findById(4)));
	}

	@Override
	public List<Evento> findAll() {//devuelve la lista de los eventos
		return lista;
	}

	@Override
	public Evento findById(long id) {//devuelve el evento que le piden por su id
		Evento evento = new Evento();
		evento.setId(id);
		
		int pos = lista.indexOf(evento);
		if(pos == -1)
			return null;
		else
			return lista.get(pos);
	}
	@Override
	public int insertOne(Evento Evento) {//insertamos 1 evento y ademas si es repetido no lo añadimos
		if(!lista.contains(Evento)) {//si el evento que nos pasan no esta en la lista 
			lista.add(Evento);//lo añadimos
			return 1;
		}else
			return 0;//si no no hacemos nada
	}

	@Override
	public int deleteOne(long id) {//borrar un evento entero a raiz de su id
		Evento evento = findById(id);
		if(evento == null) {
			return 0;
		}else
			return lista.remove(evento)?1:0;
	}
}
