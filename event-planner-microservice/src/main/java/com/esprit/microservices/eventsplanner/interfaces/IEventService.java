package com.esprit.microservices.eventsplanner.interfaces;

import com.esprit.microservices.eventsplanner.entities.Event;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface IEventService {

    public List<Event> retrieveAllEvents();

    public  Event addEvent (Event event);

    public  Event updateEvent (Event event);

    public Optional<Event> retrieveEvent (Integer idEvent);

    public  void removeEvent(Integer idEvent);

    public List<Event> retrieveEventsByTitle(String title);

    public List<Event> retrieveEventsByStatus(String status);

    public List<Event> retrieveEventsByDate(LocalDate date);

    public List<Event> retrieveEventsByType(String type);

    public List<Event> retrieveEventsByLocation(String location);
    public List<Event> retrieveEventsBetweenTwoDates(LocalDate startDate, LocalDate endDate);

    public List<Event> retrieveEventsByNumberOfAttendees(Integer numberOfAttendeesCount);

}
