package com.patriciocontreras.SistEscuela.app.models.service;

import java.util.List;

import com.patriciocontreras.SistEscuela.app.models.entity.Profesor;

public interface IProfesorService {

	public List<Profesor> findAll();
	public void save(Profesor profesor);
	public Profesor findOne(Long id);
	public void delete(Long id);
	
}
