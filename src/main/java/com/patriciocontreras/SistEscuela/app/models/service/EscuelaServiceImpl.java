package com.patriciocontreras.SistEscuela.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.patriciocontreras.SistEscuela.app.models.dao.IEscuelaDao;
import com.patriciocontreras.SistEscuela.app.models.entity.Escuela;

//una clase service esta basado en el patron de diseño fakecade o fachada
//un unico punto de acceso hacia distintos daos o repository
//la idea de clase service que por cada metodo en la clase DAO  vamos a tener metodos en el escuela 
//service
@Service 
public class EscuelaServiceImpl implements IEscuelaService{
	
	@Autowired
	private IEscuelaDao escuelaDao;
	

	
	@Override
	@Transactional(readOnly=true)//de lectura, transaccional porque es de lectura
	public List<Escuela> findAll() {
		// TODO Auto-generated method stub
		return (List<Escuela>) escuelaDao.findAll();
	}
	
	@Override
	@Transactional(readOnly=true)
	public Escuela findOne(Long id) {
		// TODO Auto-generated method stub
		//el orElse se usa para retornar el objeto entity encontrado 
		//o bien null en caso que venga vacio
		return escuelaDao.findById(id).orElse(null);
	}


	@Override
	@Transactional
	public void save(Escuela escuela) {
		// TODO Auto-generated method stub
		escuelaDao.save(escuela);
		
	}


	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		escuelaDao.deleteById(id);
		
	}

}
