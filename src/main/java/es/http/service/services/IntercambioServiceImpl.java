package es.http.service.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.http.service.DAO.IIntercambioDAO;
import es.http.service.dto.Intercambio;


@Service
public class IntercambioServiceImpl implements IIntercambioService{
	
	@Autowired
	IIntercambioDAO iIntercambioDAO;

	@Override
	public List<Intercambio> listarIntercambio() {
		return iIntercambioDAO.findAll();
	}

	@Override
	public Intercambio guardarIntercambio(Intercambio intercambio) {
		// TODO Auto-generated method stub
		return iIntercambioDAO.save(intercambio);
	}

	@Override
	public Intercambio intercambioXID(Integer id) {
		// TODO Auto-generated method stub
		return iIntercambioDAO.findById(id).get();
	}

	@Override
	public Intercambio actualizarIntercambio(Intercambio intercambio) {
		// TODO Auto-generated method stub
		return iIntercambioDAO.save(intercambio);
	}

	@Override
	public void eliminarIntercambio(Integer id) {
		// TODO Auto-generated method stub
		iIntercambioDAO.deleteById(id);
	}

}
