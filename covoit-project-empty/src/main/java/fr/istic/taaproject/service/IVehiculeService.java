package fr.istic.taaproject.service;

import java.util.List;

import fr.istic.taaproject.model.Car;

public interface IVehiculeService {
	public List<Car> getCars();
	public void createCar(Car car);
	public void deleteCar(long id);
}
