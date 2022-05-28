package es.http.service.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import es.http.service.dto.Notificar;

public interface INotificarDAO extends JpaRepository<Notificar, Integer>{

}
