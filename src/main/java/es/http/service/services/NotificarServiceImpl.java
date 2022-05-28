package es.http.service.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.http.service.DAO.INotificarDAO;
import es.http.service.dto.Notificar;

@Service
public class NotificarServiceImpl implements INotificarService{
	@Autowired
	INotificarDAO iNotificarDAO;

	@Override
	public List<Notificar> listarNotificar() {
		return iNotificarDAO.findAll();
	}

	@Override
	public Notificar guardarNotificar(Notificar notificar) {
		return iNotificarDAO.save(notificar);
	}

	@Override
	public Notificar notificarXID(int id) {
		return iNotificarDAO.findById(id).get();
	}

	@Override
	public Notificar actualizarNotificar(Notificar notificar) {
		return iNotificarDAO.save(notificar);
	}

	@Override
	public void eliminarNotificar(int id) {
		iNotificarDAO.deleteById(id);
	}
}
