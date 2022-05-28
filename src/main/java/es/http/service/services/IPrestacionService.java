package es.http.service.services;

import java.util.List;

import es.http.service.dto.Prestacion;

public interface IPrestacionService {
	
	// Metodos del CRUD
		public List<Prestacion> listarPrestacion(); // Listar All

		public Prestacion guardarPrestacion(Prestacion prestacion); // Guarda un RegistroPrestacion CREATE

		public Prestacion PrestacionXID(int id); // Leer datos de un RegistroPrestacion READ

		public Prestacion actualizarPrestacion(Prestacion prestacion); // Actualiza datos del RegistroPrestacion UPDATE

		public void eliminarPrestacion(int id);// Elimina el RegistroPrestacion DELETE

}
