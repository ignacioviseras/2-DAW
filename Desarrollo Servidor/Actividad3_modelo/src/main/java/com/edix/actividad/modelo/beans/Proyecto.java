package com.edix.actividad.modelo.beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


public class Proyecto implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private int idProyecto;
	private BigDecimal costeReal;
	private BigDecimal costesPrevisto;
	private String descripcion;
	private String estado;
	private Cliente cliente;
	private Empleado jefeProyecto;
	
	public Proyecto() {
	}

	public Proyecto(int idProyecto, BigDecimal costesPrevisto, String descripcion, String estado) {
		super();
		this.idProyecto = idProyecto;
		this.costesPrevisto = costesPrevisto;
		this.descripcion = descripcion;
	}

	public int getIdProyecto() {
		return this.idProyecto;
	}

	public void setIdProyecto(int idProyecto) {
		this.idProyecto = idProyecto;
	}

	public BigDecimal getCosteReal() {
		return this.costeReal;
	}

	public void setCosteReal(BigDecimal costeReal) {
		this.costeReal = costeReal;
	}

	public BigDecimal getCostesPrevisto() {
		return this.costesPrevisto;
	}

	public void setCostesPrevisto(BigDecimal costesPrevisto) {
		this.costesPrevisto = costesPrevisto;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Empleado getJefeProyecto() {
		return this.jefeProyecto;
	}

	public void setJefeProyecto(Empleado jefeProyecto) {
		this.jefeProyecto = jefeProyecto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idProyecto;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Proyecto))
			return false;
		Proyecto other = (Proyecto) obj;
		if (idProyecto != other.idProyecto)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Proyecto [idProyecto=" + idProyecto + ", costeReal=" + costeReal + ", costesPrevisto=" + costesPrevisto
				+ ", descripcion=" + descripcion + ", estado=" + estado + ", cliente=" + cliente.toString() + ", jefeProyecto="
				+ jefeProyecto.toString() + "]";
	}

}