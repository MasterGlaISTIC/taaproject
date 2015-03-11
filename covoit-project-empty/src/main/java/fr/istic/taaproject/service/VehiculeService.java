package fr.istic.taaproject.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;

import fr.istic.taaproject.genericDAO.CarDAO;
import fr.istic.taaproject.genericDAO.InterfaceCarDao;
import fr.istic.taaproject.model.Car;

@Path("/cars")
@Produces({ MediaType.APPLICATION_JSON })
@Provider
public class VehiculeService implements IVehiculeService {

	InterfaceCarDao carDao = new CarDAO();

	@GET
	@Path("/cars")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Car> getCars() {
		List<Car> users = carDao.getAllCars();
		return users;

	}

	@POST
	@Path("/addCar")
	@Consumes(MediaType.APPLICATION_JSON)
	public void createUser(Car car) {
		carDao.create(car);
	}

	public InterfaceCarDao getCarDao() {
		return carDao;
	}

	public void setCarDao(InterfaceCarDao carDao) {
		this.carDao = carDao;
	}

	@Override
	@Path("/delete/{id}")
	@DELETE
	public void deleteCar(@PathParam("id") long id) {
		Car u = carDao.read(id);
		 System.out.println("User read + "+u);
		carDao.delete(u);
	}



	@Override
	public void createCar(Car car) {
		carDao.create(car);
	}


}
