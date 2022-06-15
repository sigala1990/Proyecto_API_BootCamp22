package es.http.service.dto;

import java.sql.Date;
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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "prestar") // en caso que la tabala sea diferente
public class Prestar {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "fecha_inicio")
	private Date fecha_inicio;

	@Column(name = "fecha_fin")
	private Date fecha_fin;

	@Enumerated(EnumType.STRING)
	@Column(name ="estado")
	private Estado estado;
	
	@Column(name ="duracion_reserva")
	private int duracion_reserva;
	
	@OneToMany
	@JoinColumn(name = "prestar_id") // Referencia a id de Prestar
	private List<Prestacion> prestacion;

	public Prestar() {
		super();
	}


	public Prestar(int id, Date fecha_inicio, Date fecha_fin, Estado estado, int duracion_reserva,
			List<Prestacion> prestacion) {
		super();
		this.id = id;
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
		this.estado = estado;
		this.duracion_reserva = duracion_reserva;
		this.prestacion = prestacion;
	}


	public Estado getEstado() {
		return estado;
	}


	public void setEstado(Estado estado) {
		this.estado = estado;
	}


	public int getDuracion_reserva() {
		return duracion_reserva;
	}


	public void setDuracion_reserva(int duracion_reserva) {
		this.duracion_reserva = duracion_reserva;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public Date getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(Date fecha_fin) {
		this.fecha_fin = fecha_fin;
	}


	public void setPrestacion(List<Prestacion> prestacion) {
		this.prestacion = prestacion;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Prestacion")
	public List<Prestacion> getPrestacion() {
		return prestacion;
	}

	@Override
	public String toString() {
		return "Prestar [id=" + id + ", fecha_inicio=" + fecha_inicio + ", fecha_fin=" + fecha_fin + ", prestacion=" + prestacion + "]";
	}

}
