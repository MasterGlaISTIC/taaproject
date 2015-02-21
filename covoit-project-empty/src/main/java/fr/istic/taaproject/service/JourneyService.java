package fr.istic.taaproject.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;

import fr.istic.taaproject.genericDAO.EventDAO;
import fr.istic.taaproject.genericDAO.InterfaceEventDao;
import fr.istic.taaproject.model.Event;

@Path("/journey")
@Produces({ MediaType.APPLICATION_JSON })
@Provider
public class JourneyService implements IJourneysService{

	
	InterfaceEventDao eventDao = new EventDAO();
	
	@Override
	@GET
	@Path("/journeys")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Event> journeys() {
		return eventDao.getAllJourneys();
	}

	public InterfaceEventDao getEventDao() {
		return eventDao;
	}

	public void setEventDao(InterfaceEventDao eventDao) {
		this.eventDao = eventDao;
	}
	
}
