package es.http.service.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.http.service.DAO.IEditorialDAO;
import es.http.service.dto.Editorial;

@Service
public class EditorialServiceImpl implements IEditorialService{
	
	@Autowired
	IEditorialDAO iEditorialDAO;

	@Override
	public List<Editorial> listarEditorial() {
		return iEditorialDAO.findAll();
	}

	@Override
	public Editorial guardarEditorial(Editorial editorial) {
		// TODO Auto-generated method stub
		return iEditorialDAO.save(editorial);
	}

	@Override
	public Editorial editorialsXID(Integer id) {
		// TODO Auto-generated method stub
		return iEditorialDAO.findById(id).get();
	}

	@Override
	public Editorial actualizarEditorial(Editorial editorial) {
		// TODO Auto-generated method stub
		return iEditorialDAO.save(editorial);
	}

	@Override
	public void eliminarEditorial(Integer id) {
		// TODO Auto-generated method stub
		iEditorialDAO.deleteById(id);
	}

}
