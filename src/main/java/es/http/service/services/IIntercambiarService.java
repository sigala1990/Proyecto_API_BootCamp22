package es.http.service.services;

import java.util.List;

import es.http.service.dto.Intercambiar;

public interface IIntercambiarService {
	// Metodos del CRUD
	public List<Intercambiar> listarIntercambiar(); // Listar All intercambiares

	public Intercambiar guardarIntercambiar(Intercambiar intercambiar); // Guarda una intercambiar  CREATE

	public Intercambiar intercambiarXID(Integer id); // Leer datos de una intercambiares READ

	public Intercambiar actualizarIntercambiar(Intercambiar intercambiar); // Actualiza datos de una intercambiares UPDATE

	public void eliminarIntercambiar(Integer id);// Elimina el intercambiar DELETE

}
