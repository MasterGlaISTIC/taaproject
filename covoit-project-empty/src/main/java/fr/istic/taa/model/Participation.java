package fr.istic.taa.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;


@Entity
public class Participation implements Serializable {

	private static final long serialVersionUID = 7400709297340150637L;

	

	@EmbeddedId
	protected InfoPK infoPK;

	public Participation() {
		super();
	}


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
