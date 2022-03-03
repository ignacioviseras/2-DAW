package com.edix.actividad.modelo.beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;


public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private int idProducto;
	private String descripcionBreve;
	private String descripcionLarga;
	private BigDecimal precioUnitario;
	private int stock;
	private List<ProyectoConProducto> proyectoConProductos;

	public Producto(int idProducto, String descripcionBreve, String descripcionLarga, BigDecimal precioUnitario, int stock) {
		this.idProducto = idProducto;
		this.descripcionBreve = descripcionBreve;
		this.descripcionLarga = descripcionLarga;
		this.precioUnitario = precioUnitario;
		this.stock = stock;
	}
	
	public Producto() {
	}

	public int getIdProducto() {
		return this.idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getDescripcionBreve() {
		return this.descripcionBreve;
	}

	public void setDescripcionBreve(String descripcionBreve) {
		this.descripcionBreve = descripcionBreve;
	}

	public String getDescripcionLarga() {
		return this.descripcionLarga;
	}

	public void setDescripcionLarga(String descripcionLarga) {
		this.descripcionLarga = descripcionLarga;
	}

	public BigDecimal getPrecioUnitario() {
		return this.precioUnitario;
	}

	public void setPrecioUnitario(BigDecimal precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public int getStock() {
		return this.stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public List<ProyectoConProducto> getProyectoConProductos() {
		return this.proyectoConProductos;
	}

	public void setProyectoConProductos(List<ProyectoConProducto> proyectoConProductos) {
		this.proyectoConProductos = proyectoConProductos;
	}

	public ProyectoConProducto addProyectoConProducto(ProyectoConProducto proyectoConProducto) {
		getProyectoConProductos().add(proyectoConProducto);
		proyectoConProducto.setProducto(this);

		return proyectoConProducto;
	}

	public ProyectoConProducto removeProyectoConProducto(ProyectoConProducto proyectoConProducto) {
		getProyectoConProductos().remove(proyectoConProducto);
		proyectoConProducto.setProducto(null);

		return proyectoConProducto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idProducto;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Producto))
			return false;
		Producto other = (Producto) obj;
		if (idProducto != other.idProducto)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Producto [idProducto=" + idProducto + ", descripcionBreve=" + descripcionBreve + ", descripcionLarga="
				+ descripcionLarga + ", precioUnitario=" + precioUnitario + ", stock=" + stock
				+ ", proyectoConProductos=" + proyectoConProductos + "]";
	}
	
	
}