package fr.istic.taaproject.genericDAO;

import java.io.Serializable;


import java.util.List;

import fr.istic.taaproject.model.User;

public class UserDAO extends GenericDaoImpl<User, Serializable> implements InterfaceUserDao{

	public List<User> getAll() {
		 return entityManager.createQuery("SELECT p FROM User p", User.class).getResultList();
	}

}
