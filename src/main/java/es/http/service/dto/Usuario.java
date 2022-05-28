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
	/*@Column(name ="username")
	private String username;
	@Column(name ="password")
	private String password;
	@Column(name ="role")
	private String role;
	*/
	
	@OneToMany
	@JoinColumn(name = "usuario_id")
	private List<Libro> libros;
	
	@OneToMany
	@JoinColumn(name ="usuario_id")
	private List<Valoracion> valoracion;
	
	@OneToMany
	@JoinColumn(name ="usuario_prestacion_id")
	private List<Prestacion> prestacion;
	
	@OneToMany
	@JoinColumn(name ="usuario_emisor_id")
	private List<Notificacion> notificacion_emisor;
	
	@OneToMany
	@JoinColumn(name ="usuario_receptor_id")
	private List<Notificacion> notificacion_receptor;

	public Usuario() {
		super();
	}


	public Usuario(int id, String nombre, String email, List<Libro> libros, List<Valoracion> valoracion,
			List<Prestacion> prestacion, List<Notificacion> notificacion_emisor,
			List<Notificacion> notificacion_receptor) {

		super();
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.libros = libros;
		this.valoracion = valoracion;
		this.prestacion = prestacion;
		this.notificacion_emisor = notificacion_emisor;
		this.notificacion_receptor = notificacion_receptor;

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

	public List<Valoracion> getValoracion() {
		return valoracion;
	}

	public void setValoracion(List<Valoracion> valoracion) {
		this.valoracion = valoracion;
	}

	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Prestacion")
	public List<Prestacion> getPrestacion() {
		return prestacion;
	}

	public void setPrestacion(List<Prestacion> prestacion) {
		this.prestacion = prestacion;
	}

	public List<Notificacion> getNotificacion_emisor() {
		return notificacion_emisor;
	}

	public void setNotificacion_emisor(List<Notificacion> notificacion_emisor) {
		this.notificacion_emisor = notificacion_emisor;
	}

	public List<Notificacion> getNotificacion_receptor() {
		return notificacion_receptor;
	}

	public void setNotificacion_receptor(List<Notificacion> notificacion_receptor) {
		this.notificacion_receptor = notificacion_receptor;
	}
	
	
	

	
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", email=" + email + ", libros=" + libros + ", prestacion="
				+ prestacion + "]";
	}
 
}
