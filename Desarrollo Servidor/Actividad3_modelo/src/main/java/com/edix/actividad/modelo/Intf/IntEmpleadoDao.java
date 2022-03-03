package com.edix.actividad.modelo.Intf;

import java.util.List;

import com.edix.actividad.modelo.beans.Empleado;

public interface IntEmpleadoDao {

	Empleado findByid(int idEmpl);
	Empleado verificarLog(int idEmpl, String correo, String contraseña);
	List<Empleado> findAll();
	List<Empleado> findByPerfil(int idPerfil);
	
}
