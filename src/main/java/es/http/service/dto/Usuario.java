package es.http.service.dto;

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
@Table(name = "usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "email")
	private String email;

	// TODO añadir campos Usuario/password/rol
	
	@OneToMany
	@JoinColumn(name = "id")
	private List<Libro> libros;
	
	@OneToMany
	@JoinColumn(name = "id") // Referencia a id usuario
	private List<Prestacion> prestacion;

	// TODO relacion notificar

	// TODO relacion valorar
	public Usuario() {
		super();
	}

	public Usuario(int id, String nombre, String email, List<Libro> libros, List<Prestacion> prestacion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.libros = libros;
		this.prestacion = prestacion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Libro> getLibros() {
		return libros;
	}

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Prestacion")
	public List<Prestacion> getPrestacion() {
		return prestacion;
	}

	public void setPrestacion(List<Prestacion> prestacion) {
		this.prestacion = prestacion;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", email=" + email + ", libros=" + libros + ", prestacion="
				+ prestacion + "]";
	}
 
}
