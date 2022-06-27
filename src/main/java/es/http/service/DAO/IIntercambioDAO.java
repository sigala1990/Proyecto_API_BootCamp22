package es.http.service.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import es.http.service.dto.Intercambio;
import es.http.service.dto.Prestacion;
import es.http.service.dto.Usuario;

public interface IIntercambioDAO extends JpaRepository<Intercambio, Integer>{
	
}
