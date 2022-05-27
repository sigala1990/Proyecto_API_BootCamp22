package es.http.service.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import es.http.service.dto.Libro;

public interface ILibroDAO extends JpaRepository<Libro, Integer>{

}
