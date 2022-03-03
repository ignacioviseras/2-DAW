package com.edix.actividad.modelo.beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the empleados database table.
 * 
 */
public class Empleado implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private int idEmpl;
	private String correo;
	private String nombre;
	private String contraseña;
	private BigDecimal salario;
	private Perfile perfile;

	public Empleado() {
	}

	public Empleado(int idEmpl, String correo, String nombre, String contraseña, BigDecimal salario,Perfile perfile) {
		this.idEmpl = idEmpl;
		this.correo = correo;
		this.nombre = nombre;
		this.contraseña = contraseña;
		this.salario = salario;
		this.perfile = perfile;
	}
	
	

	@Override
	public String toString() {
		return "Empleado [idEmpl=" + idEmpl + ", correo=" + correo + ", nombre=" + nombre + ", contraseña=" + contraseña
				+ ", salario=" + salario + ", perfile=" + perfile + "]";
	}

	public int getIdEmpl() {
		return this.idEmpl;
	}

	public void setIdEmpl(int idEmpl) {
		this.idEmpl = idEmpl;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getSalario() {
		return this.salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public Perfile getPerfile() {
		return this.perfile;
	}

	public void setPerfile(Perfile perfile) {
		this.perfile = perfile;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idEmpl;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Empleado))
			return false;
		Empleado other = (Empleado) obj;
		if (idEmpl != other.idEmpl)
			return false;
		return true;
	}
	
	
}