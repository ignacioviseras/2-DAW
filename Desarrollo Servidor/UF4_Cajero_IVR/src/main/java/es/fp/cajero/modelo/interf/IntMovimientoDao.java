package es.fp.cajero.modelo.interf;

import java.util.List;
import java.util.Optional;
import es.fp.cajero.modelo.beans.Movimiento;

public interface IntMovimientoDao {
 
	List<Movimiento> findByCuenta(int id);
	List<Movimiento> findAll();
	Optional<Movimiento> findById(int id);//Recupera una entidad por su id.
	int guardar(Movimiento movimiento);//lo usaremos para guardar los mov de la cuenta

}
