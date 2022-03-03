package com.ite.ignacio.artefacto.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ite.ignacio.artefacto.beans.Evento;
import com.ite.ignacio.artefacto.interf.IntEventoDao;
import com.ite.ignacio.artefacto.serv.EventoService;

@Service
public class EventoDaoImpl implements IntEventoDao{

	@Autowired
	EventoService ebd;
	
	@Override
	public List<Evento> findAll() {
		return ebd.findAll();
	}

	@Override
	public List<Evento> verActivo() {
		return ebd.buscarActivos();
	}

	@Override
	public List<Evento> verDestacado() {
		return ebd.buscarDestacado();
	}

	@Override
	public List<Evento> buscarEvento(String dt) {
		return ebd.buscarEvento(dt);
	}
//-------------lo de arriab es llamand al las query de servide------------------------------------
	@Override
	public int insertar(Evento evento) {
		if(verUno(evento.getIdEvento()) == null) {//si es null significa q no existe entonces lo podremos crear
			ebd.save(evento);//lo guardaremos
			return 1;//devolvemos 1 para decir q se pudo realizar
		}else
			return 0;//devolvemos 0 para decir q no se pudo realizar
	}

	@Override
	public int modificar(Evento evento) {//recibimos u evento entero
		if(verUno(evento.getIdEvento()) != null) {//si no es null
			ebd.save(evento);//lo guardaremos para asi poder modificarlo
			return 1;//devolvemos 1 para decir q se pudo realizar
		}else
			return 0;//devolvemos 0 para decir q no se pudo realizar
	}

	@Override
	public int eliminar(int evento) {//recibimos el event
		if(verUno(evento) != null) {//si no es null
			ebd.deleteById(evento);//lo eliminamos
			return 1;//y decimos q se pudo realizar cn existo
		}
		return 0;//si no damos 0
	}

	@Override
	public Evento verUno(int idEvento) {
		return ebd.findById(idEvento).orElse(null);//buscamos por el id en caso de q no encuentres nada es null
	}

}
