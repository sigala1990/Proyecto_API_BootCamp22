package es.http.service.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import es.http.service.dto.Valoracion;

public interface IValoracionDAO extends JpaRepository<Valoracion, Integer>{

}
