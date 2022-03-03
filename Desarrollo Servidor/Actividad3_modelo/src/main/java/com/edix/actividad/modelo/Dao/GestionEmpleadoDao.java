package com.edix.actividad.modelo.Dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.edix.actividad.modelo.Intf.IntEmpleadoDao;
import com.edix.actividad.modelo.Intf.IntPerfilDao;
import com.edix.actividad.modelo.beans.Empleado;
import com.edix.actividad.modelo.beans.Perfile;


@Repository
public class GestionEmpleadoDao implements IntEmpleadoDao{

	
	private List<Empleado> newempleado;
	private List<Empleado> newempleadoax;
	
	public GestionEmpleadoDao() {
		newempleado = new ArrayList<Empleado>();
		newempleadoax = new ArrayList<Empleado>();
		cargardatos();
	}
	
	private void cargardatos() {
		IntPerfilDao perfile;
		perfile = new GestionPerfilDao();
		newempleado.add(new Empleado(1, "asd.asd@gmail.com", "pepe", "asd", new BigDecimal(200), perfile.findById(1)));
		newempleado.add(new Empleado(2, "qwe.qwe@gmail.com", "juan", "asd", new BigDecimal(300), perfile.findById(2)));
	}
	
	@Override
	public List<Empleado> findAll() {
		return newempleado;
	}
	
	@Override
	public Empleado findByid(int idEmpl) {//busca por id y ,uestra
		for(Empleado empleado: newempleado ) {
			if(empleado.getIdEmpl() == idEmpl) {
				return empleado;
			}
		}
		return null;
	}

	@Override
	public List<Empleado> findByPerfil(int idPerfil) {//muestra el perfil que pasamos
		newempleadoax.clear();
		for(Empleado empleado: newempleado ) {
			if(empleado.getPerfile().getIdPerfil() == idPerfil)
				newempleadoax.add(empleado);
		}
		return newempleadoax;
	}
	
	
	
	@Override
	public Empleado verificarLog(int idEmpl, String correo, String contraseña) {//comprueba si lo q le pasan esta bn de ser asi pasa el dato de empleado entero
		for(Empleado emp: newempleado) {
			if(emp.getIdEmpl()==idEmpl && emp.getCorreo().equals(correo) && emp.getContraseña().equals(contraseña)) {
					return emp;
			}	
		}
		return null;
	}


}
