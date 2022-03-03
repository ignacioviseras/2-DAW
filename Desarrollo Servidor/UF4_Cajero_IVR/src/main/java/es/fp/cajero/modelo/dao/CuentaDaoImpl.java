package es.fp.cajero.modelo.dao;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.fp.cajero.modelo.beans.Cuenta;
import es.fp.cajero.modelo.beans.Movimiento;
import es.fp.cajero.modelo.interf.IntCuentaDao;
import es.fp.cajero.modelo.serv.CuentaService;
import es.fp.cajero.modelo.serv.MovimientosService;

@Service
public class CuentaDaoImpl implements IntCuentaDao{

	@Autowired
	MovimientosService bdMov;
	
	@Autowired
	CuentaService bdCue;
	
	@Override
	public Cuenta verificarLog(int id) {
		return bdCue.findById(id).orElse(null);//pdf uf4_WBT4 pag5 explica el uso de orElse
		//resumido es la manera facil de hacer la comprobacion de si no esta el dato q te saque el nulo
		//lo q se haria con if
	}

	@Override
	public Cuenta findById(int id) {
		return bdCue.findById(id).orElse(null);//pdf uf4_WBT4 pag5 explica el uso de orElse
		//resumido es la manera facil de hacer la comprobacion de si no esta el dato q te saque el nulo
	}

	@Override
	public List<Cuenta> findAll() {
		return bdCue.findAll();
	}

	@Override
	public int nuevoSaldo(Cuenta cuenta) {
		int filas = 0;
		try {
			bdCue.save(cuenta);
			filas=1;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return filas;
	}
	
	@Override
	public int operacion(int cuenta, double cantidad, int opcion) {
		if(findById(cuenta) != null) {
			double  dinero;
			Cuenta cuenO = findById(cuenta);
			dinero = findById(cuenta).getSaldo();
			switch (opcion) {
				case 1://retirar
					if(dinero > 0) {//comprobamos si hay dinero para retirar
						if(dinero <= cantidad) {//un if para comprobar que el dinero que queremos retirar sea menos o lo mismo que tienes en la cuenta
							cuenO.setSaldo(dinero - cantidad);
							nuevoSaldo(cuenO);//actualizamos el dato de la cuenta con el dinero que vamos a quitar
							break;
						}else
						break;
					}else
					break;
				case 2://ingresar
					//no se necesita comprobacion pq al añadir dinero no necesitas saber el estado de la cuenta
					cuenO.setSaldo(dinero + cantidad);
					nuevoSaldo(cuenO);//actualizamos el dato de la cuenta con el dinero que vamos a quitar
					break;
				default://si no es ninguna de las 2 te saca
					break;
				}
				return 0;
			}else {
				return 1;//suelta un 1 diciendo""""" que no se pudo realizar nada ya q es null
			}
	}

	@Override
	public int transferencia(Cuenta cuentaEnvia, Cuenta cuentaRecibe, double cantidad) {
		System.out.println(cuentaRecibe);
		if(operacion(cuentaEnvia.getIdCuenta(), cantidad, 1) == 0) {//aqui se hace el retirar | se cimprueba antes q nada q el return sea 0 (esto significa que estarian bn los datos)
			Instant instantEnvia = Instant.now();
			Timestamp timestampEnvia = Timestamp.from(instantEnvia);//es una secuencia de caracteres que denotan la hora y fecha en la/s que ocurrió
			
			//basicamente las 2 lineas de arriba es para guardar a q hora y que dia se hizo la transaccion
		
		if(operacion(cuentaRecibe.getIdCuenta(), cantidad, 2) == 0) {//para ingresar lo mismo con la comprobacion esa
			Instant instant = Instant.now();
			Timestamp timestamp = Timestamp.from(instant);//es una secuencia de caracteres que denotan la hora y fecha en la/s que ocurrió
			//basicamente las 2 lineas de arriba es para guardar a q hora y que dia se hizo la transaccion
			bdMov.save(new Movimiento(timestamp, cantidad, "ingreso por transferencia", cuentaRecibe));
			bdMov.save(new Movimiento(timestampEnvia, cantidad, "retiro-de-transferencia", cuentaEnvia));
			
		}
			return 0;
		}else {
			return 1;
			}
}


}
