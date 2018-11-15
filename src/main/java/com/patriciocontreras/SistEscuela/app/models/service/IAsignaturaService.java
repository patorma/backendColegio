package com.patriciocontreras.SistEscuela.app.models.service;

import java.util.List;

import com.patriciocontreras.SistEscuela.app.models.entity.Asignatura;

public interface IAsignaturaService {
	
	public List<Asignatura> findAll();
	
	public void save(Asignatura asignatura);
	
	public Asignatura findOne(Long id);
	
	public void delete(Long id);

}
