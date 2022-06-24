package es.http.service.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.http.service.DAO.IPrestarDAO;
import es.http.service.dto.Prestar;

@Service
public class PrestarServiceImpl implements IPrestarService{
	
	@Autowired
	IPrestarDAO iPrestarDAO;

	@Override
	public List<Prestar> listarPrestar() {
		// TODO Auto-generated method stub
		return iPrestarDAO.findAll();
	}

	@Override
	public Prestar guardarPrestar(Prestar prestar) {
		// TODO Auto-generated method stub
		return iPrestarDAO.save(prestar);
	}

	@Override
	public Prestar prestarXID(int id) {
		// TODO Auto-generated method stub
		return iPrestarDAO.findById(id).get();
	}

	@Override
	public Prestar actualizarPrestar(Prestar prestar) {
		// TODO Auto-generated method stub
		return iPrestarDAO.save(prestar);
	}

	@Override
	public void eliminarPrestar(int id) {
		// TODO Auto-generated method stub
		iPrestarDAO.deleteById(id);
	}

}
