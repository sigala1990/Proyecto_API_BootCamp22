package es.http.service.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import es.http.service.DAO.IUsuarioDAO;
import es.http.service.dto.Usuario;

public class UsuarioServiceImpl implements IUsuarioService {
	@Autowired
	IUsuarioDAO iUsuarioDAO;

	@Override
	public List<Usuario> listarUsuario() {
		return iUsuarioDAO.findAll();
	}

	@Override
	public Usuario guardarUsuario(Usuario usuario) {
		return iUsuarioDAO.save(usuario);
	}

	@Override
	public Usuario usuarioXID(int id) {
		return iUsuarioDAO.findById(id).get();
	}

	@Override
	public Usuario actualizarUsuario(Usuario usuario) {
		return iUsuarioDAO.save(usuario);
	}

	@Override
	public void eliminarUsuario(int id) {
		iUsuarioDAO.deleteById(id);
	}
}
