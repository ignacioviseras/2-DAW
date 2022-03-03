package com.edix.actividad.modelo.Intf;

import java.util.List;

import com.edix.actividad.modelo.beans.Cliente;

public interface IntClienteDao {
	List<Cliente> findAll();
	Cliente findByCif(String cif);
	int altaCliente(Cliente cliente);
}
