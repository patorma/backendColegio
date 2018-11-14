package com.patriciocontreras.SistEscuela.app.models.service;

import java.util.List;

import com.patriciocontreras.SistEscuela.app.models.entity.Escuela;

public interface IEscuelaService {
	public List<Escuela> findAll(); //retornar todas las escuelas
	
	public void save (Escuela escuela);
	
	public Escuela findOne(Long id);//busca por una escuela
	
	public void delete(Long id);

}
