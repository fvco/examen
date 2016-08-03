package examen.service;

import java.util.List;

import examen.modelo.Pendiente;

public interface PendienteService {

	void add(Pendiente pendiente);
	void edit(Pendiente pendiente);
	void delete(long pendienteId);
	Pendiente getPendiente(long pendienteId);
	List<Pendiente> getPendientes();
	
}
