package fr.istic.taa.model;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


/**
 * 
 */
 
@Entity 
public class User implements Serializable
{

	private static final long serialVersionUID = 1L;

	
	private String location;
	private String email;
	
	private String name;
	
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long idUser;
 
	
	@OneToOne(optional=true)
	private Car car;

	
	@ManyToOne(optional=true)
	private Event event;

	@OneToMany(mappedBy="user", orphanRemoval=true)
	private Set<Comment> comment;

	
	@ManyToOne(optional=true)
	private Participation participation;

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
					Car oldcar = this.car;
					this.car = myCar;
					if (oldcar != null)
						oldcar.unsetUser();
				
			}
		}	
	}
	
	/**
	 * 
	 */
	public void basicSetEvent(Event myEvent) {
		if (this.event != myEvent) {
			if (myEvent != null){
				if (this.event != myEvent) {
					Event oldevent = this.event;
					this.event = myEvent;
					if (oldevent != null)
						oldevent.removeCreateur(this);
				}
			}
		}	
	}
	
	/**
	 * 
	 */
	public void basicSetParticipation(Participation myParticipation) {
		if (this.participation != myParticipation) {
			if (myParticipation != null){
				if (this.participation != myParticipation) {
					//Participation oldparticipation = this.participation;
					this.participation = myParticipation;
					/*if (oldparticipation != null)
						oldparticipation.removeParticipant(this);*/
				}
			}
		}	
	}
	
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
	public Event getEvent() {
		return this.event;	
	}
	
	/**
	 * 
	 */
	public Set<Comment> getComment() {
		if(this.comment == null) {
				this.comment = new HashSet<Comment>();
		}
		return (Set<Comment>) this.comment;	
	}
	
	/**
	 * 
	 */
	public Participation getParticipation() {
		return this.participation;	
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 *
	 */
	public void addAllComment(Set<Comment> newComment) {
		if (this.comment == null) {
			this.comment = new HashSet<Comment>();
		}
		for (Comment tmp : newComment)
			tmp.setUser(this);
			
	}
	
	
	public void removeAllComment(Set<Comment> newComment) {
		if(this.comment == null) {
			return;
		}
		
		this.comment.removeAll(newComment);	
	}
	
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
		myCar.basicSetUser(this);
			
	}
	
	/**
	 * 
	 */
	public void setEvent(Event myEvent) {
		this.basicSetEvent(myEvent);
		myEvent.addCreateur(this);	
	}
	
	/**
	 * 
	 */
	public void addComment(Comment newComment) {
		if(this.comment == null) {
			this.comment = new HashSet<Comment>();
		}
		
		if (this.comment.add(newComment))
			newComment.basicSetUser(this);	
	}
	
	/**
	 * 
	 */
	public void setParticipation(Participation myParticipation) {
		this.basicSetParticipation(myParticipation);
		//myParticipation.addParticipant(this);	
	}
	
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
		Car oldcar = this.car;
		this.car = null;
		oldcar.unsetUser();	
	}
	
	/**
	 * 
	 */
	public void unsetEvent() {
		if (this.event == null)
			return;
		Event oldevent = this.event;
		this.event = null;
		oldevent.removeCreateur(this);	
	}
	
	/**
	 * 
	 */
	public void removeComment(Comment oldComment) {
		if(this.comment == null)
			return;
		
		if (this.comment.remove(oldComment))
			oldComment.unsetUser();
			
	}
	
	/**
	 *  
	 */
	public void unsetParticipation() {
		if (this.participation == null)
			return;
		//Participation oldparticipation = this.participation;
		this.participation = null;
		//oldparticipation.removeParticipant(this);	
	}
	
}

