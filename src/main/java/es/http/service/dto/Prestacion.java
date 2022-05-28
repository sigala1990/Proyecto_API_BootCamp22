package es.http.service.dto;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "prestacion") // en caso que la tabala sea diferente
public class Prestacion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "usuario_prestacion_id") 
	Usuario usuario_prestacion_id;
	
	@ManyToOne
	@JoinColumn(name = "libro_prestacion_id") 
	Libro libro_prestacion_id;
	
	@ManyToOne
    @JoinColumn(name = "prestar_id")
	Prestar prestar_id;
	
	
	
	public Prestacion() {
		super();
	}

	public Prestacion(int id, Usuario usuario_prestacion_id, Libro libro_prestacion_id, Prestar prestar_id) {
		super();
		this.id = id;
		this.usuario_prestacion_id = usuario_prestacion_id;
		this.libro_prestacion_id = libro_prestacion_id;
		this.prestar_id = prestar_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Usuario getUsuario_prestacion_id() {
		return usuario_prestacion_id;
	}

	public void setUsuario_prestacion_id(Usuario usuario_prestacion_id) {
		this.usuario_prestacion_id = usuario_prestacion_id;
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
		return "Prestacion [id=" + id + ", usuario_prestacion_id=" + usuario_prestacion_id + ", libro_prestacion_id="
				+ libro_prestacion_id + ", prestar_id=" + prestar_id + "]";
	}
	 

}
