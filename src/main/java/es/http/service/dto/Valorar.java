package es.http.service.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
	
	@Enumerated(EnumType.STRING)
	@Column(name ="estrellas")
	private Estrellas estrellas;
	
	/*@Enumerated(EnumType.STRING)
	@Column(name ="role")
	private Role role;*/
	
	public Valorar() {
		super();
	}


	public Valorar(int id, Date fecha, String comentario, Estrellas estrellas) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.comentario = comentario;
		this.estrellas = estrellas;
	}


	public Valorar(int id, Date fecha, String comentario) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.comentario = comentario;
	}


	public Estrellas getEstrellas() {
		return estrellas;
	}


	public void setEstrellas(Estrellas estrellas) {
		this.estrellas = estrellas;
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


	
	
	
}
