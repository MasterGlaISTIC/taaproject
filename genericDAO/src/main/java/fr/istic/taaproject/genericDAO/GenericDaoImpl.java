package fr.istic.taaproject.genericDAO;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
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

	@SuppressWarnings("unchecked")
	public GenericDaoImpl() {
		ParameterizedType genericSuperclass = (ParameterizedType) getClass()
				.getGenericSuperclass();
		this.entityClass = (Class<T>) genericSuperclass
				.getActualTypeArguments()[0];
	}

	@Transactional
	public T create(T t) {
		System.out.println("Persist "+t.toString());
		this.entityManager.persist(t);
		return t;
	}

	public T read(PK id) {
		return this.entityManager.find(entityClass, id);
	}


	public T update(T t) {
		return this.entityManager.merge(t);
	}


	public void delete(T t) {
		t = this.entityManager.merge(t);
		this.entityManager.remove(t);
	}

}
