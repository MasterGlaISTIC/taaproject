package fr.istic.taa.main;

import java.util.List;

import fr.istic.taa.dao.InterfaceUserDao;
import fr.istic.taa.dao.UserDAO;
import fr.istic.taa.model.User;

public class Main {
	public static void main(String[] args) {
        
        InterfaceUserDao dao = new UserDAO();
         
        User peter = new User();
        peter.setName("Peter");
        User nasta = new User();
        nasta.setName("Nasta");
         
        dao.create(peter);
        dao.create(nasta);
         
        List<User> users = dao.getAll();
        for (User person : users) {
            System.out.println(person);
        }
        
    }
}
