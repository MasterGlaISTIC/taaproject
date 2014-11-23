package fr.istic.taaproject.service;

import java.util.List;

import fr.istic.taaproject.model.User;

public interface IUserService {
	public List<User> getUsers();
	public void createUser(User user);
}
