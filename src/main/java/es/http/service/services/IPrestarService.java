package es.http.service.services;

import java.util.List;

import es.http.service.dto.Prestar;

public interface IPrestarService {

	// Metodos del CRUD
	public List<Prestar> listarPrestar(); // Listar All

	public Prestar guardarPrestar(Prestar prestar); // Guarda un RegistroPrestar CREATE

	public Prestar prestarXID(int id); // Leer datos de un RegistroPrestar READ

	public Prestar actualizarPrestar(Prestar prestar); // Actualiza datos del RegistroPrestar UPDATE

	public void eliminarPrestar(int id);// Elimina el RegistroPrestar DELETE

}
