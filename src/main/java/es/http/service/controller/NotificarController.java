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

import es.http.service.dto.Notificar;
import es.http.service.services.NotificarServiceImpl;

@RestController
@RequestMapping("/api")
public class NotificarController {

	@Autowired
	NotificarServiceImpl notificarServiceImpl;
	
	@GetMapping("/notificar")
	public List<Notificar> listarCnotificars(){
		return notificarServiceImpl.listarNotificar();
	}
	

	@PostMapping("/notificar")
	public Notificar salvarNotificar(@RequestBody Notificar notificar) {
		
		return notificarServiceImpl.guardarNotificar(notificar);
	}
	
	
	@GetMapping("/notificar/{id}")
	public Notificar notificarXID(@PathVariable(name="id") int id) {
		
		Notificar Notificar_xid= new Notificar();
		
		Notificar_xid=notificarServiceImpl.notificarXID(id);
		
		//System.out.println("Notificar XID: "+Notificar_xid);
		
		return Notificar_xid;
	}
	
	@PutMapping("/notificar/{id}")
	public Notificar actualizarNotificar(@PathVariable(name="id")int id,@RequestBody Notificar notificar) {
		
		Notificar Notificar_seleccionado= new Notificar();
		Notificar Notificar_actualizado= new Notificar();
		
		Notificar_seleccionado= notificarServiceImpl.notificarXID(id);
		
		Notificar_seleccionado.setFecha(notificar.getFecha());
		Notificar_seleccionado.setMensaje(notificar.getMensaje());
		//Notificar_seleccionado.setUsuario_emisor_id(notificar.getUsuario_emisor_id());
		//Notificar_seleccionado.setUsuario_receptor_id(notificar.getUsuario_receptor_id());
		
		Notificar_actualizado = notificarServiceImpl.actualizarNotificar(Notificar_seleccionado);
		
		//System.out.println("El Notificar actualizado es: "+ Notificar_actualizado);
		
		return Notificar_actualizado;
	}
	
	@DeleteMapping("/notificar/{id}")
	public void eleiminarNotificar(@PathVariable(name="id")int id) {
		notificarServiceImpl.eliminarNotificar(id);
	}
}
