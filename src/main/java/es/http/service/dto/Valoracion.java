package es.http.service.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "valoracion")
public class Valoracion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name="usuario_id")
	Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name="libro_id")
	Libro libro;
	
	@ManyToOne
	@JoinColumn(name="valorar_id")
	Valorar valorar;

	public Valoracion() {
		super();
	}

	public Valoracion(int id, Usuario usuario, Libro libro, Valorar valorar) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.libro = libro;
		this.valorar = valorar;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public Valorar getValorar() {
		return valorar;
	}

	public void setValorar(Valorar valorar) {
		this.valorar = valorar;
	}
	
	
	
	
}
