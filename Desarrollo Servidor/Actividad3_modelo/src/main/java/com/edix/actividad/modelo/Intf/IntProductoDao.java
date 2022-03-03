package com.edix.actividad.modelo.Intf;

import java.util.List;
import com.edix.actividad.modelo.beans.Producto;


public interface IntProductoDao {
	List<Producto> findAll();
	Producto findById(int idProducto);
	int altaCliente(Producto producto);
}
