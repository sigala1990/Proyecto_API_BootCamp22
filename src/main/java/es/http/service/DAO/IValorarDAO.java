package es.http.service.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import es.http.service.dto.Valorar;

public interface IValorarDAO extends JpaRepository<Valorar, Integer>{

}
