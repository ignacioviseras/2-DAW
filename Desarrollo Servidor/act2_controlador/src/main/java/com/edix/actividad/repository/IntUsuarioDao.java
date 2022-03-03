package com.edix.actividad.repository;

import com.edix.actividad.modelo.beans.Usuario;

public interface IntUsuarioDao {
	Usuario findByID(long logUser);
	long verificacionDatos(String nombreUsuario, String contraseña);
	long altaUsuario(Usuario usuario);
}
