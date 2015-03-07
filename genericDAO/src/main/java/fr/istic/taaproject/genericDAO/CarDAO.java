package fr.istic.taaproject.genericDAO;

import java.util.List;

import fr.istic.taaproject.model.Car;



public class CarDAO extends GenericDaoImpl<Car, Long> implements InterfaceCarDao{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public List<Car> getAllCars() {
		return entityManager.createQuery("SELECT c FROM Car c", Car.class).getResultList();
	}




}
