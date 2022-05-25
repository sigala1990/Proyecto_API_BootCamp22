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

import es.http.service.dto.Valorar;
import es.http.service.services.ValorarServiceImpl;

@RestController
@RequestMapping("/api")
public class ValorarController {
	@Autowired
	ValorarServiceImpl valorarServiceImpl;
	
	@GetMapping("/valorar")
	public List<Valorar> listarCvalorars(){
		return valorarServiceImpl.listarValorar();
	}
	

	@PostMapping("/valorar")
	public Valorar salvarValorar(@RequestBody Valorar valorar) {
		
		return valorarServiceImpl.guardarValorar(valorar);
	}
	
	
	@GetMapping("/valorar/{id}")
	public Valorar valorarXID(@PathVariable(name="id") int id) {
		
		Valorar Valorar_xid= new Valorar();
		
		Valorar_xid=valorarServiceImpl.valorarXID(id);
		
		//System.out.println("Valorar XID: "+Valorar_xid);
		
		return Valorar_xid;
	}
	
	@PutMapping("/valorar/{id}")
	public Valorar actualizarValorar(@PathVariable(name="id")int id,@RequestBody Valorar valorar) {
		
		Valorar Valorar_seleccionado= new Valorar();
		Valorar Valorar_actualizado= new Valorar();
		
		Valorar_seleccionado= valorarServiceImpl.valorarXID(id);
		
		Valorar_seleccionado.setFecha(valorar.getFecha());
		Valorar_seleccionado.setComentario(valorar.getComentario());
		Valorar_seleccionado.setLibro_id(valorar.getLibro_id());
		Valorar_seleccionado.setUsuario_id(valorar.getUsuario_id());
		
		Valorar_actualizado = valorarServiceImpl.actualizarValorar(Valorar_seleccionado);
		
		//System.out.println("El Valorar actualizado es: "+ Valorar_actualizado);
		
		return Valorar_actualizado;
	}
	
	@DeleteMapping("/valorar/{id}")
	public void eleiminarValorar(@PathVariable(name="id")int id) {
		valorarServiceImpl.eliminarValorar(id);
	}
}
