package fr.istic.taaproject.service;

import java.util.List;

import fr.istic.taaproject.model.Event;

public interface IJourneysService {
	public List<Event> journeys();
	public void createEvent(Event event);
}
