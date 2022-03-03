package com.edix.actividad.modelo.beans;

import java.io.Serializable;
import java.util.Date;

public class Usuario implements Serializable{//implementamos serializable para que se pueda guardar en disco

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long idUsuario;
	private String nombreUsuario;
	private String contraseña;
	private String email;
	private String nombre;
	private int enable;
	private Date fechaLogin;
	
	public Usuario() {
		
	}
	public Usuario(long idUsuario, String nombreUsuario, String contraseña, String email,
			String nombre, int enable, Date fechaLogin) {
		this.idUsuario = idUsuario;
		this.nombreUsuario = nombreUsuario;
		this.contraseña = contraseña;
		this.email = email;
		this.nombre = nombre;
		this.enable = enable;
		this.fechaLogin = fechaLogin;
	}
	
	public long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEnable() {
		return enable;
	}
	public void setEnable(int enable) {
		this.enable = enable;
	}
	public Date getFechaLogin() {
		return fechaLogin;
	}
	public void setFechaLogin(Date fechaLogin) {
		this.fechaLogin = fechaLogin;
	}
	@Override
	public String toString() {
		return "idUsuario=" + idUsuario + ", nombreUsuario=" + nombreUsuario +", contraseña=" + contraseña +
				 ", email=" + email + ", nombre=" + nombre +", enable=" + enable +", fechaLogin=" + fechaLogin;
	}
	
	
}
