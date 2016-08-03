package examen.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import examen.modelo.Pendiente;

@Repository
@Transactional
public class PendienteDaoImpl implements PendienteDao{

	@Autowired
	private SessionFactory sessionFactory;

	public void add(Pendiente pendiente) {
		sessionFactory.getCurrentSession().save(pendiente);
	}

	public void edit(Pendiente pendiente) {
		sessionFactory.getCurrentSession().update(pendiente);
	}

	public void delete(long pendienteId) {
		sessionFactory.getCurrentSession().delete(getPendiente(pendienteId));
	}

	public Pendiente getPendiente(long pendienteId) {
		return (Pendiente) sessionFactory.getCurrentSession().get(Pendiente.class, pendienteId);
	}

	public List<Pendiente> getPendientes() {
		return (List<Pendiente>) sessionFactory.getCurrentSession().createCriteria(Pendiente.class).list();
	}

}
