package com.edix.actividad.modelo.beans;

import java.io.Serializable;



public class Perfile implements Serializable {


	private static final long serialVersionUID = 1L;

	
	private int idPerfil;
	private String nombre;

	public Perfile(int idPerfil, String nombre){
		this.idPerfil = idPerfil;
		this.nombre = nombre;
	}
	
	public Perfile() {
	}

	public int getIdPerfil() {
		return this.idPerfil;
	}

	public void setIdPerfil(int idPerfil) {
		this.idPerfil = idPerfil;
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
		result = prime * result + idPerfil;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Perfile))
			return false;
		Perfile other = (Perfile) obj;
		if (idPerfil != other.idPerfil)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Perfile [idPerfil=" + idPerfil + ", nombre=" + nombre + "]";
	}
	
	
}