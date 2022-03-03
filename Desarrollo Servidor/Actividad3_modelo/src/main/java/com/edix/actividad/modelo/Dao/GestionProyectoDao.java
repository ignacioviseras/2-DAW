package com.edix.actividad.modelo.Dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.edix.actividad.modelo.Intf.IntProyectoDao;
import com.edix.actividad.modelo.beans.Empleado;
import com.edix.actividad.modelo.beans.Proyecto;
@Repository
public class GestionProyectoDao implements IntProyectoDao{

	private List<Proyecto> proy;
	private List<Proyecto> proax;
	
	public GestionProyectoDao() {
		proy = new ArrayList<>();
		proax = new ArrayList<>();
	}
	
	
	@Override
	public List<Proyecto> findAll() {
		return proy;
	}

	@Override
	public Proyecto findById(int idProyecto) {//busqueda por id
		for(Proyecto pry: proy ) {
			if(pry.getIdProyecto() == idProyecto) {
				return pry;
			}
			return null;
		}
		return null;
	}
	
	@Override
	public int altaProyecto(Proyecto proyecto) {//alta del proyecti comprueba si esta en el array y si no esta lo añade y lo mete en activo
		if(proy.contains(proyecto)) {
			return 1;
		}else {	
			proyecto.setEstado("activo");//se pone el estado en activo automaticamnet
			proy.add(proyecto);//se añade el proyexy
			return 0;
		}
		
	}
	
	@Override
    public List<Proyecto> activos(int idjefe) {//muestra todos los eventos que esten activos
		proax.clear();//lispiamos toda la lista para que asi no se guarden los datos de otras acciones
		
		for(Proyecto proyecto: proy){//recorremos toda la lista de eventos
			if(proyecto.getEstado().equals("activo") && proyecto.getJefeProyecto().getIdEmpl()==idjefe) {//buscando si esta activo
            	proax.add(proyecto);//de ser asi añadimos todo el evento a la lista auxiliar creada al principio
            }
        }
        return proax;//cuando termine de buscar en toda la lista se devolvera el aux con los valores solicitados
    }

	@Override
	public int terminarProyecto(int idProyecto, BigDecimal cr) {//metodo que accede al proyecto y le asigna el coste final
		Proyecto proyecto= findById(idProyecto);
			if(proyecto != null) {
				proyecto.setCosteReal(cr);//se asigna el valor q nos pasan
				proyecto.setEstado("Terminado");//y lo cambia a terminado
				return 0;
			}
		return 1;
	}
	
	

}
