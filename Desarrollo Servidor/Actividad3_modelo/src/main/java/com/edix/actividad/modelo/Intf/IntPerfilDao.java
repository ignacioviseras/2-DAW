package com.edix.actividad.modelo.Intf;

import java.util.List;
import com.edix.actividad.modelo.beans.Perfile;

public interface IntPerfilDao {
	
	List<Perfile> findAll();
	Perfile findById(int idPerfil);
	
}
