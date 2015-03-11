package fr.istic.taaproject.model;

import java.io.Serializable;


public class InfoPK implements Serializable {
	private static final long serialVersionUID = 1L;

	long idUser;

	long idEvent;

	
	public InfoPK(long idUser, long idEvent) {
		this.idUser = idUser;
		this.idEvent = idEvent;
	}
	public InfoPK() {
		// TODO Auto-generated constructor stub
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
		InfoPK other = (InfoPK) obj;
		if (idEvent != other.idEvent)
			return false;
		if (idUser != other.idUser)
			return false;
		return true;
	}
	

}
