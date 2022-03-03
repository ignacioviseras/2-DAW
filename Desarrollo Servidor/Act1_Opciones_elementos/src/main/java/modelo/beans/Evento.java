package modelo.beans;

import java.io.Serializable;

public class Evento implements Serializable{//implementamos serializable para que se pueda guardar en disco

	private static final long serialVersionUID = 1L;

	private long id;
	private String nombre;
	private int precio;
	private String descripcion;
	private String fechaInicio;
	private int duracion_dias;
	private String estado;
	private String destacado;
	private int maxAforo;
	private int minAforo;
	private Tipo iDTipo;//este dato es de la clase tipo
	
	public Evento(long id, String nombre, int precio, String descripcion, String fechaInicio, int duracion_dias,
			String estado, String destacado, int maxAforo, int minAforo, Tipo iDTipo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.descripcion = descripcion;
		this.fechaInicio = fechaInicio;
		this.duracion_dias = duracion_dias;
		this.estado = estado;
		this.destacado = destacado;
		this.maxAforo = maxAforo;
		this.minAforo = minAforo;
		this.iDTipo = iDTipo;//este dato es de la clase tipo
	}
	
	public Evento() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Evento))
			return false;
		Evento other = (Evento) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public int getDuracion_dias() {
		return duracion_dias;
	}

	public void setDuracion_dias(int duracion_dias) {
		this.duracion_dias = duracion_dias;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getDestacado() {
		return destacado;
	}

	public void setDestacado(String destacado) {
		this.destacado = destacado;
	}

	public int getMaxAforo() {
		return maxAforo;
	}

	public void setMaxAforo(int maxAforo) {
		this.maxAforo = maxAforo;
	}

	public int getMinAforo() {
		return minAforo;
	}

	public void setMinAforo(int minAforo) {
		this.minAforo = minAforo;
	}

	@Override
	public String toString() {
		return "Evento [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", descripcion=" + descripcion
				+ ", fechaInicio=" + fechaInicio + ", duracion_dias=" + duracion_dias + ", estado=" + estado
				+ ", destacado=" + destacado + ", maxAforo=" + maxAforo + ", minAforo=" + minAforo + ", iDTipo="
				+ iDTipo + "]";
	}

	public Tipo getIdTipo() {
		return iDTipo;
	}

	public void setIdTipo(Tipo iDTipo) {
		this.iDTipo = iDTipo;
	}
}