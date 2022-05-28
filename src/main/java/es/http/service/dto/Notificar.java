package es.http.service.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="notificar")
public class Notificar {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="mensaje")
	private String mensaje;
	@Column(name="fecha")
	private Date fecha;
	@Column(name ="estado")
	private int estado;
	@Column(name ="titulo_libro")
	private String titulo_libro;
	
	//TODO revisar @ManyToMany
/*	@ManyToMany
	@JoinColumn(name="usuario_emisor_id")
	Usuario usuario_emisor_id;
	
	@ManyToMany
	@JoinColumn(name="usuario_receptor_id")
	Usuario usuario_receptor_id;
*/
	public Notificar() {
		super();
	}



	public Notificar(int id, String mensaje, Date fecha, int estado, String titulo_libro/*, Usuario usuario_emisor_id,
			Usuario usuario_receptor_id*/) {
		super();
		this.id = id;
		this.mensaje = mensaje;
		this.fecha = fecha;
		this.estado = estado;
		this.titulo_libro = titulo_libro;
	/*	this.usuario_emisor_id = usuario_emisor_id;
		this.usuario_receptor_id = usuario_receptor_id;*/
	}



	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public String getTitulo_libro() {
		return titulo_libro;
	}

	public void setTitulo_libro(String titulo_libro) {
		this.titulo_libro = titulo_libro;
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

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
/*
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
	*/
	
}
