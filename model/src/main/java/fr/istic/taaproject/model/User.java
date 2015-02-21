package fr.istic.taaproject.model;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/**
 * 
 */
 
@Entity
public class User implements Serializable
{

	private static final long serialVersionUID = 1L;

	
	private String location;

	//Login
	private String email;
	
	//Mot de passe
	private String passwd;
	
	@Override
	public String toString() {
		return "User [location=" + location + ", email=" + email + ", name=" + name + ", idUser=" + idUser + ", car="
				+ car + "]";
	}

	private String name;

	
	
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long idUser;
 
	
	private Car car;

	
//	@ManyToOne(optional=true)
//	private Event event;


	/**
	 * default constructor 
	 */
	public User(){
		super();
	}

	

	public User(String name, String email, String location) {
		super();
		this.location = location;
		this.email = email;
		this.name = name;
	}



	/**
	 *  
	 */
	public void basicSetCar(Car myCar) {
		if (this.car != myCar) {
			if (myCar != null){
//					Car oldcar = this.car;
					this.car = myCar;
//					if (oldcar != null)
//						oldcar.unsetUser();
				
			}
		}	
	}
	
//	/**
//	 * 
//	 */
//	public void basicSetEvent(Event myEvent) {
//		if (this.event != myEvent) {
//			if (myEvent != null){
//				if (this.event != myEvent) {
//					Event oldevent = this.event;
//					this.event = myEvent;
//					if (oldevent != null)
//						oldevent.removeCreateur(this);
//				}
//			}
//		}	
//	}
//	

	/**
	 * 
	 */
	public String getLocation() {
		return this.location;	
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	
	 
	 */
	public String getEmail() {
		return this.email;	
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	
	 
	 */
	
	
	public long getIdUser() {
		return this.idUser;	
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	
	 
	 */
	public Car getCar() {
		return this.car;	
	}
	
	/**
	 * 
	 */
//	public Event getEvent() {
//		return this.event;	
//	}
	
	/**
	 * 
	 */
//	public Set<Comment> getComment() {
//		if(this.comment == null) {
//				this.comment = new HashSet<Comment>();
//		}
//		return (Set<Comment>) this.comment;	
//	}
	

	
	
	public String getName() {
		return name;
	}

	public String getPasswd() {
		return passwd;
	}



	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}



//	public void setComment(Set<Comment> comment) {
//		this.comment = comment;
//	}



	public void setName(String name) {
		this.name = name;
	}

	/**
	 *
	 */
//	public void addAllComment(Set<Comment> newComment) {
//		if (this.comment == null) {
//			this.comment = new HashSet<Comment>();
//		}
//		for (Comment tmp : newComment)
//			tmp.setUser(this);
//			
//	}
	
	
//	public void removeAllComment(Set<Comment> newComment) {
//		if(this.comment == null) {
//			return;
//		}
//		
//		this.comment.removeAll(newComment);	
//	}
//	
	/**
	 * 
	 */
	public void setLocation(String myLocation) {
		this.location = myLocation;	
	}
	
	/**
	 * 
	 */
	public void setEmail(String myEmail) {
		this.email = myEmail;	
	}
	
	/**
	 * 
	 */
	public void setIdUser(long myIdUser) {
		this.idUser = myIdUser;	
	}
	
	/**
	 * 
	 */
	public void setCar(Car myCar) {
		this.basicSetCar(myCar);
//		myCar.basicSetUser(this);
			
	}
	
	/**
	 * 
	 */
//	public void setEvent(Event myEvent) {
//		this.basicSetEvent(myEvent);
//		myEvent.addCreateur(this);	
//	}
//	
	/**
	 * 
	 */
//	public void addComment(Comment newComment) {
//		if(this.comment == null) {
//			this.comment = new HashSet<Comment>();
//		}
//		
//		if (this.comment.add(newComment))
//			newComment.basicSetUser(this);	
//	}
	

	
	/**
	 * 
	 */
	public void unsetLocation() {
		this.location = "";	
	}
	
	/**
	 * 
	 */
	public void unsetEmail() {
		this.email = "";	
	}
	
//	@Override
//	public String toString() {
//		return "User [location=" + location + ", email=" + email + ", name="
//				+ name + ", idUser=" + idUser + ", car=" + car + ", comment="
//				+ comment + "]";
//	}



	/**
	 * 
	 */
	public void unsetIdUser() {
		this.idUser = 0L;	
	}
	
	/**
	 * 
	 */
	public void unsetCar() {
		if (this.car == null)
			return;
//		Car oldcar = this.car;
		this.car = null;
//		oldcar.unsetUser();	
	}
	
	/**
	 * 
	 */
//	public void unsetEvent() {
//		if (this.event == null)
//			return;
//		Event oldevent = this.event;
//		this.event = null;
//		oldevent.removeCreateur(this);	
//	}
	
	/**
	 * 
	 */
//	public void removeComment(Comment oldComment) {
//		if(this.comment == null)
//			return;
//		
//		if (this.comment.remove(oldComment))
//			oldComment.unsetUser();
//			
//	}
	

	
}

