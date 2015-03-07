package fr.istic.taaproject.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	private String location;

	// Login
	private String email;

	// Mot de passe
	private String passwd;

	private String name;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idUser;

	@OneToMany
	private List<Car> cars;

	public void addCar(Car car) {
		if (cars == null)
			cars = new ArrayList<Car>();
		cars.add(car);
	}

	/**
	 * default constructor
	 */
	public User() {
		cars = new ArrayList<Car>();
	}

	public User(String name, String email, String location) {
		cars = new ArrayList<Car>();
		this.location = location;
		this.email = email;
		this.name = name;
	}

	public String getLocation() {
		return this.location;
	}

	public String getEmail() {
		return this.email;
	}

	public long getIdUser() {
		return this.idUser;
	}

	public List<Car> getCars() {
		return this.cars;
	}

	public String getName() {
		return name;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLocation(String myLocation) {
		this.location = myLocation;
	}

	public void setEmail(String myEmail) {
		this.email = myEmail;
	}

	public void setIdUser(long myIdUser) {
		this.idUser = myIdUser;
	}

	public void unsetLocation() {
		this.location = "";
	}

	public void unsetEmail() {
		this.email = "";
	}

	public void unsetIdUser() {
		this.idUser = 0L;
	}

	public void unsetCar() {
		if (this.cars == null)
			return;

		this.cars = null;

	}

	@Override
	public String toString() {
		return "User [location=" + location + ", email=" + email + ", name="
				+ name + ", idUser=" + idUser + ", car=" + cars + "]";
	}
}
