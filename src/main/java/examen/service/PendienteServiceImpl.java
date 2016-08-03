package examen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import examen.dao.PendienteDao;
import examen.modelo.Pendiente;

@Service
@Transactional
public class PendienteServiceImpl implements PendienteService{

	@Autowired
	private PendienteDao pendienteDao;
	
	public void add(Pendiente pendiente) {
		pendienteDao.add(pendiente);
	}

	public void edit(Pendiente pendiente) {
		pendienteDao.edit(pendiente);
	}

	public void delete(long pendienteId) {
		pendienteDao.delete(pendienteId);
	}

	public Pendiente getPendiente(long pendienteId) {
		return pendienteDao.getPendiente(pendienteId);
	}

	public List<Pendiente> getPendientes() {
		return pendienteDao.getPendientes();
	}

}
