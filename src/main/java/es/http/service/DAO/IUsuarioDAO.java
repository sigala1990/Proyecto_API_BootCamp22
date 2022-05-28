package es.http.service.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import es.http.service.dto.Usuario;

public interface IUsuarioDAO extends JpaRepository<Usuario, Integer>{

