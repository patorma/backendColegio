package com.patriciocontreras.SistEscuela.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.patriciocontreras.SistEscuela.app.models.dao.IAsignaturaDao;
import com.patriciocontreras.SistEscuela.app.models.entity.Asignatura;

@Service
public class AsignaturaServiceImpl implements IAsignaturaService {

	@Autowired
	private IAsignaturaDao asignaturaDao;
	
	
	
	@Override
	@Transactional(readOnly=true)
	public List<Asignatura> findAll() {
		// TODO Auto-generated method stub
		return (List<Asignatura>) asignaturaDao.findAll();
	}
	
	@Override
	@Transactional(readOnly=true)
	public Asignatura findOne(Long id) {
		// TODO Auto-generated method stub
		return asignaturaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void save(Asignatura asignatura) {
		// TODO Auto-generated method stub
		asignaturaDao.save(asignatura);
		
	}

	

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		asignaturaDao.deleteById(id);
		
	}

}
