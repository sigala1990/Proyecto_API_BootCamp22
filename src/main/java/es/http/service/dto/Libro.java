package es.http.service.dto;

import java.util.List;

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
@Table(name = "libro") // en caso que la tabala sea diferente
public class Libro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "autor") // no hace falta si se llama igual
	private String autor;
	
	@Column(name = "titulo") // no hace falta si se llama igual
	private String titulo;
	
	@Column(name = "isbn") // no hace falta si se llama igual
	private String isbn;
	
	@Column(name = "edad") // no hace falta si se llama igual
	private int edad;
	
	@Column(name = "categoria") // no hace falta si se llama igual
	private String categoria;
	
	@Column(name = "duracion_reserva_dias") // no hace falta si se llama igual
	private int duracion_reserva_dias;
	
	@Column(name = "cantidad_veces_reservado") // no hace falta si se llama igual
	private int cantidad_veces_reservado;
	
	@Column(name = "url_img") // no hace falta si se llama igual
	private String url_img;
	
	@ManyToOne
    @JoinColumn(name = "usuario_id")
    Usuario usuario;
 
    @ManyToOne
    @JoinColumn(name = "editorial_id")
    Editorial editorial;
    
    @OneToMany
	@JoinColumn(name = "libro_prestacion_id") //Referencia a id de Libro
	private List<Prestacion> prestacion;
    
    @OneToMany
	@JoinColumn(name = "libro_id") //Referencia a id de Libro
	private List<Valoracion> valoracion;
    
    @OneToMany
	@JoinColumn(name = "libro_id") //Referencia a id de Libro
	private List<Notificacion> notificacion;
    
	public Libro() {
		super();
	}



	public Libro(int id, String autor, String titulo, String isbn, int edad, String categoria,
			int duracion_reserva_dias, int cantidad_veces_reservado, String url_img, Usuario usuario,
			Editorial editorial, List<Prestacion> prestacion, List<Valoracion> valoracion,
			List<Notificacion> notificacion) {
		super();
		this.id = id;
		this.autor = autor;
		this.titulo = titulo;
		this.isbn = isbn;
		this.edad = edad;
		this.categoria = categoria;
		this.duracion_reserva_dias = duracion_reserva_dias;
		this.cantidad_veces_reservado = cantidad_veces_reservado;
		this.url_img = url_img;
		this.usuario = usuario;
		this.editorial = editorial;
		this.prestacion = prestacion;
		this.valoracion = valoracion;
		this.notificacion = notificacion;
	}



	public List<Valoracion> getValoracion() {
		return valoracion;
	}



	public void setValoracion(List<Valoracion> valoracion) {
		this.valoracion = valoracion;
	}



	public List<Notificacion> getNotificacion() {
		return notificacion;
	}



	public void setNotificacion(List<Notificacion> notificacion) {
		this.notificacion = notificacion;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public int getDuracion_reserva_dias() {
		return duracion_reserva_dias;
	}

	public void setDuracion_reserva_dias(int duracion_reserva_dias) {
		this.duracion_reserva_dias = duracion_reserva_dias;
	}

	public int getCantidad_veces_reservado() {
		return cantidad_veces_reservado;
	}

	public void setCantidad_veces_reservado(int cantidad_veces_reservado) {
		this.cantidad_veces_reservado = cantidad_veces_reservado;
	}

	public String getUrl_img() {
		return url_img;
	}

	public void setUrl_img(String url_img) {
		this.url_img = url_img;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Editorial getEditorial() {
		return editorial;
	}

	public void setEditorial(Editorial editorial) {
		this.editorial = editorial;
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
		return "Libro [id=" + id + ", autor=" + autor + ", titulo=" + titulo + ", isbn=" + isbn + ", edad=" + edad
				+ ", categoria=" + categoria + ", duracion_reserva_dias=" + duracion_reserva_dias
				+ ", cantidad_veces_reservado=" + cantidad_veces_reservado + ", url_img=" + url_img + ", usuario="
				+ usuario + ", editorial=" + editorial + ", prestacion=" + prestacion + "]";
	}
	
	
}
