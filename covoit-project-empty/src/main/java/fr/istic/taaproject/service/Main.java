package fr.istic.taaproject.service;

import java.util.List;

import fr.istic.taaproject.genericDAO.InterfaceUserDao;
import fr.istic.taaproject.genericDAO.UserDAO;
import fr.istic.taaproject.model.User;

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
