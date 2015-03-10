package fr.istic.taaproject.genericDAO;

import java.io.Serializable;
import java.util.List;

import fr.istic.taaproject.model.User;

public interface InterfaceUserDao extends GenericDao<User, Long>, Serializable{

	List<User> getAll();
	Long getUserByEmail(String string);

	boolean authentificate(String email, String password);
}
