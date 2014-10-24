package fr.istic.taa.main;

import java.util.List;

import fr.istic.taa.dao.InterfaceUserDao;
import fr.istic.taa.dao.UserDAO;
import fr.istic.taa.model.User;

public class Main {
	public static void main(String[] args) {
        
        InterfaceUserDao dao = new UserDAO();
         
        User peter = new User("AMHACHI","m.amhachi@gmail.com","Rennes");
           
        
        dao.create(peter);
        
        User amhachi = dao.read(1L);
        amhachi.setEmail("m.amhachi@gmail.com");
        dao.update(amhachi);
        System.out.println(amhachi.getName());
        
        List<User> users = dao.getAll();
        for (User person : users) {
            System.out.println(person);
        }
        
    }
}
