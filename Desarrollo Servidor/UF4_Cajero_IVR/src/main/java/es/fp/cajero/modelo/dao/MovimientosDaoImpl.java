package es.fp.cajero.modelo.dao;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import es.fp.cajero.modelo.beans.Movimiento;
import es.fp.cajero.modelo.serv.MovimientosService;
import es.fp.cajero.modelo.interf.IntMovimientoDao;

@Service
public class MovimientosDaoImpl implements IntMovimientoDao{

	@Autowired
	MovimientosService bd;
	
	
	//todos estos metodos son usando la libreria del JpaRepository
	@Override
	public List<Movimiento> findByCuenta(int id) {
		return bd.findByCuenta(id);
	}

	@Override
	public List<Movimiento> findAll() {
		return bd.findAll();
	}

	@Override
	public Optional<Movimiento> findById(int id) {
		return bd.findById(id);
	}

	@Override
	public int guardar(Movimiento movimiento) {
	        try {
	            bd.save(movimiento);//se guarda el movimiento de la cuenta
	            return 0;
	        }catch (Exception e){//si hay un problema nos suelta el error
	            return 1;
	        }
	}

}
