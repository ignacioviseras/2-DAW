package com.edix.actividad.repository;
//			 Gestion de eventos implementados en lista

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;


import com.edix.actividad.modelo.beans.Evento;
@Repository
public class GestionEventoImpList implements IntEventoDao{

	private List<Evento> lista;//lista en la que estaran todos los eventos
	private List<Evento> listaux;//lista que usaremos para sacar en momentos en concreto como destacados o activos
	
	public GestionEventoImpList() {
		lista = new ArrayList<Evento>();
		listaux = new ArrayList<Evento>();
		cargarEvento();
		
	}
	
	private void cargarEvento() {
		
		lista.add(new Evento(1111, "Paco", 400, "Cumple", "2021-10-21", 1, "activo", "si", 20, 10));
		lista.add(new Evento(2222, "Fran", 600, "Boda", "2021-05-05", 1, "activo", "no", 20, 10));
		lista.add(new Evento(3333, "Manolo", 500, "Comunion", "2021-10-20", 1, "cancelado", "si", 20, 10));
		lista.add(new Evento(4444, "Elisa", 200, "Despedida", "2021-02-10", 1, "activo", "no", 20, 10));
		lista.add(new Evento(5555, "Jose", 350, "Despedida", "2021-09-15", 1, "cancelado", "si", 20, 10));
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
	public List<Evento> activos() {//muestra todos los eventos que esten activos
		listaux.clear();//lispiamos toda la lista para que asi no se guarden los datos de otras acciones
		for(Evento eventos: lista){//recorremos toda la lista de eventos
			if(eventos.getEstado().equals("activo")) {//buscando si esta activo
				listaux.add(eventos);//de ser asi añadimos todo el evento a la lista auxiliar creada al principio
			}
		}
		return listaux;//cuando termine de buscar en toda la lista se devolvera el aux con los valores solicitados
	}

	@Override
	public List<Evento> destacados() {//muestra todos los eventos que esten destacados
		listaux.clear();//lispiamos toda la lista para que asi no se guarden los datos de otras acciones
		for(Evento eventos: lista) {//recorremos toda la lista de eventos
			if(eventos.getDestacado().equals("si")) {//buscando si esta destacado
				listaux.add(eventos);//de ser asi añadimos todo el evento a la lista auxiliar creada al principio
			}
		}
		return listaux;//cuando termine de buscar en toda la lista se devolvera el aux con los valores solicitados
	}

}
