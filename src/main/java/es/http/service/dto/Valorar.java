package es.http.service.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="valorar")
public class Valorar {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	

	@Column(name = "fecha")
	private Date fecha;
	@Column(name ="comentario")
	private String comentario;
	//TODO revisar MTM
	@ManyToMany
	@JoinColumn(name="usuario_id")
	private List<Usuario> usuario_id;
	//TODO revisar MTM
	@ManyToMany
	@JoinColumn(name="libro_id")
	private List<Libro> libro_id;
	
	
	public Valorar() {
		super();
	}


	public Valorar(int id, Date fecha, String comentario, List<Usuario> usuario_id, List<Libro> libro_id) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.comentario = comentario;
		this.usuario_id = usuario_id;
		this.libro_id = libro_id;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public String getComentario() {
		return comentario;
	}


	public void setComentario(String comentario) {
		this.comentario = comentario;
	}


	public List<Usuario> getUsuario_id() {
		return usuario_id;
	}


	public void setUsuario_id(List<Usuario> usuario_id) {
		this.usuario_id = usuario_id;
	}


	public List<Libro> getLibro_id() {
		return libro_id;
	}


	public void setLibro_id(List<Libro> libro_id) {
		this.libro_id = libro_id;
	}
	
	
	
}
