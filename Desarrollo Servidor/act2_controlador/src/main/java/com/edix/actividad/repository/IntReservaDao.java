package com.edix.actividad.repository;

import java.util.List;
import com.edix.actividad.modelo.beans.Reserva;

public interface IntReservaDao {
	List<Reserva> findAll();
	List<Reserva> reservasUsuario(long idUsuario);
	Reserva findBId(long idReserva);
	Reserva buscarReserva(long l, long idEvento);
	int altaReservaa(Reserva reserva);
	boolean verificadorEntradas(long idRes, long l, long idEvento);
}
