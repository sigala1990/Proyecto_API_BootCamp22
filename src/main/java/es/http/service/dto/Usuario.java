package es.http.service.dto;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "usuario")
public class Usuario implements UserDetails{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "username")
	private String username;
	@Column(name = "email")
	private String email;

	@Column(name ="password")
	private String password;
	@Enumerated(EnumType.STRING)
	@Column(name ="role")
	private Role role;
	
	@Column(name ="edad")
	private Date edad;
	
	@Column(name ="url_imagen")
	private String url_imagen;
	
	@Column(name ="activo")
	private String activo;
	
		
	
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

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities(){
		List<GrantedAuthority> roles = new ArrayList<>();
		roles.add(new SimpleGrantedAuthority(role.toString()));
		return roles;
	}
	
	public Usuario() {
		super();
	}


	public Usuario(int id, String username, String email, String password, Role role, Date edad, String url_imagen,
			String activo, List<Libro> libros, List<Valoracion> valoracion, List<Prestacion> prestacion,
			List<Notificacion> notificacion_emisor, List<Notificacion> notificacion_receptor) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.role = role;
		this.edad = edad;
		this.url_imagen = url_imagen;
		this.activo = activo;
		this.libros = libros;
		this.valoracion = valoracion;
		this.prestacion = prestacion;
		this.notificacion_emisor = notificacion_emisor;
		this.notificacion_receptor = notificacion_receptor;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}



	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Date getEdad() {
		return edad;
	}


	public void setEdad(Date edad) {
		this.edad = edad;
	}


	public String getUrl_imagen() {
		return url_imagen;
	}


	public void setUrl_imagen(String url_imagen) {
		this.url_imagen = url_imagen;
	}


	public String getActivo() {
		return activo;
	}


	public void setActivo(String activo) {
		this.activo = activo;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUserName(String nombre) {
		this.username = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Libros")
	public List<Libro> getLibros() {
		return libros;
	}

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Valoracion")
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

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Notificacion")
	public List<Notificacion> getNotificacion_emisor() {
		return notificacion_emisor;
	}

	public void setNotificacion_emisor(List<Notificacion> notificacion_emisor) {
		this.notificacion_emisor = notificacion_emisor;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Notificacion")
	public List<Notificacion> getNotificacion_receptor() {
		return notificacion_receptor;
	}

	public void setNotificacion_receptor(List<Notificacion> notificacion_receptor) {
		this.notificacion_receptor = notificacion_receptor;
	}
	
	
	

	
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + username + ", email=" + email + ", libros=" + libros + ", prestacion="
				+ prestacion + "]";
	}


	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
 
}
