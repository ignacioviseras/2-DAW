package com.ite.ignacio.artefacto.beans;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the reservas database table.
 * 
 */
@Entity
@Table(name="reservas")
@NamedQuery(name="Reserva.findAll", query="SELECT r FROM Reserva r")
public class Reserva implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_RESERVA")
	private int idReserva;

	private int cantidad;

	@Column(name="ID_USUARIO")
	private int idUsuario;

	private String observaciones;

	@Column(name="PRECIO_VENTA")
	private BigDecimal precioVenta;

	//uni-directional many-to-one association to Evento
	@ManyToOne
	@JoinColumn(name="ID_EVENTO")
	private Evento evento;

	public Reserva() {
	}

	public int getIdReserva() {
		return this.idReserva;
	}

	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public BigDecimal getPrecioVenta() {
		return this.precioVenta;
	}

	public void setPrecioVenta(BigDecimal precioVenta) {
		this.precioVenta = precioVenta;
	}

	public Evento getEvento() {
		return this.evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cantidad;
		result = prime * result + ((evento == null) ? 0 : evento.hashCode());
		result = prime * result + idReserva;
		result = prime * result + idUsuario;
		result = prime * result + ((observaciones == null) ? 0 : observaciones.hashCode());
		result = prime * result + ((precioVenta == null) ? 0 : precioVenta.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Reserva))
			return false;
		Reserva other = (Reserva) obj;
		if (cantidad != other.cantidad)
			return false;
		if (evento == null) {
			if (other.evento != null)
				return false;
		} else if (!evento.equals(other.evento))
			return false;
		if (idReserva != other.idReserva)
			return false;
		if (idUsuario != other.idUsuario)
			return false;
		if (observaciones == null) {
			if (other.observaciones != null)
				return false;
		} else if (!observaciones.equals(other.observaciones))
			return false;
		if (precioVenta == null) {
			if (other.precioVenta != null)
				return false;
		} else if (!precioVenta.equals(other.precioVenta))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Reserva [idReserva=" + idReserva + ", cantidad=" + cantidad + ", idUsuario=" + idUsuario
				+ ", observaciones=" + observaciones + ", precioVenta=" + precioVenta + ", evento=" + evento + "]";
	}

	
}