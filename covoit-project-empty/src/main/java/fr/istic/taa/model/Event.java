package fr.istic.taa.model;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * 
 * 
 * 
 */
 
@Entity 
public class Event implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * 
	 * 
	 * 
	 */
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(nullable = false)
	private long idEvent;

	/**
	 * 
	 * 
	 * 
	 * 
	 */
	 
	 
	private String adresse;

	/**
	 * 
	 * 
	 * 
	 * 
	 */
	 
	 
	private String name;

	/**
	 * 
	 * 
	 * 
	 * 
	 */
	 
	@Temporal(TemporalType.DATE) 
	 
	private Date date;

	/**
	 * 
	 * 
	 * 
	 * 
	 */
	 
	private User createur;

	/**
	 * 
	 * 
	 * 
	 * 
	 */
	 
	@OneToMany(mappedBy = "event") 
	private Set<Comment> comment;

	public Event(){
		super();
	}

	
	public long getIdEvent() {
		return this.idEvent;	
	}
	
	/**
	 * 
	 * 
	 * 
	 * 
	 */
	public String getAdresse() {
		return this.adresse;	
	}
	
	/**
	 * 
	 * 
	 * 
	 * 
	 */
	public String getName() {
		return this.name;	
	}
	
	/**
	 * 
	 * 
	 * 
	 * 
	 */
	public Date getDate() {
		return this.date;	
	}
	
	/**
	 * 
	 * 
	 * 
	 * 
	 */
//	public Set<User> getCreateur() {
//		if(this.createur == null) {
//				this.createur = new HashSet<User>();
//		}
//		return (Set<User>) this.createur;	
//	}
	
	/**
	 * 
	 * 
	 * 
	 * 
	 */
	public Set<Comment> getComment() {
		if(this.comment == null) {
				this.comment = new HashSet<Comment>();
		}
		return (Set<Comment>) this.comment;	
	}
	

//	public void addAllCreateur(Set<User> newCreateur) {
//		if (this.createur == null) {
//			this.createur = new HashSet<User>();
//		}
//		for (User tmp : newCreateur)
//			tmp.setEvent(this);
//			
//	}
	
	/**
	 * 
	 * 
	 * 
	 * 
	 */
	public void addAllComment(Set<Comment> newComment) {
		if (this.comment == null) {
			this.comment = new HashSet<Comment>();
		}
		for (Comment tmp : newComment)
			tmp.setEvent(this);
			
	}
	
	/**
	 * 
	 * 
	 * 
	 * 
	 */
//	public void removeAllCreateur(Set<User> newCreateur) {
//		if(this.createur == null) {
//			return;
//		}
//		
//		this.createur.removeAll(newCreateur);	
//	}
	
	/**
	 * 
	 * 
	 * 
	 * 
	 */
	public void removeAllComment(Set<Comment> newComment) {
		if(this.comment == null) {
			return;
		}
		
		this.comment.removeAll(newComment);	
	}
	
	/**
	 * 
	 * 
	 * 
	 * 
	 */
	public void setIdEvent(long myIdEvent) {
		this.idEvent = myIdEvent;	
	}
	
	/**
	 * 
	 * 
	 * 
	 * 
	 */
	public void setAdresse(String myAdresse) {
		this.adresse = myAdresse;	
	}
	
	/**
	 * 
	 * 
	 * 
	 * 
	 */
	public void setName(String myName) {
		this.name = myName;	
	}
	
	/**
	 * 
	 * 
	 * 
	 * 
	 */
	public void setDate(Date myDate) {
		this.date = myDate;	
	}
	
	/**
	 * 
	 * 
	 * 
	 * 
	 */
//	public void addCreateur(User newCreateur) {
//		if(this.createur == null) {
//			this.createur = new HashSet<User>();
//		}
//		
//		if (this.createur.add(newCreateur))
//			newCreateur.basicSetEvent(this);	
//	}
	
	public User getCreateur() {
		return createur;
	}


	public void setCreateur(User createur) {
		this.createur = createur;
	}


	/**
	 * 
	 * 
	 * 
	 * 
	 */
	public void addComment(Comment newComment) {
		if(this.comment == null) {
			this.comment = new HashSet<Comment>();
		}
		
		if (this.comment.add(newComment))
			newComment.basicSetEvent(this);	
	}
	
	/**
	 * 
	 * 
	 * 
	 * 
	 */
public void unsetIdEvent() {
		this.idEvent = 0L;	
	}
	
	/**
	 * 
	 * 
	 * 
	 * 
	 */
	public void unsetAdresse() {
		this.adresse = "";	
	}
	
	/**
	 * 
	 * 
	 * 
	 * 
	 */
	public void unsetName() {
		this.name = "";	
	}
	
	/**
	 * 
	 * 
	 * 
	 * 
	 */
	public void unsetDate() {
		this.date = new Date();	
	}
	
	/**
	 * 
	 * 
	 * 
	 * 
	 */
//	public void removeCreateur(User oldCreateur) {
//		if(this.createur == null)
//			return;
//		
//		if (this.createur.remove(oldCreateur))
//			oldCreateur.unsetEvent();
//			
//	}
	
	/**
	 * 
	 * 
	 * 
	 * 
	 */
	public void removeComment(Comment oldComment) {
		if(this.comment == null)
			return;
		
		if (this.comment.remove(oldComment))
			oldComment.unsetEvent();
			
	}
	

}

