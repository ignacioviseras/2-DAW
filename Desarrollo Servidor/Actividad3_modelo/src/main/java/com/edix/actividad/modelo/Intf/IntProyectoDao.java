package com.edix.actividad.modelo.Intf;

import java.math.BigDecimal;
import java.util.List;

import com.edix.actividad.modelo.beans.Proyecto;

public interface IntProyectoDao {
	List<Proyecto> findAll();
	int altaProyecto(Proyecto proyecto);
	int terminarProyecto(int idProyecto, BigDecimal cr);
	Proyecto findById(int idProyecto);
	List<Proyecto> activos(int idjefe);
}
