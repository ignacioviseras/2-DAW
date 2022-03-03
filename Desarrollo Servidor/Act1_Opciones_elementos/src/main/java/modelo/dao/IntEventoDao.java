package modelo.dao;

import java.util.List;

import modelo.beans.Evento;

public interface IntEventoDao {
	
	List<Evento> findAll();//busca todo
	Evento findById(long id);//busca por el id
	int insertOne(Evento Evento);//buscas un evento y te lo devuelve
	int deleteOne(long id);
}
