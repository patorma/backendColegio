package com.patriciocontreras.SistEscuela.app.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
	private String nombre;
	private String direccion;
	
	@Column(name="create_at")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createAt;// fecha de creacion de colegio
	
	
	/*//se crea metodo antes de que los datos se guarden en la bd
	@PrePersist //se llama este metodo de crear fecha antes de insertar datos bd
	public void prePersist() {
		createAt = new Date();
	}*/
	
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
	
	
	
}
