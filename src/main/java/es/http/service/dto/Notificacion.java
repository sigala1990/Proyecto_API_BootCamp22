package es.http.service.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="notificacion")
public class Notificacion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name ="libro_id")
	Libro libro;
	
	@ManyToOne
	@JoinColumn(name ="notificar_id")
	Notificar notificar;
	
	@ManyToOne
	@JoinColumn(name ="usuario_emisor_id")
	Usuario usuario_emisor_id;
	
	@ManyToOne
	@JoinColumn(name ="usuario_receptor_id")
	Usuario usuario_receptor_id;

	public Notificacion() {
		super();
	}

	public Notificacion(int id, Libro libro, Notificar notificar, Usuario usuario_emisor_id,
			Usuario usuario_receptor_id) {
		super();
		this.id = id;
		this.libro = libro;
		this.notificar = notificar;
		this.usuario_emisor_id = usuario_emisor_id;
		this.usuario_receptor_id = usuario_receptor_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public Notificar getNotificar() {
		return notificar;
	}

	public void setNotificar(Notificar notificar) {
		this.notificar = notificar;
	}

	public Usuario getUsuario_emisor_id() {
		return usuario_emisor_id;
	}

	public void setUsuario_emisor_id(Usuario usuario_emisor_id) {
		this.usuario_emisor_id = usuario_emisor_id;
	}

	public Usuario getUsuario_receptor_id() {
		return usuario_receptor_id;
	}

	public void setUsuario_receptor_id(Usuario usuario_receptor_id) {
		this.usuario_receptor_id = usuario_receptor_id;
	}
	
	
}
