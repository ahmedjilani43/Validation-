package com.esprit.microservices.eventsplanner.controllers;

import com.esprit.microservices.eventsplanner.entities.Event;
import com.esprit.microservices.eventsplanner.interfaces.IEventService;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/events")
public class EventControllers {

    IEventService eventService ;

    public EventControllers(IEventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping("/addEvent")
    @ResponseStatus(HttpStatus.CREATED)
    @Consumes(MediaType.APPLICATION_JSON)
    public Event addEvent(@RequestBody Event event) {
        return eventService.addEvent(event);
    }

    @PutMapping("/updateEvent")
    @ResponseStatus(HttpStatus.OK)
    @Produces(MediaType.APPLICATION_JSON)
    public Event updateEvent(@RequestBody Event event) {
        return eventService.updateEvent(event);
    }

    @DeleteMapping("/removeEvent/{idEvent}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeEvent(@PathVariable Integer idEvent) {
        eventService.removeEvent(idEvent);
    }

    @GetMapping("/retrieveEvent/{idEvent}")
    @ResponseStatus(HttpStatus.OK)
    public Integer retrieveEvent(@PathVariable Integer idEvent) {
        return eventService.retrieveEvent(idEvent).get().getNumberOfAttendees();
    }


    @GetMapping("/retrieveEvents")
    @ResponseStatus(HttpStatus.OK)
    public List<Event> retrieveAllEvents() {
        return eventService.retrieveAllEvents();
    }

    @GetMapping("/retrieveEventsByType/{eventType}")
    @ResponseStatus(HttpStatus.OK)
    public List<Event> retrieveEventsByType(@PathVariable String eventType) {
        return eventService.retrieveEventsByType(eventType);
    }

    @GetMapping("/retrieveEventsByLocation/{location}")
    @ResponseStatus(HttpStatus.OK)
    public List<Event> retrieveEventsByLocation(@PathVariable String location) {
        return eventService.retrieveEventsByLocation(location);
    }

    @GetMapping("/retrieveEventsByTitle/{title}")
    @ResponseStatus(HttpStatus.OK)
    public List<Event> retrieveEventsByTitle(@PathVariable String title) {
        return eventService.retrieveEventsByTitle(title);
    }

    @GetMapping("/retrieveEventsByStatus/{status}")
    @ResponseStatus(HttpStatus.OK)
    public List<Event> retrieveEventsByStatus(@PathVariable String status) {
        return eventService.retrieveEventsByStatus(status);
    }

    @GetMapping("/retrieveEventsByNumberOfAttendees/{NumberOfAttendees}")
    @ResponseStatus(HttpStatus.OK)
    public List<Event> retrieveEventsByNumberOfAttendees(@PathVariable Integer NumberOfAttendees) {
        return eventService.retrieveEventsByNumberOfAttendees(NumberOfAttendees);
    }

    @GetMapping("/retrieveEventsByDate/{date}")
    @ResponseStatus(HttpStatus.OK)
    public List<Event> retrieveEventsByDate(@PathVariable(name = "date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return eventService.retrieveEventsByDate(date);
    }

    /** DATE FORMAT : The most common ISO Date Format yyyy-MM-dd — for example, "2000-10-31".**/
    @GetMapping("/retrieveEventsBetweenTwoDates/{startDate}/{endDate}")
    @ResponseStatus(HttpStatus.OK)
    public List<Event> retrieveEventsBetweenTwoDates(
            @PathVariable(name = "startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate startDate,
            @PathVariable(name = "endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate endDate) {
        return eventService.retrieveEventsBetweenTwoDates(startDate, endDate);
    }
}
