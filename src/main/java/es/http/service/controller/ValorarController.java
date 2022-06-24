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

import es.http.service.dto.Valorar;
import es.http.service.services.ValorarServiceImpl;

@RestController
@RequestMapping("/api")
public class ValorarController {
	@Autowired
	ValorarServiceImpl valorarServiceImpl;
	
	@GetMapping("/valorar")
	@PreAuthorize("hasAnyAuthority('ADMIN','USER','GUESS')")
	public List<Valorar> listarCvalorars(){
		return valorarServiceImpl.listarValorar();
	}
	

	@PostMapping("/valorar")
	@PreAuthorize("hasAnyAuthority('ADMIN','USER')")
	public Valorar salvarValorar(@RequestBody Valorar valorar) {
		
		return valorarServiceImpl.guardarValorar(valorar);

	}
	
	
	@GetMapping("/valorar/{id}")
	@PreAuthorize("hasAnyAuthority('ADMIN','USER')")
	public Valorar ValorarXID(@PathVariable(name="id") int id) {
		
		Valorar Valorar_xid= new Valorar();
		
		Valorar_xid=valorarServiceImpl.valorarXID(id);
				
		return Valorar_xid;
	}
	
	@PutMapping("/valorar/{id}")
	@PreAuthorize("hasAnyAuthority('ADMIN','USER')")
	public Valorar actualizarValorar(@PathVariable(name="id")int id,@RequestBody Valorar valorar) {

		
		Valorar Valorar_seleccionado= new Valorar();
		Valorar Valorar_actualizado= new Valorar();
		
		Valorar_seleccionado= valorarServiceImpl.valorarXID(id);
		
		Valorar_seleccionado.setEstrellas(valorar.getEstrellas());
		Valorar_seleccionado.setFecha(valorar.getFecha());
		Valorar_seleccionado.setComentario(valorar.getComentario());

		Valorar_actualizado = valorarServiceImpl.actualizarValorar(Valorar_seleccionado);
		
		return Valorar_actualizado;
	}
	
	@DeleteMapping("/valorar/{id}")
	@PreAuthorize("hasAnyAuthority('ADMIN','USER')")
	public void eleiminarValorar(@PathVariable(name="id")int id) {
		valorarServiceImpl.eliminarValorar(id);
	}
}
