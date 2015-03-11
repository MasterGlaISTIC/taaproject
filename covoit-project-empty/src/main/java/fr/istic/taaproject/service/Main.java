package fr.istic.taaproject.service;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.istic.taaproject.model.Event;
import fr.istic.taaproject.model.User;

public class Main {

	public static void main(String[] args) {
		/* Init Spring Default Config */
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "client-beans.xml" });
		IUserService userService = (IUserService) context.getBean("userService");
		IVehiculeService carService = (IVehiculeService) context.getBean("vehiculeService");
		IJourneysService journeyService = (IJourneysService) context.getBean("journeyService");
		
		
//		User developpeur = new User("Mohssine", "mohssine.amhachi@gmail.com",
//				"Rennes");
//		Car car = new Car(4);
//		Event eventUser = new Event("Rennes","Fourmie", new Date());
//		
//		journeyService.createEvent(eventUser);
//		developpeur.addEvent(eventUser);
//		userService.updateUser(developpeur);
		
		User developpeur = new User("Yacine", "yacine@gmail.com",
				"Rennes");
		userService.createUser(developpeur);
//		Long id = userService.getIdUserByEmail("mohssine.amhachi@gmail.com");
//		System.out.print("L'id de mohssine.amhachi@gmail.com est : +"
//				+ id);
//		userService.deleteUser("mohssine.amhachi@gmail.com");
//		carService.createCar(car);
		
//		developpeur.addCar(car);
//		userService.createUser(developpeur);
		
		
		System.out.println("------- ALL USERS ----------");

		List<User> users = userService.getUsers();
		
		for (User person : users) {
			System.out.println(person);
		}
		
		List<Event> journeys = journeyService.journeys();
		
		System.out.println(journeys.size());
		for (Event event : journeys) {
			System.out.println(event);
		}
	}
}
