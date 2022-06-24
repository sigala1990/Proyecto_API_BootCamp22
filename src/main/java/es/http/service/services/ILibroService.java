package es.http.service.services;

import java.util.List;

import es.http.service.dto.Libro;

public interface ILibroService {

	// Metodos del CRUD
	public List<Libro> listarLibro(); // Listar All

	public Libro guardarLibro(Libro libro); // Guarda un RegistroLibro CREATE

	public Libro LibroXID(int id); // Leer datos de un RegistroLibro READ

	public Libro actualizarLibro(Libro libro); // Actualiza datos del RegistroLibro UPDATE

	public void eliminarLibro(int id);// Elimina el RegistroLibro DELETE

}
