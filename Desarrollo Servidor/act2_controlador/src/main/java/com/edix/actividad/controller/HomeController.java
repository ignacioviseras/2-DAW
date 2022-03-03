package com.edix.actividad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import com.edix.actividad.repository.IntEventoDao;


@Controller
public class HomeController {
	@Autowired
	private IntEventoDao ele;
	
	@GetMapping("/")
	public String inicio(Model model) {
		model.addAttribute("listadoEventos", ele.findAll());//guardamos en listadoEventos todos los eventos usando el findAll
		return "index";
	}
	@GetMapping("/activos")
	public String activos(Model model) {
		model.addAttribute("tipos", "Activos");//lo que hacemos es que cuando se acceda aqui guardemos el texto activos en tipo de tal
												//manera que en el jsp al q accedamos se utilice este texto
		model.addAttribute("listadoEventos", ele.activos());//guardamos en listadoEventos todos los activos usando la funcion de eventos
		return "listadoespecial";//mandamos a este jsp la info necesaria
	}
	@GetMapping("/destacados")
	public String destacados(Model model) {
		model.addAttribute("tipos", "Destacados");//lo que hacemos es que cuando se acceda aqui guardemos el texto activos en tipo de tal
												//manera que en el jsp al q accedamos se utilice este texto
		model.addAttribute("listadoEventos", ele.destacados());//guardamos en listadoEventos todos los destacados usando la funcion de eventos
		return "listadoespecial";
	}
}
