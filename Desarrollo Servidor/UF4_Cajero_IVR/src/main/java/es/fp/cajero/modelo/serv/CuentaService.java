package es.fp.cajero.modelo.serv;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import es.fp.cajero.modelo.beans.Cuenta;


public interface CuentaService extends JpaRepository<Cuenta, Integer>{

	/*@Query("update Cuenta c set c.saldo = :saldo where c.idCuenta = :idCuenta")
	/* la sentencia lo q hace es guardar los datos q se les pasa en su correspondiente tabla
	 * :saldo se refiere a la variable dato de aqui abajo ↓
	 * y c.saldo se refiere al saldo de la tabla de la bbdd
	 */
	/*int nuevoSaldo(double saldo, int idCuenta);
	*/
}
