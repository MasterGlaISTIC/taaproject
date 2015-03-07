package fr.istic.taaproject.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Car implements Serializable {

	private static final long serialVersionUID = 1L;


	private int nbrPlaces;

	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(nullable = false)
	private Long idCar;

	public Car() {
		super();
	}
	

	@Override
	public String toString() {
		return "Car [nbrPlaces=" + nbrPlaces + ", idCar=" + idCar + "]";
	}


	public Car(int nbrPlaces) {

		this.nbrPlaces = nbrPlaces;
	}


	public int getNbrPlaces() {
		return this.nbrPlaces;
	}

	public long getIdCar() {
		return this.idCar;
	}

	public void setNbrPlaces(int myNbrPlaces) {
		this.nbrPlaces = myNbrPlaces;
	}


	public void setIdCar(long myIdCar) {
		this.idCar = myIdCar;
	}

	public void unsetNbrPlaces() {
		this.nbrPlaces = 0;
	}

	public void unsetIdCar() {
		this.idCar = 0L;
	}


}
