package es.fp.cajero.modelo.Controller;


import java.time.Instant;
import java.sql.Timestamp;
import org.springframework.ui.Model;
import javax.servlet.http.HttpSession;
import es.fp.cajero.modelo.beans.Cuenta;
import es.fp.cajero.modelo.beans.Movimiento;
import es.fp.cajero.modelo.interf.IntCuentaDao;
import org.springframework.stereotype.Controller;
import es.fp.cajero.modelo.interf.IntMovimientoDao;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/acciones")
public class accionesController {
	@Autowired
	IntCuentaDao cuen;
	
	@Autowired
	IntMovimientoDao mov;
	
	Instant instnt = Instant.now();//saca un punto de tiempo para asi poder utilizarlo luego para saber cuando se hizo la operacion
	//-----------ingreso---------------------------------
	@PostMapping("/ingresa")
	public String ingresar(@RequestParam("cantidad") double cant, HttpSession sess) {
		Timestamp timstamp = Timestamp.from(instnt);//sacamos la instancia de arriba para guardar el dato de tiempo
		Cuenta cuenta= cuen.findById((int) sess.getAttribute("idSessCuent"));//casteo el session a un int para q lo reciba cuenta
		System.out.println( "linea 39"+ cuenta);
		if(cuen.operacion(cuenta.getIdCuenta(), cant, 2) == 0) //se cimprueba antes q nada q el return sea 0 (esto significa que estarian bn los datos)
			mov.guardar(new Movimiento(timstamp, cant, "ingresoo", cuenta));//guardamos los datos para que se meta en la bbd
		
		return "redirect:/";//no redirecciona al inicio al terminar la operacion
	}
	//------------retirada es casi igual q el de ↑-----------------------------------------
	@PostMapping("/retira")
	public String retirada(@RequestParam("cantidad") double cant, HttpSession sess) {
		Timestamp timstamp = Timestamp.from(instnt);//sacamos la instancia de arriba para guardar el dato de tiempo
		Cuenta cuenta = cuen.findById((int) sess.getAttribute("idSessCuent"));//casteo el session a un int para q lo reciba cuenta
		if(cuen.operacion(cuenta.getIdCuenta(), cant, 1) == 0) //se cimprueba antes q nada q el return sea 0 (esto significa que estarian bn los datos)
			mov.guardar(new Movimiento(timstamp, cant, "retirada", cuenta));//guardamos los datos para que se meta en la bbd
			return "redirect:/";//no redirecciona al inicio al terminar la operacion
		
	}
	//-------------Verr movimientos--------------!!!ojo es get q no post te tiraste 30m para verlo melon!!!--------------------------
	@GetMapping("/ver")
	public String verMovimien(Model mod, HttpSession sess) {
		
		if(sess.getAttribute("idSessCuent") == null) {//si es null la sesion te mete para q inicies
			return "redirect:/login";
		}else {//si no lo es te metera en la pag con la salida de tus datos
			Cuenta cuenta = cuen.findById((int) sess.getAttribute("idSessCuent"));//casteo el session a un int para q lo reciba cuenta
			mod.addAttribute("cuenta", cuenta);//guardams la cuenta en cuenta ara poder sacarla luego
			mod.addAttribute("movimiento", mov.findByCuenta(cuenta.getIdCuenta()));
			return "verMovimient";
		}
	}
	//--------------intentto de transferencia---------------------------
	@PostMapping("/transferencia")
	public String transferencia(@RequestParam("cantidad") double cant, @RequestParam("cuentaTransfern") int cuentaTransfern, HttpSession sess, RedirectAttributes red) {
		//Cuenta cuenta = (Cuenta) sess.getAttribute("idSessCuent");//casteo el session a un int para q lo reciba cuenta
		Cuenta cuenta = cuen.findById((int) sess.getAttribute("idSessCuent"));//casteo el session a un int para q lo reciba cuenta

		if(cuen.findById(cuentaTransfern) != null) {
			if(cuen.transferencia(cuenta, cuen.findById(cuentaTransfern), cant)== 0){//si la operacion entera devuelv 0 significa q se realizo bn
				red.addFlashAttribute("dato cuenta mal");//si el dato de la cuenta de destino esta mal te vuelve a meter en la pag de transferencia
				return "transferencia";
			}else {
				red.addFlashAttribute("Saldo negativo");
				return "transferencia";
			}
			
		}
		return "redirect:/login";
		}
		
	}
	
	

