package com.patriciocontreras.SistEscuela.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.patriciocontreras.SistEscuela.app.models.entity.Asignatura;

public interface IAsignaturaDao extends CrudRepository<Asignatura,Long>{

}
