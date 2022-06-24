package es.http.service.services;

import java.util.List;

import es.http.service.dto.Notificacion;

public interface INotificacionService {
	//Metodos del CRUD
	public List<Notificacion> listarNotificacion(); //Listar All 
	
	public Notificacion guardarNotificacion(Notificacion notificacion);	//Guarda un cliente CREATE
	
	public Notificacion notificacionXID(int id); //Leer datos de un cliente READ
	
	public Notificacion actualizarNotificacion(Notificacion notificacion); //Actualiza datos del cliente UPDATE
	
	public void eliminarNotificacion(int id);// Elimina el cliente DELETE
	
}
