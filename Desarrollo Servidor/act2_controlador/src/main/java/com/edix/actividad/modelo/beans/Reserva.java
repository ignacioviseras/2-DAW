package com.edix.actividad.modelo.beans;

import java.io.Serializable;

public class Reserva implements Serializable{//implementamos serializable para que se pueda guardar en disco
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long idUsuario;
	private long idReserva;
	private long idEvento;
	private int precio;
	private int cantidad;
	private String observaciones;

	public Reserva() {
		
	}
	public Reserva(long idUsuario, long idEvento, int precio, int cantidad, String observaciones) {
		this.idUsuario = idUsuario;
		this.idEvento = idEvento;
		this.precio = precio;
		this.cantidad = cantidad;
		this.observaciones = observaciones;
	}
	public long getIdReserva() {
		return idReserva;
	}
	public void setIdReserva(long idReserva) {
		this.idReserva = idReserva;
	}
	public long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public long getIdEvento() {
		return idEvento;
	}
	public void setIdEvento(long idEvento) {
		this.idEvento = idEvento;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	@Override
	public String toString() {
		return "Reserva [idReserva=" + idReserva + ", idUsuario=" + idUsuario + ", idEvento=" + idEvento + ", precio="
				+ precio + ", cantidad=" + cantidad + ", observaciones=" + observaciones + "]";
	}
	
	
}
