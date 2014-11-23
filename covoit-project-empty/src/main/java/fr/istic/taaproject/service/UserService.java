package fr.istic.taaproject.service;

import java.util.List;

import fr.istic.taaproject.genericDAO.InterfaceUserDao;
import fr.istic.taaproject.model.User;

public class UserService implements IUserService {

	InterfaceUserDao userDao = null;
	
	public List<User> getUsers(){
		return userDao.getAll();
	}

	public void createUser(User user) {
		userDao.create(user);		
	}
	
	
	public InterfaceUserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(InterfaceUserDao userDao) {
		this.userDao = userDao;
	}

}
