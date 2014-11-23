package fr.istic.taaproject.service;

import fr.istic.taaproject.model.User;

public interface IUserService {
	//public List<User> getUsers();
	public String getUsers();
	public void createUser(User user);
}
