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

import es.http.service.dto.Prestar;
import es.http.service.services.PrestarServiceImpl;

@RestController
@RequestMapping("/api")
public class PrestarController {
	
	@Autowired
	PrestarServiceImpl prestarServiceImpl;
	
	@GetMapping("/prestar")
	public List<Prestar> listarPrestar(){
		return prestarServiceImpl.listarPrestar();
	}
	
	
	@PostMapping("/prestar")
	public Prestar salvarPrestar(@RequestBody Prestar Prestar) {
		
		return prestarServiceImpl.guardarPrestar(Prestar);
	}
	
	
	@GetMapping("/prestar/{id}")
	public Prestar PrestarXID(@PathVariable(name="id") int id) {
		
		Prestar Prestar_xid= new Prestar();
		
		Prestar_xid=prestarServiceImpl.prestarXID(id);
				
		return Prestar_xid;
	}
	
	@PutMapping("/prestar/{id}")
	public Prestar actualizarPrestar(@PathVariable(name="id")int id,@RequestBody Prestar Prestar) {
		
		Prestar Prestar_seleccionado= new Prestar();
		Prestar Prestar_actualizado= new Prestar();
		
		Prestar_seleccionado= prestarServiceImpl.prestarXID(id);
		
		
		Prestar_seleccionado.setFecha_inicio(Prestar.getFecha_inicio());
		Prestar_seleccionado.setFecha_fin(Prestar.getFecha_fin());
		Prestar_seleccionado.setDuracion_reserva(Prestar.getDuracion_reserva());
		Prestar_seleccionado.setEstado(Prestar.getEstado());
		
		
		Prestar_actualizado = prestarServiceImpl.actualizarPrestar(Prestar_seleccionado);
				
		return Prestar_actualizado;
	}
	
	@DeleteMapping("/prestar/{id}")
	public void eleiminarPrestar(@PathVariable(name="id")int id) {
		prestarServiceImpl.eliminarPrestar(id);
	}

}
