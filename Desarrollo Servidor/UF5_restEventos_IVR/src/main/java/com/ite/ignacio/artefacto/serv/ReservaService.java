package com.ite.ignacio.artefacto.serv;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.ite.ignacio.artefacto.beans.Reserva;

public interface ReservaService extends JpaRepository<Reserva, Integer>{
@Query("Select sum(r.cantidad) from Reserva r where r.evento.idEvento = ?1")
public Integer buscarPlaza(int idEvento);
}
