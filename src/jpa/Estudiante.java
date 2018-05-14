package jpa;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Estudiante {
	@Id
	private int id;
	
	@Column(name="name", length=50, nullable=false)
	private String nombre;

	@Temporal(value = TemporalType.DATE)
	@Column(name="birthday", nullable=false)
	private Date fechaNacimento;

	public Estudiante() {

	}

	public Estudiante(int id, String nombre, Date fechaNacimento) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.fechaNacimento = fechaNacimento;
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

	public Date getFechaNacimento() {
		return fechaNacimento;
	}

	public void setFechaNacimento(Date fechaNacimento) {
		this.fechaNacimento = fechaNacimento;
	}

	@Override
	public String toString() {
		return "Estudiante [id=" + id + ", nombre=" + nombre + ", fechaNacimento=" + fechaNacimento + "]";
	}

	
}
