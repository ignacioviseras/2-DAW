package com.edix.actividad.modelo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String pepe() {
		System.out.println("hola");
		return "redirect:/empleados/login";
	}
}
