package modelo.beans;

import java.io.Serializable;

public class Tipo implements Serializable{


	private static final long serialVersionUID = 1L;
	
	private long ID;
	private String Fiesta, Descripcion;
	
	public Tipo() {
		super();
	}
	public Tipo(long id, String fiesta, String descripcion) {
		super();
		this.ID = id;
		this.Fiesta = fiesta;
		this.Descripcion = descripcion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (ID ^ (ID >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Tipo))
			return false;
		Tipo other = (Tipo) obj;
		if (ID != other.ID)
			return false;
		return true;
	}
	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public String getFiesta() {
		return Fiesta;
	}

	public void setFiesta(String fiesta) {
		Fiesta = fiesta;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Tipo [ID=" + ID + ", Fiesta=" + Fiesta + ", Descripcion=" + Descripcion + "]";
	}
}
