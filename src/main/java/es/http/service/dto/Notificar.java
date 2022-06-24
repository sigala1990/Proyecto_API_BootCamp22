package es.http.service.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="notificar")
public class Notificar {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="mensaje")
	private String mensaje;
	@Column(name="estado")
	private int estado;
	@Column(name="fecha")
	private Date fecha;
	
	@OneToMany
	@JoinColumn(name="notificar_id")
	private List<Notificacion> notificacion;
	
	public Notificar() {
		super();
	}

	public Notificar(int id, String mensaje, int estado, Date fecha, List<Notificacion> notificacion) {
		super();
		this.id = id;
		this.mensaje = mensaje;
		this.estado = estado;
		this.fecha = fecha;
		this.notificacion = notificacion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Notificacion")
	public List<Notificacion> getNotificacion() {
		return notificacion;
	}

	public void setNotificacion(List<Notificacion> notificacion) {
		this.notificacion = notificacion;
	}



}
