package es.http.service.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import es.http.service.dto.Libro;
import es.http.service.dto.Valoracion;

public interface IValoracionDAO extends JpaRepository<Valoracion, Integer>{
	List<Valoracion> findByLibro(Libro libro);
}
