package fr.istic.taa.main;

import java.util.List;

import fr.istic.taa.dao.InterfaceUserDao;
import fr.istic.taa.dao.UserDAO;
import fr.istic.taa.model.User;

public class Main {
	public static void main(String[] args) {
        
        InterfaceUserDao dao = new UserDAO();
        
        
               
       //User yacine = dao.read(1L);
       //System.out.println(yacine.getName());
        System.out.println("------- ALL USERS ----------");
        List<User> users = dao.getAll();
        for (User person : users) {
            System.out.println(person.getName());
        }
        
    }
}
