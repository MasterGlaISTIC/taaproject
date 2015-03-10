package fr.istic.taaproject.service;

import java.util.List;

import fr.istic.taaproject.model.User;

public interface IUserService {
	public List<User> getUsers();
	public void createUser(User user);

//	public void deleteUser(String string);
	public void deleteUser(Long id);
	public Long getIdUserByEmail(String string);
	public void updateUser(User developpeur);

	public boolean loginUser(User user);
}
