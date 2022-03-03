package com.edix.actividad.modelo.Dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.edix.actividad.modelo.Intf.IntProductoDao;
import com.edix.actividad.modelo.beans.Producto;
@Repository
public class GestionProductoDao implements IntProductoDao{

	private List<Producto> prd;
	
	public GestionProductoDao() {
		prd = new ArrayList<Producto>();
		cargarDatos();
	}
	
	private void cargarDatos() {
		prd.add(new Producto(1, "asd", "qwe", new BigDecimal(10), 2));

	}
	
	@Override
	public List<Producto> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Producto findById(int idProducto) {//muestrta el producto q nos pasan si existe
		for(Producto pd: prd) {
			if(pd.getIdProducto() == idProducto) {
				return pd;
			}
		}
		return null;
	}

	@Override
	public int altaCliente(Producto producto) {//da de alta un cliente
		if(prd.contains(producto)) {
			return 1;
		}else {
			prd.add(producto);
		}
		return 0;
	}

}
