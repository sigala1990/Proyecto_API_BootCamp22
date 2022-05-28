package es.http.service.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.http.service.DAO.IValorarDAO;
import es.http.service.dto.Valorar;

@Service
public class ValorarServiceImpl implements IValorarService {
	@Autowired
	IValorarDAO iValorarDAO;

	@Override
	public List<Valorar> listarValorar() {
		return iValorarDAO.findAll();
	}

	@Override
	public Valorar guardarValorar(Valorar valorar) {
		return iValorarDAO.save(valorar);
	}

	@Override
	public Valorar valorarXID(int id) {
		return iValorarDAO.findById(id).get();
	}

	@Override
	public Valorar actualizarValorar(Valorar valorar) {
		return iValorarDAO.save(valorar);
	}

	@Override
	public void eliminarValorar(int id) {
		iValorarDAO.deleteById(id);
	}

}
