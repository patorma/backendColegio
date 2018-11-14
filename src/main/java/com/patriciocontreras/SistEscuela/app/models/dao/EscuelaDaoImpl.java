package com.patriciocontreras.SistEscuela.app.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.patriciocontreras.SistEscuela.app.models.entity.Escuela;
//se marca la clase como un componente de persistencia acceso a datos
@Repository("escuelaDaoJPA")
public class EscuelaDaoImpl implements IEscuelaDao {

	//se inyecta entityManager con la siguiente anotacion
	@PersistenceContext //contiene la unidad de persistencia
	private EntityManager em;
	
	@SuppressWarnings("unchecked")//se suprime el mensaje warning
	@Override
	public List<Escuela> findAll() {
		// TODO Auto-generated method stub
		return em.createQuery("from Escuela").getResultList();
	}
	

	@Override
	public Escuela findOne(Long id) {//va a la bd y entrega el objeto escuela
		// TODO Auto-generated method stub
		return em.find(Escuela.class, id);
	}

	//save es tanto para editar que para insertar
	@Override
	public void save(Escuela escuela) {
		if(escuela.getId() != null && escuela.getId() > 0) {
			em.merge(escuela); //actualiza este metodo los datos existentes osea actualiza escuela
			//si id existe
		}else {
			
		em.persist(escuela);//el persist crea una nueva escuela , despues la inserta y
		//relaciona al concepto de persistencia
		}
	}

	@Override
	public void delete(Long id) {
		//obtiene el id, luego lo busca el objeto escuela y lo elimina 
		em.remove(findOne(id));
		
	}

}
