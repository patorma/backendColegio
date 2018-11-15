package com.patriciocontreras.SistEscuela.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.patriciocontreras.SistEscuela.app.models.entity.Profesor;

public interface IProfesorDao extends CrudRepository<Profesor, Long>{

}
