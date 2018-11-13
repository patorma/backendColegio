package com.patriciocontreras.SistEscuela.app.models.dao;

import java.util.List;

import com.patriciocontreras.SistEscuela.app.models.entity.Escuela;

public interface IEscuelaDao {

	public List<Escuela> findAll(); //retornar todas las escuelas
	
	public void save (Escuela escuela);
}
