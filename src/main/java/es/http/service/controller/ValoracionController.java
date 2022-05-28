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

import es.http.service.dto.Valoracion;
import es.http.service.services.ValoracionServiceImpl;
@RestController
@RequestMapping("/api")
public class ValoracionController {
	@Autowired
	ValoracionServiceImpl valoracionServiceImpl;
	
	@GetMapping("/valoracion")
	public List<Valoracion> listarCvaloracions(){
		return valoracionServiceImpl.listarValoracion();
	}
	
	
	@PostMapping("/valoracion")
	public Valoracion salvarValoracion(@RequestBody Valoracion valoracion) {
		
		return valoracionServiceImpl.guardarValoracion(valoracion);
	}
	
	
	@GetMapping("/valoracion/{id}")
	public Valoracion valoracionXID(@PathVariable(name="id") int id) {
		
		Valoracion Valoracion_xid= new Valoracion();
		
		Valoracion_xid=valoracionServiceImpl.valoracionXID(id);
		
		//System.out.println("Valoracion XID: "+Valoracion_xid);
		
		return Valoracion_xid;
	}
	
	@PutMapping("/valoracion/{id}")
	public Valoracion actualizarValoracion(@PathVariable(name="id")int id,@RequestBody Valoracion valoracion) {
		
		Valoracion Valoracion_seleccionado= new Valoracion();
		Valoracion Valoracion_actualizado= new Valoracion();
		
		Valoracion_seleccionado= valoracionServiceImpl.valoracionXID(id);
		
		Valoracion_seleccionado.setLibro(valoracion.getLibro());
		Valoracion_seleccionado.setUsuario(valoracion.getUsuario());
		Valoracion_seleccionado.setValorar(valoracion.getValorar());
		
		Valoracion_actualizado = valoracionServiceImpl.actualizarValoracion(Valoracion_seleccionado);
		
		//System.out.println("El Valoracion actualizado es: "+ Valoracion_actualizado);
		
		return Valoracion_actualizado;
	}
	
	@DeleteMapping("/valoracion/{id}")
	public void eleiminarValoracion(@PathVariable(name="id")int id) {
		valoracionServiceImpl.eliminarValoracion(id);
	}
}