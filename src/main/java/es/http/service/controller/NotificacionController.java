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

import es.http.service.dto.Notificacion;
import es.http.service.services.NotificacionServiceImpl;

@RestController
@RequestMapping("/api")
public class NotificacionController {
	@Autowired
	NotificacionServiceImpl notificacionServiceImpl;
	
	@GetMapping("/notificacion")
	public List<Notificacion> listarCnotificacions(){
		return notificacionServiceImpl.listarNotificacion();
	}
	
	
	@PostMapping("/notificacion")
	public Notificacion salvarNotificacion(@RequestBody Notificacion notificacion) {
		
		return notificacionServiceImpl.guardarNotificacion(notificacion);
	}
	
	
	@GetMapping("/notificacion/{id}")
	public Notificacion notificacionXID(@PathVariable(name="id") int id) {
		
		Notificacion Notificacion_xid= new Notificacion();
		
		Notificacion_xid=notificacionServiceImpl.notificacionXID(id);
		
		//System.out.println("Notificacion XID: "+Notificacion_xid);
		
		return Notificacion_xid;
	}
	
	@PutMapping("/notificacion/{id}")
	public Notificacion actualizarNotificacion(@PathVariable(name="id")int id,@RequestBody Notificacion notificacion) {
		
		Notificacion Notificacion_seleccionado= new Notificacion();
		Notificacion Notificacion_actualizado= new Notificacion();
		
		Notificacion_seleccionado= notificacionServiceImpl.notificacionXID(id);
		
		Notificacion_seleccionado.setLibro(notificacion.getLibro());
		Notificacion_seleccionado.setNotificar(notificacion.getNotificar());
		Notificacion_seleccionado.setUsuario_emisor_id(notificacion.getUsuario_emisor_id());
		Notificacion_seleccionado.setUsuario_receptor_id(notificacion.getUsuario_receptor_id());
		
		Notificacion_actualizado = notificacionServiceImpl.actualizarNotificacion(Notificacion_seleccionado);
		
		//System.out.println("El Notificacion actualizado es: "+ Notificacion_actualizado);
		
		return Notificacion_actualizado;
	}
	
	@DeleteMapping("/notificacion/{id}")
	public void eleiminarNotificacion(@PathVariable(name="id")int id) {
		notificacionServiceImpl.eliminarNotificacion(id);
	}
}
