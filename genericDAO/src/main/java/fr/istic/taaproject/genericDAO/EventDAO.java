package fr.istic.taaproject.genericDAO;

import java.util.List;

import fr.istic.taaproject.model.Event;


public class EventDAO extends GenericDaoImpl<Event, Long> implements InterfaceEventDao{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public List<Event> getAllJourneys() {
		
		return entityManager.createQuery("SELECT p FROM Event p", Event.class).getResultList();
	}

}
