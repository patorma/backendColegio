package com.patriciocontreras.SistEscuela.app.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="escuelas")
public class Escuela implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//Serializable buena paractica para trabajar con mvc

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)//se indica que es una llave incremental
	private Long id;
	//no se utiliza column ya que no son diferentes los atributos con los de bd
	// se agregan las validaciones correspondiente
	@NotEmpty
	private String nombre;
	
	@NotEmpty
	private String direccion;
	
	@NotNull
	@Column(name="create_at")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createAt;// fecha de creacion de colegio
	//un colegio y muchos profesores
	@OneToMany(mappedBy="escuela",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<Profesor> profesores;
	
	
	/*//se crea metodo antes de que los datos se guarden en la bd
	@PrePersist //se llama este metodo de crear fecha antes de insertar datos bd
	public void prePersist() {
		createAt = new Date();
	}*/

	public Escuela() {
		
		profesores =  new ArrayList<Profesor>();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	public List<Profesor> getProfesores() {
		return profesores;
	}
	public void setProfesores(List<Profesor> profesores) {
		this.profesores = profesores;
	}
	
	public void addProfesor(Profesor profesor) {
		profesores.add(profesor);
	}
	
	
}
