package fr.istic.taaproject.model;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity 
public class Event implements Serializable
{

	private static final long serialVersionUID = 1L;

	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(nullable = false)
	private long idEvent;

	private String adresse;

	private String name;


	 
	@Temporal(TemporalType.DATE) 
	private Date date;


	@OneToOne
	private User createur;



	public Event(){
		super();
	}

	
	public long getIdEvent() {
		return this.idEvent;	
	}
	

	public String getAdresse() {
		return this.adresse;	
	}
	
	public String getName() {
		return this.name;	
	}
	

	public Date getDate() {
		return this.date;	
	}
	

	public void setIdEvent(long myIdEvent) {
		this.idEvent = myIdEvent;	
	}
	

	public void setAdresse(String myAdresse) {
		this.adresse = myAdresse;	
	}
	

	public void setName(String myName) {
		this.name = myName;	
	}
	

	public void setDate(Date myDate) {
		this.date = myDate;	
	}
	

	
	public User getCreateur() {
		return createur;
	}


	public void setCreateur(User createur) {
		this.createur = createur;
	}


public void unsetIdEvent() {
		this.idEvent = 0L;	
	}
	

	public void unsetAdresse() {
		this.adresse = "";	
	}


	public void unsetName() {
		this.name = "";	
	}
	

	public void unsetDate() {
		this.date = new Date();	
	}
	

	

}

