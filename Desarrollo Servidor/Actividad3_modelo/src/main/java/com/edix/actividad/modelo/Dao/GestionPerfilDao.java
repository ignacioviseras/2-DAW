package com.edix.actividad.modelo.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.edix.actividad.modelo.Intf.IntPerfilDao;
import com.edix.actividad.modelo.beans.Perfile;
@Repository
public class GestionPerfilDao implements IntPerfilDao{
	
	private List<Perfile> perfil;
	
	public GestionPerfilDao() {
		perfil = new ArrayList<Perfile>();
		cargarDatos();
	}
	
	private void cargarDatos() {
		perfil.add(new Perfile(1, "Control de Gestion"));
		perfil.add(new Perfile(2, "Jefe de Proyecto"));
		perfil.add(new Perfile(3, "Operativo"));
		perfil.add(new Perfile(4, "Recursos Humanos"));
		
	}
	
	@Override
	public List<Perfile> findAll() {
		return perfil;
	}

	@Override
	public Perfile findById(int idPerfil) {//busca por id
		for(Perfile pf: perfil) {
			if(pf.getIdPerfil() == idPerfil) {
				return pf;
			}
		}
		return null;
	}

}
