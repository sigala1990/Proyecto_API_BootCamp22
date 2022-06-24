package es.http.service.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import es.http.service.dto.Notificacion;

public interface INotificacionDAO extends JpaRepository<Notificacion, Integer> {

}
