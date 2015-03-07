package fr.istic.taaproject.genericDAO;

import java.io.Serializable;
import java.util.List;

import fr.istic.taaproject.model.Car;

public interface InterfaceCarDao extends Serializable, GenericDao<Car, Long>{
  List<Car> getAllCars();
}
