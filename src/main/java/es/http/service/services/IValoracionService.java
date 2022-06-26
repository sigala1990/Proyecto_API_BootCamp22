package es.http.service.services;

import java.util.List;

import es.http.service.dto.Libro;
import es.http.service.dto.Valoracion;

public interface IValoracionService {
	//Metodos del CRUD
	public List<Valoracion> listarValoracion(); //Listar All 
	
	public Valoracion guardarValoracion(Valoracion valoracion);	//Guarda un cliente CREATE
	
	public Valoracion valoracionXID(int id); //Leer datos de un cliente READ
	
	public Valoracion actualizarValoracion(Valoracion valoracion); //Actualiza datos del cliente UPDATE
	
	public void eliminarValoracion(int id);// Elimina el cliente DELETE
	
	public List<Valoracion> listarPorLibro(Libro libro);
	
}
