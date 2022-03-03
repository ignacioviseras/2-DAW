package com.edix.actividad.controller;

import javax.servlet.http.HttpServletRequest;
import com.edix.actividad.modelo.beans.Reserva;
import com.edix.actividad.modelo.beans.Usuario;
import com.edix.actividad.repository.IntEventoDao;
import com.edix.actividad.repository.IntReservaDao;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/reservas")//cuando se accede por /reservas podremos ejecutar lo q esta aqui abajo
public class ReservasController {
	@Autowired
	private IntReservaDao reservaa;
	@Autowired 
	private IntEventoDao eventoo;
	
	@GetMapping("/detalles")//cuando entremos por /reservas/detalles/
	public String detalle(Model model, HttpServletRequest request) {
		Usuario usuar = (Usuario) request.getSession().getAttribute("usuarioSes");//guardamos los datos de usuario para asi luego pasarlo
		model.addAttribute("reserva", reservaa.reservasUsuario(usuar.getIdUsuario()));//aqui de tal manera que podamos mostrarlo en el jsp
		return "listadoReserva";//de listadoReserva
	}

	@GetMapping("/detalle/{idEvento}")//entramos en detalle del usuario que se nos pasa en el id
	public String reserva(Model model, @PathVariable("idEvento") int idEvento, HttpServletRequest requsts) {
		Usuario usuar = (Usuario) requsts.getSession().getAttribute("usuarioSes");//pasamos el usuario q estamos usando
		
		model.addAttribute("evento", eventoo.findById(idEvento));//pasamos los datos el evento para cuando lo saquemos por el jsp
		model.addAttribute("reservadeUsua", reservaa.buscarReserva(usuar.getIdUsuario(), idEvento));//nos pasan la reserva comprobando que es esa
											//y la guardamos para luego en el jsp hacer la gestion de la cantidad de reservas
		return "reservaDetalles";//nos devuelve el jsp
	}

	@PostMapping("/verificando/{idEvento}")
	public String verificando(@RequestParam("cantEntradas") int cantEnt, @PathVariable("idEvento") int idEvento, RedirectAttributes rdt, HttpServletRequest rqst){
		if(cantEnt > 0) {//comprobamos q el numero de reserva sea mayor a 0
			Usuario usuar = (Usuario) rqst.getSession().getAttribute("usuarioSes");//pasamos el usuario q estamos usando
			if(reservaa.buscarReserva(usuar.getIdUsuario(), idEvento) == null) {//comprobamos si exsite
				reservaa.altaReservaa(new Reserva(usuar.getIdUsuario(), idEvento, eventoo.findById(idEvento).getPrecio(), 0, ""));//de no existir lo creamos
			}
			if(reservaa.verificadorEntradas(reservaa.buscarReserva(usuar.getIdUsuario(), idEvento).getIdReserva(), cantEnt, idEvento)) {//comprobamos si le quedan reservas al usuario pasado
				rdt.addFlashAttribute("compraEntrads","Reserva realizada");//usamos el addflash para el mensaje de salida de tal manera que nos diga si se pudo hacer la compra
				Reserva reserva = reservaa.buscarReserva(usuar.getIdUsuario(), idEvento);//accedemos al usuario q se nos pasa
				reserva.setCantidad(reserva.getCantidad()+cantEnt);//y le añadimos la cantidad de reserva 
			}else
				rdt.addFlashAttribute("compraEntrads", "No quedan entradas");//usamos el addflash para el mensaje de salida de tal manera que nos diga que no se pudo hacer la compra
		}
		return "redirect:/reservas/detalle/" + idEvento;//nos dirige a detalle pasando el id para que podamos acceder acedamos 
		
	}
}
