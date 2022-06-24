package es.http.service.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	@PreAuthorize("hasAnyAuthority('ADMIN','USER','GUESS')")
	public ResponseEntity<List<Libro>> listarLibro(){
		return new ResponseEntity<>(libroServiceImpl.listarLibro(), HttpStatus.OK);
	}
	


	@PostMapping("/libro")
	@PreAuthorize("hasAnyAuthority('ADMIN','USER')")
	public ResponseEntity<Libro> salvarLibro(@RequestBody Libro Libro) {
		
		return new ResponseEntity<>(libroServiceImpl.guardarLibro(Libro), HttpStatus.CREATED);
		
	}
	
	
	@GetMapping("/libro/{id}")
	@PreAuthorize("hasAnyAuthority('ADMIN','USER')")
	public ResponseEntity<Libro>  LibroXID(@PathVariable(name="id") int id) {
		
		try {
			
			Libro libro_xid= new Libro();
			
			libro_xid = libroServiceImpl.LibroXID(id);
			
			return new ResponseEntity<>(libro_xid, HttpStatus.OK);
			
		} catch (NoSuchElementException e) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}
				
		
	}
	
	@PutMapping("/libro/{id}")
	@PreAuthorize("hasAnyAuthority('ADMIN','USER')")
public ResponseEntity<Libro> actualizarLibro(@PathVariable(name="id")int id,@RequestBody Libro Libro) {
		
		try {
			
			Libro Libro_seleccionado = new Libro();
			Libro Libro_actualizado = new Libro();
			
			Libro_seleccionado = libroServiceImpl.LibroXID(id);
			
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
			
			return new ResponseEntity<>(Libro_actualizado, HttpStatus.OK);
			
		} catch (NoSuchElementException e) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}

	}
	
	@DeleteMapping("/libro/{id}")
	@PreAuthorize("hasAnyAuthority('ADMIN','USER')")
	public ResponseEntity<String> eleiminarLibro(@PathVariable(name="id")int id) {
		
		try {
			
			libroServiceImpl.LibroXID(id);

			libroServiceImpl.eliminarLibro(id);
			return new ResponseEntity<>("El libro se ha eliminado correctamente", HttpStatus.OK);
			
		} catch (NoSuchElementException e) {
			
			return new ResponseEntity<>("No se ha encontrado el libro",HttpStatus.NOT_FOUND);
			
		}
	}

}