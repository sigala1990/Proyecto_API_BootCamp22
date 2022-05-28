package es.http.service.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.http.service.DAO.IValoracionDAO;
import es.http.service.dto.Valoracion;

@Service
public class ValoracionServiceImpl implements IValoracionService{
	@Autowired
	IValoracionDAO iValoracionDAO;

	@Override
	public List<Valoracion> listarValoracion() {
		return iValoracionDAO.findAll();
	}

	@Override
	public Valoracion guardarValoracion(Valoracion valoracion) {
		return iValoracionDAO.save(valoracion);
	}

	@Override
	public Valoracion valoracionXID(int id) {
		return iValoracionDAO.findById(id).get();
	}

	@Override
	public Valoracion actualizarValoracion(Valoracion valoracion) {
		return iValoracionDAO.save(valoracion);
	}

	@Override
	public void eliminarValoracion(int id) {
		iValoracionDAO.deleteById(id);
	}


}
