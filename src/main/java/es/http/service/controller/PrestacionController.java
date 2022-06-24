package es.http.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.http.service.dto.Prestacion;
import es.http.service.services.PrestacionServiceImpl;

@RestController
@RequestMapping("/api")
public class PrestacionController {
	
	@Autowired
	PrestacionServiceImpl prestacionServiceImpl;
	
	@GetMapping("/prestacion")
	@PreAuthorize("hasAnyAuthority('ADMIN','USER')")
	public List<Prestacion> listarPrestacion(){
		return prestacionServiceImpl.listarPrestacion();
	}
	
	
	@PostMapping("/prestacion")
	@PreAuthorize("hasAnyAuthority('ADMIN','USER')")
	public Prestacion salvarPrestacion(@RequestBody Prestacion Prestacion) {
		
		return prestacionServiceImpl.guardarPrestacion(Prestacion);
	}
	
	
	@GetMapping("/prestacion/{id}")
	@PreAuthorize("hasAnyAuthority('ADMIN','USER')")
	public Prestacion PrestacionXID(@PathVariable(name="id") int id) {
		
		Prestacion Prestacion_xid= new Prestacion();
		
		Prestacion_xid=prestacionServiceImpl.PrestacionXID(id);
				
		return Prestacion_xid;
	}
	
	@PutMapping("/prestacion/{id}")
	@PreAuthorize("hasAnyAuthority('ADMIN','USER')")
	public Prestacion actualizarPrestacion(@PathVariable(name="id")int id,@RequestBody Prestacion Prestacion) {
		
		Prestacion Prestacion_seleccionado= new Prestacion();
		Prestacion Prestacion_actualizado= new Prestacion();
		
		Prestacion_seleccionado= prestacionServiceImpl.PrestacionXID(id);
		
		Prestacion_seleccionado.setLibro_prestacion_id(Prestacion.getLibro_prestacion_id());
		Prestacion_seleccionado.setPrestar_id(Prestacion.getPrestar_id());
		Prestacion_seleccionado.setUsuario_prestacion_id(Prestacion.getUsuario_prestacion_id());

		
		Prestacion_actualizado = prestacionServiceImpl.actualizarPrestacion(Prestacion_seleccionado);
				
		return Prestacion_actualizado;
	}
	
	@DeleteMapping("/prestacion/{id}")
	@PreAuthorize("hasAnyAuthority('ADMIN','USER')")
	public void eleiminarPrestacion(@PathVariable(name="id")int id) {
		prestacionServiceImpl.eliminarPrestacion(id);
	}

}
