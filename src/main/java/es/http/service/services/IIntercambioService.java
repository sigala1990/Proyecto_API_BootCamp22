package es.http.service.services;

import java.util.List;

import es.http.service.dto.Intercambio;
import es.http.service.dto.Usuario;

public interface IIntercambioService {
	// Metodos del CRUD
	public List<Intercambio> listarIntercambio(); // Listar All intercambioes

	public Intercambio guardarIntercambio(Intercambio intercambio); // Guarda una intercambio  CREATE

	public Intercambio intercambioXID(Integer id); // Leer datos de una intercambioes READ

	public Intercambio actualizarIntercambio(Intercambio intercambio); // Actualiza datos de una intercambioes UPDATE

	public void eliminarIntercambio(Integer id);// Elimina el intercambio DELETE
	


}
