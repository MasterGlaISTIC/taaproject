package fr.istic.taaproject.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Car implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Attribut qui représente le nombre de palces de la voiture
	 * 
	 * 
	 * 
	 */

	private int nbrPlaces;

	/**
	 * Attribut qui représente l'identifiant de la voiture
	 * 
	 * 
	 * 
	 */
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(nullable = false)
	private long idCar;

	/**
	 * Attribut qui représente l'utilisatuer de la voiture
	 * 
	 * 
	 * 
	 */

//	@OneToOne(mappedBy = "car")
//	private User user;

	/**
	 * Constructeur par défault de la voiture
	 * 
	 * 
	 */
	public Car() {
		super();
	}

	/**
	 * Fonction qui unitialise l'utilisateur de la voiture
	 * 
	 * 
	 * 
	 */
//	public void basicSetUser(User myUser) {
//		if (this.user != myUser) {
//			if (myUser != null) {
//				User olduser = this.user;
//				this.user = myUser;
//				if (olduser != null)
//					olduser.unsetCar();
//
//			}
//		}
//	}

	/**
	 * getter de nombre de places
	 * 
	 * 
	 * 
	 */
	public int getNbrPlaces() {
		return this.nbrPlaces;
	}

	/**
	 * getter de l'identifiant de la voiture
	 * 
	 * 
	 * 
	 */

	public long getIdCar() {
		return this.idCar;
	}

	/**
	 * getter de l'utilisateur de la voiture
	 * 
	 * 
	 * 
	 */
//	public User getUser() {
//		return this.user;
//	}

	/**
	 * setter de nombre de places
	 * 
	 * 
	 * 
	 */
	public void setNbrPlaces(int myNbrPlaces) {
		this.nbrPlaces = myNbrPlaces;
	}

	/**
	 * setter de l'identifiant de la voiture
	 * 
	 * 
	 * 
	 */
	public void setIdCar(long myIdCar) {
		this.idCar = myIdCar;
	}

	/**
	 * setter de l'utilisateur de la voiture
	 * 
	 * 
	 * 
	 */
//	public void setUser(User myUser) {
//		this.basicSetUser(myUser);
//		myUser.basicSetCar(this);
//
//	}

	/**
	 * unsetter de nombre de places
	 * 
	 * 
	 * 
	 */
	public void unsetNbrPlaces() {
		this.nbrPlaces = 0;
	}

	/**
	 * unsetter de l'identifiant de la voiture
	 * 
	 * 
	 * 
	 */
	public void unsetIdCar() {
		this.idCar = 0L;
	}

	/**
	 * unsetter de l'utilisateur de la voiture
	 * 
	 * 
	 * 
	 */
//	public void unsetUser() {
//		if (this.user == null)
//			return;
//		User olduser = this.user;
//		this.user = null;
//		olduser.unsetCar();
//	}

}
