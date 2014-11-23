package fr.istic.taaproject.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;

import org.springframework.dao.support.DaoSupport;

import fr.istic.taaproject.genericDAO.InterfaceUserDao;
import fr.istic.taaproject.genericDAO.UserDAO;
import fr.istic.taaproject.model.User;

@Path("/users")
@Provider
public class UserService implements IUserService {

	InterfaceUserDao userDao = new UserDAO();
	
	@GET
	@Produces({ MediaType.TEXT_HTML })
	@Path("/users")
	public String getUsers(){
		List<User> users = userDao.getAll();
		StringBuffer returnHTML = new StringBuffer();
		
		returnHTML.append("<html><title> Wen services</title><body>");
		for (User person : users) {
			returnHTML.append("<h4>");
			returnHTML.append(person.getName());
			returnHTML.append("</h4>");
		}
		returnHTML.append("</body></html>");
		return returnHTML.toString();

		
	}

	@PUT
	@Path("/addUser")
	@Produces({ MediaType.APPLICATION_JSON })
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
