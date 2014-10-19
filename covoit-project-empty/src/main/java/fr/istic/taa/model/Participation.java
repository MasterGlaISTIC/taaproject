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
 * 
 */
 
@Entity 
public class Participation implements Serializable
{

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

	@OneToMany(mappedBy = "participation") 
	private Set<Event> event;

	@OneToMany(mappedBy = "participation") 
	protected Set<User> participant;



	/**
	 *
	 */
	public Participation(){
		super();
	}

	/**
	 * 
	 */
	
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	public long getIdEvent() {
		return this.idEvent;	
	}
	
	/**
	 * 
	 */
	public long getIdUser() {
		return this.idUser;	
	}
	
	/**
	 *
	 */
	public Set<Event> getEvent() {
		if(this.event == null) {
				this.event = new HashSet<Event>();
		}
		return (Set<Event>) this.event;	
	}
	
	/**
	 * 
	 */
	public Set<User> getParticipant() {
		if(this.participant == null) {
				this.participant = new HashSet<User>();
		}
		return (Set<User>) this.participant;	
	}
	
	
	/**
	 * 
	 */
	public void addAllEvent(Set<Event> newEvent) {
		if (this.event == null) {
			this.event = new HashSet<Event>();
		}
		for (Event tmp : newEvent)
			tmp.setParticipation(this);
			
	}
	
	/**
	 * 
	 */
	public void addAllParticipant(Set<User> newParticipant) {
		if (this.participant == null) {
			this.participant = new HashSet<User>();
		}
		for (User tmp : newParticipant)
			tmp.setParticipation(this);
			
	}
	
	/**
	 * 
	 */
	public void removeAllEvent(Set<Event> newEvent) {
		if(this.event == null) {
			return;
		}
		
		this.event.removeAll(newEvent);	
	}
	
	/**
	 * 
	 */
	public void removeAllParticipant(Set<User> newParticipant) {
		if(this.participant == null) {
			return;
		}
		
		this.participant.removeAll(newParticipant);	
	}
	
	/**
	 * 
	 */
	public void setIdEvent(long myIdEvent) {
		this.idEvent = myIdEvent;	
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
	public void addEvent(Event newEvent) {
		if(this.event == null) {
			this.event = new HashSet<Event>();
		}
		
		if (this.event.add(newEvent))
			newEvent.basicSetParticipation(this);	
	}
	
	/**
	 * 
	 */
	public void addParticipant(User newParticipant) {
		if(this.participant == null) {
			this.participant = new HashSet<User>();
		}
		
		if (this.participant.add(newParticipant))
			newParticipant.basicSetParticipation(this);	
	}
	
	/**
	 * 
	 */
	public void unsetIdEvent() {
		this.idEvent = 0L;	
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
	public void removeEvent(Event oldEvent) {
		if(this.event == null)
			return;
		
		if (this.event.remove(oldEvent))
			oldEvent.unsetParticipation();
			
	}
	
	/**
	 * 
	 */
	public void removeParticipant(User oldParticipant) {
		if(this.participant == null)
			return;
		
		if (this.participant.remove(oldParticipant))
			oldParticipant.unsetParticipation();
			
	}
	
}

