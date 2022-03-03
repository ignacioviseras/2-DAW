package es.fp.cajero.modelo.interf;

import java.util.List;
import es.fp.cajero.modelo.beans.Cuenta;

public interface IntCuentaDao {

	Cuenta verificarLog(int id);
	Cuenta findById(int id);
	int nuevoSaldo(Cuenta cuenta); 
	int operacion(int cuenta, double cantidad, int opcion);//usaremos opcion para saber si vamos a ingresar o a extraer
	int transferencia(Cuenta cuentaEnvia, Cuenta cuentaRecibe, double cantidad);
	List<Cuenta> findAll();
}
