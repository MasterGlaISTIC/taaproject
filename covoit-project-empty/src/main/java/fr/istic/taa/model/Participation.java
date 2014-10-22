package fr.istic.taa.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

/**
 * 
 */

@Entity
public class Participation implements Serializable {

	private static final long serialVersionUID = 7400709297340150637L;

	/*
	 * @EmbeddedId
	 * 
	 * @AttributeOverrides({
	 * 
	 * @AttributeOverride(name = "idEvent", column = @Column(name = "idEvent")),
	 * 
	 * @AttributeOverride(name = "idUser", column = @Column(name = "idUser")) })
	 * 
	 * @Column(nullable = false) private long idEvent;
	 * 
	 * @Column(nullable = false) private long idUser;
	 */

	@EmbeddedId
	protected InfoPK infoPK;
/*
	@OneToMany(mappedBy = "participation")
	private Set<Event> event;

	@OneToMany(mappedBy = "participation")
	protected Set<User> participant;
*/
	/**
	 *
	 */
	public Participation() {
		super();
	}

	/**
	 * 
	 */
/*
	public long getIdEvent() {
		return this.idEvent;
	}


	 
	public long getIdUser() {
		return this.idUser;
	}
*/
	/**
	 *
	 
	public Set<Event> getEvent() {
		if (this.event == null) {
			this.event = new HashSet<Event>();
		}
		return (Set<Event>) this.event;
	}


	public Set<User> getParticipant() {
		if (this.participant == null) {
			this.participant = new HashSet<User>();
		}
		return (Set<User>) this.participant;
	}

	

	public void addAllEvent(Set<Event> newEvent) {
		if (this.event == null) {
			this.event = new HashSet<Event>();
		}
		for (Event tmp : newEvent)
			tmp.setParticipation(this);

	}



	public void addAllParticipant(Set<User> newParticipant) {
		if (this.participant == null) {
			this.participant = new HashSet<User>();
		}
		for (User tmp : newParticipant)
			tmp.setParticipation(this);

	}


	public void removeAllEvent(Set<Event> newEvent) {
		if (this.event == null) {
			return;
		}

		this.event.removeAll(newEvent);
	}


	public void removeAllParticipant(Set<User> newParticipant) {
		if (this.participant == null) {
			return;
		}

		this.participant.removeAll(newParticipant);
	}

	/**
	 * 
	 
	public void setIdEvent(long myIdEvent) {
		this.idEvent = myIdEvent;
	}


	public void setIdUser(long myIdUser) {
		this.idUser = myIdUser;
	}


	public void addEvent(Event newEvent) {
		if (this.event == null) {
			this.event = new HashSet<Event>();
		}

		if (this.event.add(newEvent))
			newEvent.basicSetParticipation(this);
	}


	public void addParticipant(User newParticipant) {
		if (this.participant == null) {
			this.participant = new HashSet<User>();
		}

		if (this.participant.add(newParticipant))
			newParticipant.basicSetParticipation(this);
	}

	/**
	 * 
	 
	public void unsetIdEvent() {
		this.idEvent = 0L;
	}


	public void unsetIdUser() {
		this.idUser = 0L;
	}


	public void removeEvent(Event oldEvent) {
		if (this.event == null)
			return;

		if (this.event.remove(oldEvent))
			oldEvent.unsetParticipation();

	}


	public void removeParticipant(User oldParticipant) {
		if (this.participant == null)
			return;

		if (this.participant.remove(oldParticipant))
			oldParticipant.unsetParticipation();

	}
*/
	@Embeddable
	public class InfoPK implements Serializable {
		private static final long serialVersionUID = 1L;

		private long idUser;

		private long idEvent;

		public long getIdUser() {
			return idUser;
		}

		public void setIdUser(long idUser) {
			this.idUser = idUser;
		}

		public long getIdEvent() {
			return idEvent;
		}

		public void setIdEvent(long idEvent) {
			this.idEvent = idEvent;
		}

	}

}
