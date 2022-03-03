package com.ite.ignacio.artefacto.interf;

import java.util.List;
import com.ite.ignacio.artefacto.beans.Evento;

public interface IntEventoDao {

	List<Evento> findAll();
	List<Evento> verActivo();
	List<Evento> verDestacado();
	List<Evento> buscarEvento(String dt);
	int insertar (Evento evento);
	int modificar (Evento evento);
	int eliminar (int evento);
	Evento verUno (int idEvento);
}
