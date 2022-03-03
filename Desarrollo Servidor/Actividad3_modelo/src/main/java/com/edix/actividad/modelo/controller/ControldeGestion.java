package com.edix.actividad.modelo.controller;

import java.math.BigDecimal;
import org.springframework.ui.Model;
import javax.servlet.http.HttpSession;
import com.edix.actividad.modelo.beans.Empleado;
import com.edix.actividad.modelo.beans.Proyecto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.edix.actividad.modelo.Intf.IntClienteDao;
import com.edix.actividad.modelo.Intf.IntEmpleadoDao;
import com.edix.actividad.modelo.Intf.IntProyectoDao;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/empleados")
public class ControldeGestion {
	@Autowired
	private IntProyectoDao pry;
	@Autowired
	private IntClienteDao cli;
	@Autowired
	private IntEmpleadoDao emp;
	//-------------------Logeo---------------------------------
	@GetMapping("/login")
	public String login(HttpSession sess) {//log a la web
		if(sess.getAttribute("sessEmp") != null) {//si esta vacia la sesion te mete en login para que inicies
			Empleado empl = (Empleado) sess.getAttribute("sessEmp");//
			switch(empl.getPerfile().getIdPerfil()) {//saca el id de perfile y dependiendo de cual sea lo mete por su sitio
			case 1:
				return "redirect:/empleados/gestion";
			case 2:
				return "redirect:/empleados/jefe";
			case 3:
				return "redirect:/empleados/operativo";
			case 4:
				return "redirect:/empleados/rhumanos";
			}
		}
		return "login";
	}
	
	@PostMapping("/login")
	public String login(HttpSession sess, @RequestParam("id") int idEmpl, @RequestParam("correo") String correo, @RequestParam("contraseña") String contraseña) {
		Empleado empl = emp.verificarLog(idEmpl, correo, contraseña);
		int tipoemp = 0;
		if(empl != null) {
			tipoemp = empl.getPerfile().getIdPerfil();
			switch(tipoemp) {//lo mismo que el otro solo que lo guarda en sesion para que asi pueda pasar ls datos
			case 1:
				sess.setAttribute("sessEmp", empl);
				return "redirect:/empleados/gestion";
			case 2:
				sess.setAttribute("sessEmp", empl);
				return "redirect:/empleados/jefe";
			case 3:
				sess.setAttribute("sessEmp", empl);
				return "redirect:/empleados/operativo";
			case 4:
				sess.setAttribute("sessEmp", empl);
				return "redirect:/empleados/rhumanos";
			}
		}
		return "redirect:/empleados/login";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession sess){//elimina el registro de ssion 
		if(sess.getAttribute("sessEmp") != null) {//si no es null lo borra
			sess.removeAttribute("sessEmp");
		}
		return "redirect:/empleados/login";//te redirige para que te logues
	}
	
	//-----------------Acceso dependiendo del rol----------------------
	
	@GetMapping("/gestion")
	public String gestion(HttpSession sess, Model model) {
		model.addAttribute("empleado", emp.findByPerfil(1));//pasa los datos de empleados
		model.addAttribute("proyecto", pry.findAll());//y los datos de proyecxto
		return "gestion";
	}
	
	@GetMapping("/jefe")
	public String jefe(HttpSession sess, Model model) {
		Empleado emp = (Empleado) sess.getAttribute("sessEmp");
		model.addAttribute("proyecto", pry.activos(emp.getIdEmpl()));//y los datos de proyecxto pero solo los que esten activos
		return "jefe";
	}
	
	@GetMapping("/jefe/verDetalel/{idProyecto}")
	public String verdetalle(@PathVariable ("idProyecto") int idProyecto, Model model) {
		model.addAttribute("proyecto", pry.findById(idProyecto));//pasamos el id de ese proyecto para que lo podamos mostrar
		return "verdetalle";
	}
	
	/*@GetMapping("/operativo")
	public String operativo() {
			
	}
	@GetMapping("/rhumanos")
	public String rhumanos() {
			
	}*/
	//-----------------Proyecto----------------------------------------
	@GetMapping("/gestion/altaProyecto")
	public String alta(Model model) {
		model.addAttribute("empleado", emp.findByPerfil(2));//pasamos el desplegable que esta dentro del alta de proyecto
		model.addAttribute("cliente", cli.findAll());//pasamos todos los clientes
		return "altaProyecto";
	}
	
	@PostMapping("/gestion/altaProyecto")
	public String alta(Proyecto proyecto, @RequestParam("clientee") String cliente, @RequestParam("jefee") String jefe){
		proyecto.setCliente(cli.findByCif(cliente));//recibimos los daros y le ponemos el cif que nos mandan
		proyecto.setJefeProyecto(emp.findByid(Integer.parseInt(jefe)));//lo mismo con el jefe q nos mandan
		pry.altaProyecto(proyecto);//y por ultimo utilizamos el metodo de alta para asi poder guardarlo
		return "redirect:/empleados/gestion";
	}
	
	@GetMapping("/gestion/terminarProyecto/{idProyecto}")
	public String terminar(@PathVariable ("idProyecto") int idProyecto, Model model) {
		model.addAttribute("proyecto", pry.findById(idProyecto));//pasamos los datos de ese proyecto atraves del findbyid
		return "terminarproyecto";
	}
	
	@PostMapping("/gestion/terminarProyecto/{idProyecto}")
	public String terminar(Proyecto proyecto, @PathVariable ("idProyecto") int idProyecto, @RequestParam("costeReal") int cr, Model model) {
		pry.terminarProyecto(proyecto.getIdProyecto(), BigDecimal.valueOf(cr));//aplicamos el valor del coste real  y dentro de la funcion de terminar se cambia el estado
		return "redirect:/empleados/gestion";
	}
	
}
