package com.ite.ignacio.artefacto.serv;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ite.ignacio.artefacto.beans.Evento;

public interface EventoService extends JpaRepository<Evento, Integer>{

	@Query("select ev from Evento ev where ev.tipo.idTipo = ?1")//busca en la tabla evento donde corresponda a el idTipo q se nos pasa
	public List<Evento> buscarTipo(int idTipo);//no lo uso pq no se pide en la act esto es del video del dia 27/01
	
	@Query("select ev from Evento ev where ev.estado = 'Activo'")//busca los eventos q esten activos de la tabla eventos
	public List<Evento> buscarActivos();
	
	@Query("select ev from Evento ev where ev.destacado = 's'")//busca en eventos un evento q este destacado
	public List<Evento> buscarDestacado();
	
	@Query("select ev from Evento ev where ev.nombre like %?1%")//busca en evento nombres q empiezen por la cadena q se nos pasa es decir si tienes paco si pones pa aparece paco
	public List<Evento> buscarEvento(String dt);
	
}
