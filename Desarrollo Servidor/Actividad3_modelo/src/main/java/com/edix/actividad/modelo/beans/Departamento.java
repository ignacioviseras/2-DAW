package com.edix.actividad.modelo.beans;

import java.io.Serializable;



public class Departamento implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private int idDepar;
	private String direccion;
	private String nombre;
	//private Empleado jefeDepar;

	public Departamento() {
	}
	
	public Departamento(int idDepar, String direccion,String nombre){
		this.idDepar = idDepar;
		this.direccion = direccion;
		this.nombre = nombre;
		//this.jefeDepar = jefeDepar;
	}
	public int getIdDepar() {
		return this.idDepar;
	}

	public void setIdDepar(int idDepar) {
		this.idDepar = idDepar;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idDepar;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Departamento))
			return false;
		Departamento other = (Departamento) obj;
		if (idDepar != other.idDepar)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Departamento [idDepar=" + idDepar + ", direccion=" + direccion + ", nombre=" + nombre + ", jefeDepar="
				 + "]";
	}

}