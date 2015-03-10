package fr.istic.taaproject.genericDAO;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

public class GenericDaoImpl<T, PK extends Serializable> implements
		GenericDao<T, PK> {

	protected Class<T> entityClass;
	EntityManagerFactory factory = Persistence
			.createEntityManagerFactory("mysql");

	@PersistenceContext
	protected EntityManager entityManager = factory.createEntityManager();
	
	EntityTransaction transaction = entityManager.getTransaction();

	@SuppressWarnings("unchecked")
	public GenericDaoImpl() {
		ParameterizedType genericSuperclass = (ParameterizedType) getClass()
				.getGenericSuperclass();
		this.entityClass = (Class<T>) genericSuperclass
				.getActualTypeArguments()[0];
	}

	@Transactional
	public T create(T t) {
		transaction.begin();
		this.entityManager.persist(t);
		transaction.commit();
		
		return t;
	}

	public T read(PK id) {
		return this.entityManager.find(entityClass, id);
	}


	public T update(T t) {
		transaction.begin();
		this.entityManager.merge(t);
		transaction.commit();
		
		return t;
	}


	public void delete(T t) {
		t = this.entityManager.merge(t);
		System.out.println("T = "+t);
		transaction.begin();
		this.entityManager.remove(t);
		transaction.commit();
		
	}

}
