package fr.istic.taaproject.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;

import fr.istic.taaproject.genericDAO.InterfaceUserDao;
import fr.istic.taaproject.genericDAO.UserDAO;
import fr.istic.taaproject.model.User;

@Path("/users")
@Produces({ MediaType.APPLICATION_JSON })
@Provider
public class UserService implements IUserService {

	InterfaceUserDao userDao = new UserDAO();

	@GET
	@Path("/users")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<User> getUsers() {
		List<User> users = userDao.getAll();
		System.out.println("get");
		return users;

	}


	@Override
	@POST
	@Path("/addUser")
	@Consumes({ MediaType.APPLICATION_JSON })
	public void createUser(User user) {
		userDao.create(user);
		System.out.println("ssssssssss");
	}

//	@Override
//	@Path("/delete/{email}")
//	@DELETE
//	public void deleteUser(@PathParam("email") String email) {
//		Long id = userDao.getUserByEmail(email);
//		System.out.println("--------------> ID "+id);
//		//User u = userDao.read(id);
//		//userDao.delete(u);
//	}
	
	@Override
	@Path("/delete/{id}")
	@DELETE
	public void deleteUser(@PathParam("id") Long id) {
//		Long id = userDao.getUserByEmail(email);
		System.out.println("DELETING --------------> ID "+id);
		User u = userDao.read(id);
		userDao.delete(u);
	}
	
	public InterfaceUserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(InterfaceUserDao userDao) {
		this.userDao = userDao;
	}


	
	
	@Override
	@Path("/getIdUser/{email}")
	@GET
	public Long getIdUserByEmail(@PathParam("email") String string) {
		System.out.println("Azzuuuuuuuuuuuuul");
		return userDao.getUserByEmail(string);
		
	}

	@Override
	public void updateUser(User developpeur) {
		userDao.update(developpeur);
		
	}

}
