package es.http.service.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.http.service.DAO.IIntercambiarDAO;
import es.http.service.dto.Intercambiar;

@Service
public class IntercambiarServiceImpl  implements IIntercambiarService{
	@Autowired
	IIntercambiarDAO iIntercambiarDAO;

	@Override
	public List<Intercambiar> listarIntercambiar() {
		return iIntercambiarDAO.findAll();
	}

	@Override
	public Intercambiar guardarIntercambiar(Intercambiar intercambiar) {
		// TODO Auto-generated method stub
		return iIntercambiarDAO.save(intercambiar);
	}

	@Override
	public Intercambiar intercambiarXID(Integer id) {
		// TODO Auto-generated method stub
		return iIntercambiarDAO.findById(id).get();
	}

	@Override
	public Intercambiar actualizarIntercambiar(Intercambiar intercambiar) {
		// TODO Auto-generated method stub
		return iIntercambiarDAO.save(intercambiar);
	}

	@Override
	public void eliminarIntercambiar(Integer id) {
		// TODO Auto-generated method stub
		iIntercambiarDAO.deleteById(id);
	}

}
