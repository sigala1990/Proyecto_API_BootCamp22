package es.http.service.DAO;
import org.springframework.data.jpa.repository.JpaRepository;

import es.http.service.dto.Intercambiar;
import es.http.service.dto.Intercambio;

public interface IIntercambiarDAO extends JpaRepository<Intercambiar, Integer>{

}

