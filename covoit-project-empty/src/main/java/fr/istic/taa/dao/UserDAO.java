package fr.istic.taa.dao;

import java.io.Serializable;
import java.util.List;

import fr.istic.taa.model.User;

public class UserDAO extends GenericDaoImpl<User, Serializable> implements InterfaceUserDao{

	@Override
	public List<User> getAll() {
		 return entityManager.createQuery("SELECT p FROM User p", User.class).getResultList();
	}

}
