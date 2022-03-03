package es.fp.cajero.modelo.serv;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import es.fp.cajero.modelo.beans.Movimiento;

public interface MovimientosService extends JpaRepository<Movimiento, Integer>{
	
	@Query("select m from Movimiento m where m.cuenta.idCuenta = ?1")
	/*
	 * m where m.cuenta.idCuenta = ?1 
	 * el where ese es darle el valor que sacas de tu codigo y se lo asignias a m
	 * y luego buscas select m from movimientos
	 * */
	List<Movimiento> findByCuenta(int id);

	
}
