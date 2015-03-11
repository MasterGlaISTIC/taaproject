package fr.istic.taaproject.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(InfoPK.class)
public class Participation implements Serializable {

	private static final long serialVersionUID = 7400709297340150637L;

	@Id
	long idUser;

	@Id
	long idEvent;

	// @EmbeddedId
	// protected InfoPK infoPK;

	public Participation() {
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idEvent ^ (idEvent >>> 32));
		result = prime * result + (int) (idUser ^ (idUser >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Participation other = (Participation) obj;
		if (idEvent != other.idEvent)
			return false;
		if (idUser != other.idUser)
			return false;
		return true;
	}

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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Participation(long idUser, long idEvent) {
		super();
		this.idUser = idUser;
		this.idEvent = idEvent;
	}
}
