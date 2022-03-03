package com.edix.actividad.repository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.edix.actividad.modelo.beans.Reserva;

@Repository
public class GestionReservasImpList implements IntReservaDao{
	private List<Reserva> lista;
	private List<Reserva> listaux;
	
	public GestionReservasImpList() {
		lista = new ArrayList<>();
		listaux = new ArrayList<>();
		cargar();
	}
	
	public void cargar() {
		
	}
	
	@Override
	public List<Reserva> findAll() {
		return lista;
	}

	@Override
	public List<Reserva> reservasUsuario(long idUsuario) {
		listaux.clear();//limpiamos el aux para que no tenga nada de otras veces q se use
		for(Reserva reserva: lista) {//recorremos la lista de reservas
			if(reserva.getIdUsuario() == idUsuario){//buscando que coincida el id de usuario
				listaux.add(reserva);//de tal manera que se guardara a ese usuario
			}
		}
		return listaux;//y devolvemos el array con el usuario solicitado
	}

	@Override
	public Reserva findBId(long idReserva) {
		for(Reserva reservas: lista) {//recorremos la lista de reservas
			if(reservas.getIdReserva() == idReserva) {//buscamos que si la id que se nos pasa se encuentra en el array
				return reservas;//de ser asi devolvemos la reserva entera
			}
		}
		return null;
	}

	@Override
	public Reserva buscarReserva(long idUsuario, long idEvento) {
		for(Reserva reserva:lista) {//recorremos el array de reservas
			if(reserva.getIdUsuario() == idUsuario && reserva.getIdEvento() == idEvento) {//y vamos buscando la reserva que se nos pasa
				//de tal manera que comparamos el idUsuario y el idEvento de tal manera que si coinciden los 2 es la reserva que queremos
				return reserva;//y la devolvemos
			}
		}
		return null;
	}

	@Override
	public int altaReservaa(Reserva reserva) {//para dar de alta una reserva
		if(lista.contains(reserva)) {//lo primero que hacemos es comprobar si la reserva ya se hizo
			return 1;
		}else {//si no se hizo
			reserva.setIdReserva(lista.size()+1);//nos vamos a la ultima posicion del array y optenemos el numero siguiente y se lo ponemos al id
			lista.add(reserva);//añadimos la reserva al array
		}
		return 0;
	}

	@Override
	public boolean verificadorEntradas(long idRes, long cant, long idEvento) {
		boolean verificador = false;
		for(Reserva reserva : lista) {//recorremos la lista de reserva
			if(reserva.getIdReserva() == idRes && reserva.getIdEvento()== idEvento) {//comprobamos que existen los ids que nos han pasado
				if(10 >= (reserva.getCantidad() + cant)) {//de ser asi comprobamos que su cantida de reservas + la cantidad de reservas que quiere hacer sea menor a 10
					verificador = true;//de ser asi decimos que si puede hacer la reserva
				}
			}
		}
		return verificador;//de lo contrario decimos que no puede hacer la reserva
	}

}
