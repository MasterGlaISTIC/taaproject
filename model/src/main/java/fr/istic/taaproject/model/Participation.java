package fr.istic.taaproject.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Participation implements Serializable {

	private static final long serialVersionUID = 7400709297340150637L;

//	@EmbeddedId
//	protected InfoPK infoPK;
	
	private long idUser;

	private long idEvent;

	public Participation() {
		super();
	}

	@Id
	@GeneratedValue
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
	
	


//	@Embeddable
//	public class InfoPK implements Serializable {
//		private static final long serialVersionUID = 1L;
//
//		private long idUser;
//
//		private long idEvent;
//
//		public InfoPK() {
//			super();
//		}
//
//		public long getIdUser() {
//			return idUser;
//		}
//
//		public void setIdUser(long idUser) {
//			this.idUser = idUser;
//		}
//
//		public long getIdEvent() {
//			return idEvent;
//		}
//
//		public void setIdEvent(long idEvent) {
//			this.idEvent = idEvent;
//		}
//
//		@Override
//		public int hashCode() {
//			final int prime = 31;
//			int result = 1;
//			result = prime * result + getOuterType().hashCode();
//			result = prime * result + (int) (idEvent ^ (idEvent >>> 32));
//			result = prime * result + (int) (idUser ^ (idUser >>> 32));
//			return result;
//		}
//
//		@Override
//		public boolean equals(Object obj) {
//			if (this == obj)
//				return true;
//			if (obj == null)
//				return false;
//			if (getClass() != obj.getClass())
//				return false;
//			InfoPK other = (InfoPK) obj;
//			if (!getOuterType().equals(other.getOuterType()))
//				return false;
//			if (idEvent != other.idEvent)
//				return false;
//			if (idUser != other.idUser)
//				return false;
//			return true;
//		}
//
//		private Participation getOuterType() {
//			return Participation.this;
//		}
//	}

}
