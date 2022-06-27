package es.http.service.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.http.service.DAO.ILibroDAO;
import es.http.service.dto.Libro;
import es.http.service.dto.Usuario;

@Service
public class LibroServiceImpl implements ILibroService{
	
	@Autowired
	ILibroDAO iLibroDAO;

	@Override
	public List<Libro> listarLibro() {
		// TODO Auto-generated method stub
		return iLibroDAO.findAll();
	}

	@Override
	public Libro guardarLibro(Libro venta) {
		// TODO Auto-generated method stub
		return iLibroDAO.save(venta);
	}

	@Override
	public Libro LibroXID(int id) {
		// TODO Auto-generated method stub
		return iLibroDAO.findById(id).get();
	}

	@Override
	public Libro actualizarLibro(Libro venta) {
		// TODO Auto-generated method stub
		return iLibroDAO.save(venta);
	}

	@Override
	public void eliminarLibro(int id) {
		// TODO Auto-generated method stub
		iLibroDAO.deleteById(id);
	}

	@Override
	public List<Libro> listarPorUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return iLibroDAO.findByUsuario(usuario);
	}

	@Override
	public Libro buscarPorTitulo(String titulo) {
		// TODO Auto-generated method stub
		return iLibroDAO.findByTitulo(titulo);
	}

	@Override
	public List<Libro> BuscarPorUsuarioOrdenarPorTituloAsc(Usuario usuario) {
		// TODO Auto-generated method stub
		return iLibroDAO.findByUsuarioOrderByTituloAsc(usuario);
	}

	@Override
	public List<Libro> BuscarPorUsuarioOrdenarPorTituloDesc(Usuario usuario) {
		// TODO Auto-generated method stub
		return iLibroDAO.findByUsuarioOrderByTituloDesc(usuario);
	}

	@Override
	public Libro buscarPorIsbn(String isbn) {
		// TODO Auto-generated method stub
		return iLibroDAO.findByIsbn(isbn);
	}

}
