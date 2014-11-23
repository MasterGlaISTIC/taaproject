package fr.istic.taaproject.service;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.istic.taaproject.model.User;

public class Main {

	public static void main(String[] args) {
		/* Init Spring Default Config */
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "client-beans.xml" });
		IUserService userService = (IUserService) context.getBean("userService");
		
		User developpeur = new User("Developer", "developer@developer.com",
				"Rennes");
		
		System.out.println("------- ALL USERS ----------");
		//Service
		//userService.createUser(developpeur);
//		List<User> users = userService.getUsers();
//		
//		for (User person : users) {
//			System.out.println(person.getName());
//		}

	}
}
