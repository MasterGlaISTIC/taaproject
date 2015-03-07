package fr.istic.taaproject.genericDAO;

import java.io.Serializable;
import java.util.List;

import fr.istic.taaproject.model.Event;

public interface InterfaceEventDao extends GenericDao<Event, Long>, Serializable{
  List<Event> getAllJourneys();
}
