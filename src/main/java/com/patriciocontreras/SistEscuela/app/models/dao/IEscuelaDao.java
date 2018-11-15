package com.patriciocontreras.SistEscuela.app.models.dao;



import org.springframework.data.repository.CrudRepository;

import com.patriciocontreras.SistEscuela.app.models.entity.Escuela;


//Long es el tipo de dato de la clave primaria
public interface IEscuelaDao extends CrudRepository<Escuela, Long>{

	
}
