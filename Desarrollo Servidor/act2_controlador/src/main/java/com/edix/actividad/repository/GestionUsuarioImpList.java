package com.edix.actividad.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.edix.actividad.modelo.beans.Usuario;

@Repository
public class GestionUsuarioImpList implements IntUsuarioDao{
	private List<Usuario> lista;
	
	public GestionUsuarioImpList() {
		lista = new ArrayList<>();
		cargarDatos();
	}
	
	public void cargarDatos() {
		lista.add(new Usuario(1, "pacolo", "paquillo", "paco.asd@gmail.com", "paco", 1, null));
		lista.add(new Usuario(2, "fran", "fracito", "fran.asd@gmail.com", "fran", 2, null));
	}
	
	@Override
	public Usuario findByID(long idUsuario) {
		for(Usuario usuario : lista) {//recorremos la lista de usuarios 
			if(usuario.getIdUsuario() == idUsuario) {//comprobando que tenga el mismo valor que el id que pasamos
				return usuario;//de ser asi devolvemos el usuario entero
			}
		}
		return null;//si no lo encontramos devolvemos un nulo
	}

	@Override
	public long verificacionDatos(String nombreUsuario, String contraseña) {
		long id = 0;
		for(Usuario usuario : lista) {//recorremos el array de usuarios
			if(nombreUsuario.equals(usuario.getNombreUsuario()) && contraseña.equals(usuario.getContraseña())){
				//y vamos comprobando si el nombreUsuario que recibimos es igual al nombreUsuario del array lo mismo con la contraseña
				id = usuario.getIdUsuario();//de ser verdad en los 2 casos pararemos el id del usuario a la variable id que tenemos arriba
				break;//rompemos el if
			}
		}
		return id;//y devolveremos el id
	}

	@Override
	public long altaUsuario(Usuario usuario) {//dar de alta un usuario
		if(lista.contains(usuario))//se comprueba si se la lista contiene ese usuario
			return 1;//de ser asi se sale de la ejecucion
		else{//de lo contrario
			lista.add(usuario);//añade el usuario
			return 0;
		}
	}

}
