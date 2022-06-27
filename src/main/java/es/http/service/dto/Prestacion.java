package es.http.service.dto;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "prestacion") // en caso que la tabala sea diferente
public class Prestacion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "usuario_prestacion_id") 
	Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "libro_prestacion_id") 
	Libro libro_prestacion_id;
	
	@ManyToOne
    @JoinColumn(name = "prestar_id")
	Prestar prestar_id;
	
	
	
	public Prestacion() {
		super();
	}

	public Prestacion(int id, Usuario usuario, Libro libro_prestacion_id, Prestar prestar_id) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.libro_prestacion_id = libro_prestacion_id;
		this.prestar_id = prestar_id;
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

	
	public Libro getLibro_prestacion_id() {
		return libro_prestacion_id;
	}

	public void setLibro_prestacion_id(Libro libro_prestacion_id) {
		this.libro_prestacion_id = libro_prestacion_id;
	}

	public Prestar getPrestar_id() {
		return prestar_id;
	}

	public void setPrestar_id(Prestar prestar_id) {
		this.prestar_id = prestar_id;
	}

	@Override
	public String toString() {
		return "Prestacion [id=" + id + ", usuario_prestacion_id=" + usuario + ", libro_prestacion_id="
				+ libro_prestacion_id + ", prestar_id=" + prestar_id + "]";
	}
	 

}
