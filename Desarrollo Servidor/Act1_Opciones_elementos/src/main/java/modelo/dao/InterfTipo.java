package modelo.dao;

import java.util.List;

import modelo.beans.Tipo;

public interface InterfTipo {

	List<Tipo> findAll();//busca todo
	Tipo findById(long id);//busca por el id
	int insertOne(Tipo Tipo);//buscas un evento y te lo devuelve
	int deleteOne(long id);
}
