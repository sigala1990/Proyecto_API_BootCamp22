package es.http.service.dto;

import java.sql.Date;
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
@Table(name = "prestar") // en caso que la tabala sea diferente
public class Prestar {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "fecha_inicio") 
	private Date fecha_inicio;
	
	@Column(name = "fecha_fin") 
	private Date fecha_fin;
	
	@ManyToMany
    @JoinColumn(name = "usuario_id")
	private List<Usuario> usuario;
 
    @ManyToMany
    @JoinColumn(name = "libro_id")
    private List<Libro> libro;

	public Prestar() {
		super();
	}

	public Prestar(int id, Date fecha_inicio, Date fecha_fin, List<Usuario> usuario, List<Libro> libro) {
		super();
		this.id = id;
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
		this.usuario = usuario;
		this.libro = libro;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public Date getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(Date fecha_fin) {
		this.fecha_fin = fecha_fin;
	}

	public List<Usuario> getUsuario() {
		return usuario;
	}

	public void setUsuario(List<Usuario> usuario) {
		this.usuario = usuario;
	}

	public List<Libro> getLibro() {
		return libro;
	}

	public void setLibro(List<Libro> libro) {
		this.libro = libro;
	}

	@Override
	public String toString() {
		return "Prestar [id=" + id + ", fecha_inicio=" + fecha_inicio + ", fecha_fin=" + fecha_fin + ", usuario="
				+ usuario + ", libro=" + libro + "]";
	}

}
