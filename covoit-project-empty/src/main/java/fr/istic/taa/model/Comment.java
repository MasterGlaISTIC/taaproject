package fr.istic.taa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * 
 * 
 * 
 */

@Entity
public class Comment implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Attribut qui représente l'identifiant du commentaire
	 */

	@Column(nullable = false)
	private long idComment;

	/**
	 * Attribut qui représente le vrai commentaire
	 * 
	 */

	private String comment;

	/**
	 * Evenement auquel est attaché le commentaire
	 * 
	 * 
	 */

	@ManyToOne
	@JoinColumn(nullable = false)
	private Event event;

	/**
	 * L'utilisateur qui a poser le commentaire
	 */

	@ManyToOne
	protected User user;

	/**
	 * constructeur par defaut de la classe commentaire
	 * 
	 */
	public Comment() {
		super();
	}

	/**
	 *
	 */
	public void basicSetUser(User myUser) {
		if (this.user != myUser) {
			if (myUser != null) {
				if (this.user != myUser) {
					User olduser = this.user;
					this.user = myUser;
					if (olduser != null)
						olduser.removeComment(this);
				}
			}
		}
	}

	/**
	 * 
	 * 
	 * 
	 * 
	 */
	public void basicSetEvent(Event myEvent) {
		if (this.event != myEvent) {
			if (myEvent != null) {
				if (this.event != myEvent) {
					Event oldevent = this.event;
					this.event = myEvent;
					if (oldevent != null)
						oldevent.removeComment(this);
				}
			}
		}
	}

	/**
	 * 
	 * 
	 * 
	 * 
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getIdComment() {
		return this.idComment;
	}

	/**
	 * 
	 * 
	 * 
	 * 
	 */
	public String getComment() {
		return this.comment;
	}

	/**
	 * 
	 * 
	 * 
	 * 
	 */
	public Event getEvent() {
		return this.event;
	}

	/**
	 * 
	 * 
	 * 
	 * 
	 */
	public User getUser() {
		return this.user;
	}

	/**
	 * 
	 * 
	 * 
	 * 
	 */
	public void setIdComment(long myIdComment) {
		this.idComment = myIdComment;
	}

	/**
	 * 
	 * 
	 * 
	 * 
	 */
	public void setComment(String myComment) {
		this.comment = myComment;
	}

	/**
	 * 
	 * 
	 * 
	 * 
	 */
	public void setEvent(Event myEvent) {
		this.basicSetEvent(myEvent);
		myEvent.addComment(this);
	}

	public void setUser(User myUser) {
		this.basicSetUser(myUser);
		myUser.addComment(this);
	}

	/**
	 * 
	 * 
	 * 
	 * 
	 */
	public void unsetIdComment() {
		this.idComment = 0L;
	}

	/**
	 * 
	 * 
	 * 
	 * 
	 */
	public void unsetComment() {
		this.comment = "";
	}

	/**
	 * 
	 * 
	 * 
	 * 
	 */
	public void unsetEvent() {
		if (this.event == null)
			return;
		Event oldevent = this.event;
		this.event = null;
		oldevent.removeComment(this);
	}

	public void unsetUser() {
		if (this.user == null)
			return;
		User olduser = this.user;
		this.user = null;
		olduser.removeComment(this);
	}

}
