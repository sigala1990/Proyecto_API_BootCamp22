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
@Table(name = "editorial") // en caso que la tabala sea diferente
public class Editorial {

	// Atributos de entidad registro_curso
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "nombre") // no hace falta si se llama igual
	private String nombre;

	@OneToMany
	@JoinColumn(name = "editorial_id")
	private List<Libro> libro;
	
	public Editorial() {
		super();
	}

	public Editorial(int id, String nombre, List<Libro> libro) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.libro = libro;
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

	public void setLibro(List<Libro> libro) {
		this.libro = libro;
	}
	
	/**
	 * @return the Asignado_A
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Editorial")
	public List<Libro> getLibro() {
		return libro;
	}

	@Override
	public String toString() {
		return "Editorial [id=" + id + ", nombre=" + nombre + ", libro=" + libro + "]";
	}	

}
