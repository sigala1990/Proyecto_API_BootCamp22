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

import es.http.service.dto.Libro;
import es.http.service.services.LibroServiceImpl;

@RestController
@RequestMapping("/api")
public class LibroController {
	
	@Autowired
	LibroServiceImpl libroServiceImpl;
	
	@GetMapping("/libro")
	@PreAuthorize("hasAnyAuthority('ADMIN')")
	public List<Libro> listarLibro(){
		return libroServiceImpl.listarLibro();
	}
	

	@PreAuthorize("hasAnyAuthority('ADMIN')")
	@PostMapping("/libro")
	public Libro salvarLibro(@RequestBody Libro Libro) {
		
		return libroServiceImpl.guardarLibro(Libro);
	}
	
	
	@GetMapping("/libro/{id}")
	public Libro LibroXID(@PathVariable(name="id") int id) {
		
		Libro Libro_xid= new Libro();
		
		Libro_xid=libroServiceImpl.LibroXID(id);
				
		return Libro_xid;
	}
	
	@PutMapping("/libro/{id}")
	public Libro actualizarLibro(@PathVariable(name="id")int id,@RequestBody Libro Libro) {
		
		Libro Libro_seleccionado= new Libro();
		Libro Libro_actualizado= new Libro();
		
		Libro_seleccionado= libroServiceImpl.LibroXID(id);
		
		Libro_seleccionado.setAutor(Libro.getAutor());
		Libro_seleccionado.setTitulo(Libro.getTitulo());
		Libro_seleccionado.setIsbn(Libro.getIsbn());
		Libro_seleccionado.setEdad(Libro.getEdad());
		Libro_seleccionado.setCategoria(Libro.getCategoria());

		Libro_seleccionado.setCantidad_veces_reservado(Libro.getCantidad_veces_reservado());
		Libro_seleccionado.setUrl_img(Libro.getUrl_img());
		Libro_seleccionado.setUsuario(Libro.getUsuario());
		Libro_seleccionado.setEditorial(Libro.getEditorial());
		Libro_seleccionado.setDescripcion(Libro.getDescripcion());
		Libro_seleccionado.setDisponible(Libro.getDisponible());
		
		
		Libro_actualizado = libroServiceImpl.actualizarLibro(Libro_seleccionado);
				
		return Libro_actualizado;
	}
	
	@DeleteMapping("/libro/{id}")
	public void eleiminarLibro(@PathVariable(name="id")int id) {
		libroServiceImpl.eliminarLibro(id);
	}

}
