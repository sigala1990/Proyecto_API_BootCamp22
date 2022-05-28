package es.http.service.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.http.service.DAO.IPrestacionDAO;
import es.http.service.dto.Prestacion;

@Service
public class PrestacionServiceImpl implements IPrestacionService{
	
	@Autowired
	IPrestacionDAO iPrestacionDAO;

	@Override
	public List<Prestacion> listarPrestacion() {
		return iPrestacionDAO.findAll();
	}

	@Override
	public Prestacion guardarPrestacion(Prestacion prestacion) {
		return iPrestacionDAO.save(prestacion);
	}

	@Override
	public Prestacion PrestacionXID(int id) {
		return iPrestacionDAO.findById(id).get();
	}

	@Override
	public Prestacion actualizarPrestacion(Prestacion prestacion) {
		return iPrestacionDAO.save(prestacion);
	}

	@Override
	public void eliminarPrestacion(int id) {
		iPrestacionDAO.deleteById(id);
	}

}
