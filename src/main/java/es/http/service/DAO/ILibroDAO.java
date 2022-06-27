package es.http.service.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import es.http.service.dto.Libro;
import es.http.service.dto.Usuario;

public interface ILibroDAO extends JpaRepository<Libro, Integer>{
	List<Libro> findByUsuario(Usuario usuario);
}
