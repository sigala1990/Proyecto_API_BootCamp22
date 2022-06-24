package es.http.service.services;

import java.util.List;

import es.http.service.dto.Notificar;

public interface INotificarService {
	public List<Notificar> listarNotificar(); //Listar All 
	
	public Notificar guardarNotificar(Notificar notificar);	//Guarda un cliente CREATE
	
	public Notificar notificarXID(int id); //Leer datos de un cliente READ
	
	public Notificar actualizarNotificar(Notificar notificar); //Actualiza datos del cliente UPDATE
	
	public void eliminarNotificar(int id);// Elimina el cliente DELETE
}
