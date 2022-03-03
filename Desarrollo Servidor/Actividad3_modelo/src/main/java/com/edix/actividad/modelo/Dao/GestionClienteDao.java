package com.edix.actividad.modelo.Dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.edix.actividad.modelo.Intf.IntClienteDao;
import com.edix.actividad.modelo.beans.Cliente;

@Repository
public class GestionClienteDao implements IntClienteDao{

	private List<Cliente> cli;
	
	public GestionClienteDao() {
		cli = new ArrayList<Cliente>();
		cargarDato();
	}
	
	public void cargarDato() {
		cli.add(new Cliente("123456", "casa", new BigDecimal(50), "cliente1", 1));
	}
	
	@Override
	public List<Cliente> findAll() {
		
		return cli;
	}

	@Override
	public Cliente findByCif(String cif) {//muestra el cliente que nos pasan el cif si existe
		for(Cliente cl: cli ) {
			if(cl.getCif().equals(cif)) {
				return cl;
			}
		}
		return null;
	}

	@Override
	public int altaCliente(Cliente cliente) {//da de alta en caso de no existir
		if(cli.contains(cliente)) {
			return 1;
		}else {
			cli.add(cliente);
		}
		return 0;
	}

}
