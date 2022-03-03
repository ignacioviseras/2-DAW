package com.edix.actividad.controller;

import javax.servlet.http.HttpServletRequest;
import com.edix.actividad.repository.IntUsuarioDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
@RequestMapping("/usuario")
public class UsuariosController {
	@Autowired
	private IntUsuarioDao usuario;
	
	@GetMapping("/")//cuando s e pone /usuario/
	public String loginV(){
		return "login";//se devuelve login.jsp
	}
	
	@GetMapping("/detalle")//cuando s e pone /usuario/detalle
	public String detalleUsu(HttpServletRequest reqest) {
			return "usuarioDetalles";//se devuelve usuarioDetalles.jsp
	}
	
	@GetMapping("/login")//cuando s e pone /usuario/login
		public String login1(HttpServletRequest request){
		if(request.getSession().getAttribute("usuarioSes") == null) {//si no estamos con la sesion iniciada
			return "redirect:/usuario/";//nos redirige a / de tal manera que se abra el login.jsp y accederemod al metodo post
		}else {
			return "redirect:/";//si tenemos la sesion iniciada nos deja redirige a / q es el index
		}
	}
	
	@PostMapping("/login")
	public String login(HttpServletRequest request, @RequestParam("usuarioo") String usuarioo, @RequestParam("contraseñaa") String contraseñaa, RedirectAttributes rdit){
		long logUser = usuario.verificacionDatos(usuarioo, contraseñaa);//recogemos los datos que se nos pasan 
																		//y comprobamos que el usuario y contraseñas son correctos usando el verificar datos
		if(logUser != 0) {//un if con la salida que se nos da si es 0 esta mal si es 1 estan bien
			request.getSession().setAttribute("usuarioSes", usuario.findByID(logUser));//y guardamos en sesion el acceso de tal manera que le pasamos los datos del usuario para cuando acceda
			return "redirect:/";//si tenemos la sesion iniciada nos deja redirige a / q es el index
		}else {
			rdit.addFlashAttribute("NoExist", "no existe este usuario");//soltamos unnmensaje con el flshAtribute que solo existira en el momento que se solicita
		}
		return "redirect:/usuario/";//redirigimos al login otra vez
}
	@GetMapping("/cerrarSesion")
	public String logaout(WebRequest request) {
		request.removeAttribute("usuario", WebRequest.SCOPE_SESSION);
		return "redirect:/usuario/";//nos suelta en login para que volvamos a iniciar sesion
	}
}
