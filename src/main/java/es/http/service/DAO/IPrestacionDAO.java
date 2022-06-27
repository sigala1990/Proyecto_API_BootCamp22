package es.http.service.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import es.http.service.dto.Prestacion;
import es.http.service.dto.Usuario;
import es.http.service.dto.Valoracion;

public interface IPrestacionDAO extends JpaRepository<Prestacion, Integer>{
	List<Prestacion> findByUsuario(Usuario usuario);
}
