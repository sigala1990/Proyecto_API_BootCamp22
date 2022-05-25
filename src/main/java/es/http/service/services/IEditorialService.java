package es.http.service.services;

import java.util.List;

import es.http.service.dto.Editorial;

public interface IEditorialService {
	
	// Metodos del CRUD
		public List<Editorial> listarEditorial(); // Listar All editoriales

		public Editorial guardarEditorial(Editorial editorial); // Guarda una editorial  CREATE

		public Editorial editorialsXID(Integer id); // Leer datos de una editoriales READ

		public Editorial actualizarEditorial(Editorial editorial); // Actualiza datos de una editoriales UPDATE

		public void eliminarEditorial(Integer id);// Elimina el editorial DELETE

}
