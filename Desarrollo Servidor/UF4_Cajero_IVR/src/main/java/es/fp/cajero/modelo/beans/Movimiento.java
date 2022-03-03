package es.fp.cajero.modelo.beans;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.*;



/**
 * The persistent class for the movimientos database table.
 * 
 */
@Entity
@Table(name="movimientos")
@NamedQuery(name="Movimiento.findAll", query="SELECT m FROM Movimiento m")
public class Movimiento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_movimiento")
	private int idMovimiento;

	@Column(name="cantidad")
	private double cantidad;

	@Column(name="fecha")
	private Timestamp fecha;
	
	@Column(name="operacion")
	private String operacion;

	//bi-directional many-to-one association to Cuenta
	@ManyToOne
	@JoinColumn(name="id_cuenta")
	private Cuenta cuenta;

	public Movimiento() {
	}

	public Movimiento(Timestamp fecha, double cantidad, String operacion, Cuenta cuenta) {
		this.fecha = fecha;
		this.cuenta = cuenta;
		this.operacion = operacion;
		this.cantidad = cantidad;
	}
	
	public int getIdMovimiento() {
		return this.idMovimiento;
	}

	public void setIdMovimiento(int idMovimiento) {
		this.idMovimiento = idMovimiento;
	}

	public double getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	public Timestamp getFecha() {
		return this.fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public String getOperacion() {
		return this.operacion;
	}

	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}

	public Cuenta getCuenta() {
		return this.cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idMovimiento;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Movimiento))
			return false;
		Movimiento other = (Movimiento) obj;
		if (idMovimiento != other.idMovimiento)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Movimiento [idMovimiento=" + idMovimiento + ", cantidad=" + cantidad + ", fecha=" + fecha
				+ ", operacion=" + operacion + ", cuenta=" + cuenta + "]";
	}

	
}