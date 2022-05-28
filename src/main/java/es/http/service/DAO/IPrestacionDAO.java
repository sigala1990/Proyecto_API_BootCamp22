package es.http.service.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import es.http.service.dto.Prestacion;

public interface IPrestacionDAO extends JpaRepository<Prestacion, Integer>{

}
