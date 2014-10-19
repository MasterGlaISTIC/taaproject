package model.domain;
import java.util.Set;
import java.util.HashSet;


/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */
 
@javax.persistence.Entity 
public class Participation
{
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	 
	@javax.persistence.Column(nullable = false) 
	protected long idEvent;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	 
	@javax.persistence.Column(nullable = false) 
	protected long idUser;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	 
	@javax.persistence.OneToMany(mappedBy = "participation") 
	protected Set<Event> event;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	 
	@javax.persistence.OneToMany(mappedBy = "participation") 
	protected Set<User> participant;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	@javax.persistence.Id 
	@javax.persistence.Column(nullable = false) 
	protected final Long id = 0L;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 */
	public Participation(){
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public long getIdEvent() {
		return this.idEvent;	
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public long getIdUser() {
		return this.idUser;	
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
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
	 * @generated
	 * @ordered
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
	 * @generated
	 * @ordered
	 */
	public long getId() {
		return this.id;	
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
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
	 * @generated
	 * @ordered
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
	 * @generated
	 * @ordered
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
	 * @generated
	 * @ordered
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
	 * @generated
	 * @ordered
	 */
	public void setIdEvent(long myIdEvent) {
		this.idEvent = myIdEvent;	
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void setIdUser(long myIdUser) {
		this.idUser = myIdUser;	
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
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
	 * @generated
	 * @ordered
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
	 * @generated
	 * @ordered
	 */
	public void unsetIdEvent() {
		this.idEvent = 0L;	
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void unsetIdUser() {
		this.idUser = 0L;	
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
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
	 * @generated
	 * @ordered
	 */
	public void removeParticipant(User oldParticipant) {
		if(this.participant == null)
			return;
		
		if (this.participant.remove(oldParticipant))
			oldParticipant.unsetParticipation();
			
	}
	
}

