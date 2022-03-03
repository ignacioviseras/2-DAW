package com.ite.ignacio.artefacto.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ite.ignacio.artefacto.interf.IntReservaDao;
import com.ite.ignacio.artefacto.serv.ReservaService;

@Service
public class ReservaDaoImpl implements IntReservaDao{
	@Autowired
	ReservaService rbd;

	@Override
	public int buscarPlaza(int idEvento) {
		return rbd.buscarPlaza(idEvento);
	}
}
