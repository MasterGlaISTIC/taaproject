package fr.istic.taaproject.service;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.istic.taaproject.model.Event;

public class Main {

	public static void main(String[] args) {
		/* Init Spring Default Config */
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "client-beans.xml" });
//		IUserService userService = (IUserService) context.getBean("userService");
//		
//		User developpeur = new User("Developer", "developer@developer.com",
//				"Rennes");
//		
//		System.out.println("------- ALL USERS ----------");
//		//Service
//		//userService.createUser(developpeur);
//		//userService.deleteUser(7L);
//		List<User> users = userService.getUsers();
//		
//		for (User person : users) {
//			System.out.println(person);
//		}

		
		IJourneysService journeyService =  (IJourneysService) context.getBean("journeyService");
		
		List<Event> journeys = journeyService.journeys();
		
		System.out.println(journeys.size());
		for (Event event : journeys) {
			System.out.println(event.getName());
		}
	}
}
