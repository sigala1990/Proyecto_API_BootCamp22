package es.http.service.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "intercambiar")
public class Intercambiar {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "fecha_solicitud")
	private String fecha_solicitud;
	
	@Column(name = "fecha_estado_final")
	private String fecha_estado_final;
	
	@Enumerated(EnumType.STRING)
	@Column(name ="estado")
	private Estado estado;
	
	@OneToMany
	@JoinColumn(name = "intercambiar_id")
	private List<Intercambio> intercambio;

	public Intercambiar() {
		super();
	}

	public Intercambiar(int id, String fecha_solicitud, String fecha_estado_final, Estado estado,
			List<Intercambio> intercambio) {
		super();
		this.id = id;
		this.fecha_solicitud = fecha_solicitud;
		this.fecha_estado_final = fecha_estado_final;
		this.estado = estado;
		this.intercambio = intercambio;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFecha_solicitud() {
		return fecha_solicitud;
	}

	public void setFecha_solicitud(String fecha_solicitud) {
		this.fecha_solicitud = fecha_solicitud;
	}

	public String getFecha_estado_final() {
		return fecha_estado_final;
	}

	public void setFecha_estado_final(String fecha_estado_final) {
		this.fecha_estado_final = fecha_estado_final;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Intercambio")	
	public List<Intercambio> getIntercambio() {
		return intercambio;
	}

	public void setIntercambio(List<Intercambio> intercambio) {
		this.intercambio = intercambio;
	}
	
	
	
}
