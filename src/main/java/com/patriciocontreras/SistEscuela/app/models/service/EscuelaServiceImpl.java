package com.patriciocontreras.SistEscuela.app.models.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.patriciocontreras.SistEscuela.app.models.entity.Escuela;

//una clase service esta basado en el patron de diseño fakecade o fachada
//un unico punto de acceso hacia distintos daos o repository
//la idea de clase service que por cada metodo en la clase DAO  vamos a tener metodos en el escuela 
//service
@Service 
public class EscuelaServiceImpl implements IEscuelaService{

	@Override
	public List<Escuela> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Escuela escuela) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Escuela findOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

}
