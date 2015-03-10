package fr.istic.taaproject.model;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity 
public class Event implements Serializable
{

	@Override
	public String toString() {
		return "Event [idEvent=" + idEvent + ", adresse=" + adresse + ", name="
				+ name + ", date=" + date + "]";
	}


	public Event(String adresse, String name, Date date) {
		super();
		this.adresse = adresse;
		this.name = name;
		this.date = date;
	}


	private static final long serialVersionUID = 1L;

	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(nullable = false)
	private long idEvent;

	private String adresse;

	private String name;


	 
	@Temporal(TemporalType.DATE) 
	private Date date;

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

