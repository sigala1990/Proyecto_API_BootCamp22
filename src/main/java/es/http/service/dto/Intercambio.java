package es.http.service.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "intercambio")
public class Intercambio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@JoinColumn(name = "libro_1_id")
	private int libro_1_id;
	@JoinColumn(name = "libro_2_id")
	private int libro_2_id;
	@JoinColumn(name = "intercambiar_id")
	private int intercambiar_id;

	public Intercambio() {
		super();
	}

	public Intercambio(int id, int libro_1_id, int libro_2_id, int intercambiar_id) {
		super();
		this.id = id;
		this.libro_1_id = libro_1_id;
		this.libro_2_id = libro_2_id;
		this.intercambiar_id = intercambiar_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLibro_1_id() {
		return libro_1_id;
	}

	public void setLibro_1_id(int libro_1_id) {
		this.libro_1_id = libro_1_id;
	}

	public int getLibro_2_id() {
		return libro_2_id;
	}

	public void setLibro_2_id(int libro_2_id) {
		this.libro_2_id = libro_2_id;
	}

	public int getIntercambiar_id() {
		return intercambiar_id;
	}

	public void setIntercambiar_id(int intercambiar_id) {
		this.intercambiar_id = intercambiar_id;
	}

}
