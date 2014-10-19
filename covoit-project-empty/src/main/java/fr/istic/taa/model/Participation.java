package fr.istic.taa.model;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 */
 
@Entity 
public class Participation implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7400709297340150637L;

	@EmbeddedId
	@AttributeOverrides({
	@AttributeOverride(name="idEvent", column=@Column(name="idEvent") ),
	@AttributeOverride(name="idUser", column=@Column(name="idUser") )
	})
	 
	@Column(nullable = false) 
	private long idEvent;
	
	@Column(nullable = false) 
	private long idUser;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->


	 */
	 
	@OneToMany(mappedBy = "participation") 
	private Set<Event> event;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->


	 */
	 
	@OneToMany(mappedBy = "participation") 
	protected Set<User> participant;



	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->

	 */
	public Participation(){
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->


	 */
	
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	public long getIdEvent() {
		return this.idEvent;	
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
	public Set<Event> getEvent() {
		if(this.event == null) {
				this.event = new HashSet<Event>();
		}
		return (Set<Event>) this.event;	
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->


	 */
	public Set<User> getParticipant() {
		if(this.participant == null) {
				this.participant = new HashSet<User>();
		}
		return (Set<User>) this.participant;	
	}
	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->


	 */
	public void addAllEvent(Set<Event> newEvent) {
		if (this.event == null) {
			this.event = new HashSet<Event>();
		}
		for (Event tmp : newEvent)
			tmp.setParticipation(this);
			
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->


	 */
	public void addAllParticipant(Set<User> newParticipant) {
		if (this.participant == null) {
			this.participant = new HashSet<User>();
		}
		for (User tmp : newParticipant)
			tmp.setParticipation(this);
			
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->


	 */
	public void removeAllEvent(Set<Event> newEvent) {
		if(this.event == null) {
			return;
		}
		
		this.event.removeAll(newEvent);	
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->


	 */
	public void removeAllParticipant(Set<User> newParticipant) {
		if(this.participant == null) {
			return;
		}
		
		this.participant.removeAll(newParticipant);	
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->


	 */
	public void setIdEvent(long myIdEvent) {
		this.idEvent = myIdEvent;	
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->


	 */
	public void setIdUser(long myIdUser) {
		this.idUser = myIdUser;	
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->


	 */
	public void addEvent(Event newEvent) {
		if(this.event == null) {
			this.event = new HashSet<Event>();
		}
		
		if (this.event.add(newEvent))
			newEvent.basicSetParticipation(this);	
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->


	 */
	public void addParticipant(User newParticipant) {
		if(this.participant == null) {
			this.participant = new HashSet<User>();
		}
		
		if (this.participant.add(newParticipant))
			newParticipant.basicSetParticipation(this);	
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->


	 */
	public void unsetIdEvent() {
		this.idEvent = 0L;	
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->


	 */
	public void unsetIdUser() {
		this.idUser = 0L;	
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->


	 */
	public void removeEvent(Event oldEvent) {
		if(this.event == null)
			return;
		
		if (this.event.remove(oldEvent))
			oldEvent.unsetParticipation();
			
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 */
	public void removeParticipant(User oldParticipant) {
		if(this.participant == null)
			return;
		
		if (this.participant.remove(oldParticipant))
			oldParticipant.unsetParticipation();
			
	}
	
}

