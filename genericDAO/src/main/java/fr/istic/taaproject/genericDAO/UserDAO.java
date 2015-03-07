package fr.istic.taaproject.genericDAO;

import java.util.List;

import fr.istic.taaproject.model.User;

public class UserDAO extends GenericDaoImpl<User, Long> implements InterfaceUserDao{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public List<User> getAll() {
		 return entityManager.createQuery("SELECT p FROM User p", User.class).getResultList();
	}

}
