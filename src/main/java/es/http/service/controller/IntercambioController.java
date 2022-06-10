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

import es.http.service.dto.Intercambio;
import es.http.service.services.IntercambioServiceImpl;

@RestController
@RequestMapping("/api")
public class IntercambioController {
	@Autowired
	IntercambioServiceImpl intercambioServiceImpl;
	
	@GetMapping("/intercambio")
	public List<Intercambio> listarCintercambios(){
		return intercambioServiceImpl.listarIntercambio();
	}
	

	@PostMapping("/intercambio")
	public Intercambio salvarIntercambio(@RequestBody Intercambio intercambio) {
		
		return intercambioServiceImpl.guardarIntercambio(intercambio);

	}
	
	
	@GetMapping("/intercambio/{id}")
	public Intercambio IntercambioXID(@PathVariable(name="id") int id) {
		
		Intercambio Intercambio_xid= new Intercambio();
		
		Intercambio_xid=intercambioServiceImpl.intercambioXID(id);
				
		return Intercambio_xid;
	}
	
	@PutMapping("/intercambio/{id}")
	public Intercambio actualizarIntercambio(@PathVariable(name="id")int id,@RequestBody Intercambio intercambio) {

		
		Intercambio Intercambio_seleccionado= new Intercambio();
		Intercambio Intercambio_actualizado= new Intercambio();
		
		Intercambio_seleccionado= intercambioServiceImpl.intercambioXID(id);
		
		Intercambio_seleccionado.setIntercambiar_id(intercambio.getIntercambiar_id());
		Intercambio_seleccionado.setLibro_1_id(intercambio.getLibro_1_id());
		Intercambio_seleccionado.setLibro_2_id(intercambio.getLibro_2_id());

		Intercambio_actualizado = intercambioServiceImpl.actualizarIntercambio(Intercambio_seleccionado);
		
		return Intercambio_actualizado;
	}
	
	@DeleteMapping("/intercambio/{id}")
	public void eleiminarIntercambio(@PathVariable(name="id")int id) {
		intercambioServiceImpl.eliminarIntercambio(id);
	}
}
