package es.http.service.services;

import java.util.List;

import es.http.service.dto.Valorar;

public interface IValorarService {
	public List<Valorar> listarValorar(); //Listar All 
	
	public Valorar guardarValorar(Valorar valorar);	//Guarda un cliente CREATE
	
	public Valorar valorarXID(int id); //Leer datos de un cliente READ
	
	public Valorar actualizarValorar(Valorar valorar); //Actualiza datos del cliente UPDATE
	
	public void eliminarValorar(int id);// Elimina el cliente DELETE
}
