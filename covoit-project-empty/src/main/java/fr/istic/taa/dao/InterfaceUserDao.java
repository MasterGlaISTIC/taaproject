package fr.istic.taa.dao;

import java.io.Serializable;
import java.util.List;

import fr.istic.taa.model.User;

public interface InterfaceUserDao extends GenericDao<User, Serializable>{

	List<User> getAll();
}
