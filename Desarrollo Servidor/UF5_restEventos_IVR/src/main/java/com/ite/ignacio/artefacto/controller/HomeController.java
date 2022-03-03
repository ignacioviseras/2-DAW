package com.ite.ignacio.artefacto.controller;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import com.ite.ignacio.artefacto.beans.Evento;
import org.springframework.stereotype.Controller;
import com.ite.ignacio.artefacto.dao.EventoDaoImpl;
import com.ite.ignacio.artefacto.dao.ReservaDaoImpl;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="*")//atendemos peticiones desde cualquier origen
@RestController
@RequestMapping("/rest/eventos")
public class HomeController {

	@Autowired
	private EventoDaoImpl edao;
	
	@Autowired
	private ReservaDaoImpl rdao;
	
	@GetMapping("/vertodos")
	public List<Evento> procTodos(){
		return edao.findAll();//devuelve todos los events
	}
	
	@GetMapping("/buscarEventos/{dt}")
	public List<Evento> procBuscarCadena(@PathVariable("dt") String dt){
		return edao.buscarEvento(dt);//buscamos la cadena q se nos pasa
	}
	
	
	@GetMapping("/buscarPlaza/{idEvento}")
	public Map<String, Integer> procPlaza(@PathVariable("idEvento") int idEvento){
		HashMap<String, Integer> hm = new HashMap<>();//lo vamos a usar para el mensaje q devolvemos ponemos string e int pq sera en la manera q devolvemos
		int ocupado;
		ocupado = edao.verUno(idEvento).getAforoMaximo() - rdao.buscarPlaza(idEvento);//vemos cuantas plzas hay ocupadas restanto las totales q es esto edao.verUno(idEvento).getAforoMaximo() 
		if(ocupado <= 0) {//esto es para q no retone nº negativos en las plazas
			ocupado = 0;
		}
		System.out.println(rdao.buscarPlaza(idEvento));//pruebas de una cosa q necesitaba
		System.out.println(edao.verUno(idEvento).getAforoMaximo());//pruebas de una cosa q necesitaba
		hm.put("Plazas quedan: ", ocupado);//mensaje q saldra en el json para ver el r3esult de cuant queda
		return hm;//devolvemos el mensaj de arriba
	}
	
	@GetMapping("/verUno/{idEvento}")
	public Evento procTodos(@PathVariable("idEvento") int idEvento){
		return edao.verUno(idEvento);//devolvemos el evento q queremos buscar
	}
	
	@PostMapping("/alta")//@RequestBody es lo q viene por el mensaje del http
	public String procAlta(@RequestBody Evento evento) {
		return (edao.insertar(evento) == 1)?"Alta realizada":"Alta no realizada";//lo q hacemos es q si da 1 nos avisa de q se pudo hacer el alta en caso contrario ps decimos q no
	}
	
	@PutMapping("/modificar")//@RequestBody es lo q viene por el mensaje del http
	public String procModif(@RequestBody Evento evento) {
		return (edao.modificar(evento) == 1)?"Alta realizada":"Alta no realizada";//lo q hacemos es q si da 1 nos avisa de q se pudo hacer el alta en caso contrario ps decimos q no
	}
	
	@DeleteMapping("/eliminar{idEvento}")
	public String procElimi(@PathVariable int evento) {
		return (edao.eliminar(evento) == 1)?"Alta realizada":"Alta no realizada";//lo q hacemos es q si da 1 nos avisa de q se pudo hacer el alta en caso contrario ps decimos q no
	}
	
	
}
