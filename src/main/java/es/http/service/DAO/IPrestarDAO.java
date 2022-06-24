package es.http.service.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import es.http.service.dto.Prestar;

public interface IPrestarDAO extends JpaRepository<Prestar, Integer>{

}
