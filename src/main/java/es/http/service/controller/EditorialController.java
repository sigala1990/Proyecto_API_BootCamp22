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

import es.http.service.dto.Editorial;
import es.http.service.services.EditorialServiceImpl;

@RestController
@RequestMapping("/api")
public class EditorialController {
	
	@Autowired
	EditorialServiceImpl editorialServiceImpl;
	
	@GetMapping("/editorial")
	@PreAuthorize("hasAnyAuthority('ADMIN','USER')")
	public List<Editorial> listarEditorial(){
		return editorialServiceImpl.listarEditorial();
	}
	
	
	@PostMapping("/editorial")
	@PreAuthorize("hasAnyAuthority('ADMIN','USER')")
	public Editorial salvarEditorial(@RequestBody Editorial editorial) {
		
		return editorialServiceImpl.guardarEditorial(editorial);
	}
	
	
	@GetMapping("/editorial/{id}")
	@PreAuthorize("hasAnyAuthority('ADMIN','USER')")
	public Editorial editorialXID(@PathVariable(name="id") Integer id) {
		
		Editorial Editorial_xid= new Editorial();
		
		Editorial_xid=editorialServiceImpl.editorialsXID(id);
				
		return Editorial_xid;
	}
	
	@PutMapping("/editorial/{id}")
	@PreAuthorize("hasAnyAuthority('ADMIN','USER')")
	public Editorial actualizarEditorial(@PathVariable(name="id")Integer id,@RequestBody Editorial editorial) {
		
		Editorial Editorial_seleccionado= new Editorial();
		Editorial Editorial_actualizado= new Editorial();
		
		Editorial_seleccionado= editorialServiceImpl.editorialsXID(id);
		
		Editorial_seleccionado.setNombre(editorial.getNombre());
		
		Editorial_actualizado = editorialServiceImpl.actualizarEditorial(Editorial_seleccionado);
				
		return Editorial_actualizado;
	}
	
	@DeleteMapping("/editorial/{id}")
	@PreAuthorize("hasAnyAuthority('ADMIN','USER')")
	public void eleiminarEditorial(@PathVariable(name="id")Integer id) {
		editorialServiceImpl.eliminarEditorial(id);
	}

}
