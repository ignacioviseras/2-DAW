package es.fp.cajero.modelo.Controller;


import org.springframework.ui.Model;
import javax.servlet.http.HttpSession;
import es.fp.cajero.modelo.beans.Cuenta;
import es.fp.cajero.modelo.dao.CuentaDaoImpl;
import javax.servlet.http.HttpServletRequest;
import es.fp.cajero.modelo.interf.IntCuentaDao;
import org.springframework.stereotype.Controller;
import es.fp.cajero.modelo.interf.IntMovimientoDao;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {
	
	@Autowired
	IntCuentaDao intcuen;
	
	@Autowired
	IntMovimientoDao intmov;
	//---------------acceso al inicio------------------------
	@GetMapping("")
	public String acceso(HttpSession sess){
		if(sess.getAttribute("idSessCuent") == null) {//comprobamos si la session esta guardada el idSessCuent se crea en la linea 57
			return "redirect:/login";//si da nulo significa q no y lo metemos en el login
		}else {
			return"index";//de ser asi iniciamos 
		}
	}
	//-------------------Login------------------------------
	@GetMapping("/login")
	public String login(Model d){
		d.addAttribute("cuenta", new Cuenta());
		return "login";
	}
	
	@PostMapping("/login")
	/*
	*Un @ModelAttribute en un argumento de método indica que el argumento debe recuperarse del modelo.
	*Entonces, en este caso, esperamos tener el objeto Persona modelo como clave y 
	*queremos obtener su valor y ponerlo en el argumento del método Persona persona 
	*/
	public String login(@ModelAttribute("cuenta") Cuenta cuent, HttpServletRequest req, RedirectAttributes red, HttpSession sess) {
		Cuenta cuenta = intcuen.verificarLog(cuent.getIdCuenta());//verificamos q la cuenta q se nos pasa exista
		
		if(cuenta == null) {//si da null significa q no existe la cuenta
			red.addFlashAttribute("Eror", "El id u otra cosa esta mal");//sacamos un mensaje de error que se eliminara ya q es un flahj
			return "redirect:/login";
		}else {//en caso de q exista 
			sess.setAttribute("idSessCuent", cuenta.getIdCuenta());//se guardara en sess para asi poder utilizarlo mas tarde
			return "redirect:/";
		}
	}
	//--------------------Logout---------------------------
	@GetMapping("/logout")
	public String logout(HttpSession sess){//elimina el registro de ssion 
		if(sess.getAttribute("idSessCuent") != null) {//si no es null lo borra
			sess.removeAttribute("idSessCuent");
		}
		return "redirect:/login";//te redirige para que te logues
	}
	//-------------direccionamiento a las operaciones del cajaero-------------------------
	
	@GetMapping("/operaciones/{operacion}")
	public String operacion(@PathVariable("operacion") int op, Model mod, HttpSession sess) {
		if(sess.getAttribute("idSessCuent") != null) {//comprobamos q esta la sesion iniciada de no estarlo te mete en el login
			Cuenta cuen = intcuen.findById((int) sess.getAttribute("idSessCuent"));//casteo el session a un int para q lo reciba cuenta
			mod.addAttribute("cuenta", cuen);
			switch (op) {
				case 1://ingres
					mod.addAttribute("select", "ingresa");
					return "ingresa&retira";//te dirije al jsp donde podras hacer la operacion de ingresar/extraer dinero
				case 2://retira
					mod.addAttribute("select", "retira");
					return "ingresa&retira";//te dirije al jsp donde podras hacer la operacion de ingresar/extraer dinero
				case 3://ver movim
					return "redirect:/acciones/ver";//te redirecciona al otro controlador 
				case 4://transf
					mod.addAttribute("accion", "Transfer");
					return "transferencia";//te mete en el jsp para realizar la transferencia
				default:
					break;
			}
		}
		return "redirec:/login";//como digo arriba en caso de q sea nnull te mete en el inicio
	}
}
