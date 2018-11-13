package com.patriciocontreras.SistEscuela.app.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.patriciocontreras.SistEscuela.app.models.entity.Escuela;
//se marca la clase como un componente de persistencia acceso a datos
@Repository("escuelaDaoJPA")
public class EscuelaDaoImpl implements IEscuelaDao {

	//se inyecta entityManager con la siguiente anotacion
	@PersistenceContext //contiene la unidad de persistencia
	private EntityManager em;
	
	@SuppressWarnings("unchecked")//se suprime el mensaje warning
	@Transactional(readOnly=true)//de lectura, transaccional porque es de lectura
	@Override
	public List<Escuela> findAll() {
		// TODO Auto-generated method stub
		return em.createQuery("from Escuela").getResultList();
	}

	@Override
	@Transactional
	public void save(Escuela escuela) {
		em.persist(escuela);
		
	}

}
