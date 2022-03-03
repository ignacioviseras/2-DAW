package com.edix.actividad.repository;

import java.util.List;
import com.edix.actividad.modelo.beans.Evento;

public interface IntEventoDao {
	
	List<Evento> findAll();//busca todo
	Evento findById(long id);//busca por el id
	List<Evento> activos();//muestra todos los eventos que esten activos
	List<Evento> destacados();//muestra todos los eventos que esten destacados
}
