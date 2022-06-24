package es.http.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.http.service.dto.Intercambiar;
import es.http.service.services.IntercambiarServiceImpl;

@RestController
@RequestMapping("/api")
public class IntercambiarController {
	@Autowired
	IntercambiarServiceImpl intercambiarServiceImpl;
	
	@GetMapping("/intercambiar")
	public List<Intercambiar> listarIntercambiars(){
		return intercambiarServiceImpl.listarIntercambiar();
	}
	

	@PostMapping("/intercambiar")
	public Intercambiar salvarIntercambiar(@RequestBody Intercambiar intercambiar) {
		
		return intercambiarServiceImpl.guardarIntercambiar(intercambiar);

	}
	
	
	@GetMapping("/intercambiar/{id}")
	public Intercambiar IntercambiarXID(@PathVariable(name="id") int id) {
		
		Intercambiar Intercambiar_xid= new Intercambiar();
		
		Intercambiar_xid=intercambiarServiceImpl.intercambiarXID(id);
				
		return Intercambiar_xid;
	}
	
	@PutMapping("/intercambiar/{id}")
	public Intercambiar actualizarIntercambiar(@PathVariable(name="id")int id,@RequestBody Intercambiar intercambiar) {

		
		Intercambiar Intercambiar_seleccionado= new Intercambiar();
		Intercambiar Intercambiar_actualizado= new Intercambiar();
		
		Intercambiar_seleccionado= intercambiarServiceImpl.intercambiarXID(id);
		
		Intercambiar_seleccionado.setFecha_solicitud(intercambiar.getFecha_solicitud());
		Intercambiar_seleccionado.setFecha_estado_final(intercambiar.getFecha_estado_final());
		Intercambiar_seleccionado.setEstado(intercambiar.getEstado());

		Intercambiar_actualizado = intercambiarServiceImpl.actualizarIntercambiar(Intercambiar_seleccionado);
		
		return Intercambiar_actualizado;
	}
	
	@DeleteMapping("/intercambiar/{id}")
	public void eleiminarIntercambiar(@PathVariable(name="id")int id) {
		intercambiarServiceImpl.eliminarIntercambiar(id);
	}
}
