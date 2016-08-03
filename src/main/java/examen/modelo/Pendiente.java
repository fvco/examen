package examen.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pendiente")
public class Pendiente {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="pendiente_id")
	private long id;
	
	@Column(name="pendiente")
	private String pendiente;

	public Pendiente(long id, String pendiente) {
		super();
		this.id = id;
		this.pendiente = pendiente;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPendiente() {
		return pendiente;
	}

	public void setPendiente(String pendiente) {
		this.pendiente = pendiente;
	}

	@Override
	public String toString() {
		return "Pendiente [id=" + id + ", pendiente=" + pendiente + "]";
	}

}
