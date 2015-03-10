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

	public Long getUserByEmail(String email){
		
		List<Long> ids = entityManager.createQuery("SELECT p.idUser FROM User p where p.email = '"+email+"'", Long.class).getResultList();
		if(ids != null)
		return ids.get(0);
		else return null;
	}

	public boolean authentificate(String email, String passwd) {
		List<User> list=  entityManager.createQuery("SELECT p FROM User p where p.email=:email and p.passwd=:passwd ", User.class)
				.setParameter("email", email)
				.setParameter("passwd", passwd).getResultList();
		if (list==null || list.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

}
