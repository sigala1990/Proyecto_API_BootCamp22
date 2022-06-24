package es.http.service.services;

import java.util.List;

import es.http.service.dto.Usuario;

public interface IUsuarioService {
	public List<Usuario> listarUsuario(); //Listar All 
	
	public Usuario buscarByUsername(String username);
	
	public Usuario guardarUsuario(Usuario usuario);	//Guarda un cliente CREATE
	
	public Usuario usuarioXID(int id); //Leer datos de un cliente READ
	
	public Usuario actualizarUsuario(Usuario usuario); //Actualiza datos del cliente UPDATE
	
	public void eliminarUsuario(int id);// Elimina el cliente DELETE
}
