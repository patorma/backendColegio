package com.patriciocontreras.SistEscuela.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.patriciocontreras.SistEscuela.app.models.dao.IProfesorDao;
import com.patriciocontreras.SistEscuela.app.models.entity.Profesor;

@Service
public class ProfesorServiceImpl implements IProfesorService {
	@Autowired
	private IProfesorDao profesorDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Profesor> findAll() {
		// TODO Auto-generated method stub
		return (List<Profesor>) profesorDao.findAll();
	}
	
	@Override
	@Transactional(readOnly=true)
	public Profesor findOne(Long id) {
		// TODO Auto-generated method stub
		return profesorDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void save(Profesor profesor) {
		// TODO Auto-generated method stub
		profesorDao.save(profesor);
	}

	

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		profesorDao.deleteById(id);
	}

}
