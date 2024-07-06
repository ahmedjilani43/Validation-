package com.esprit.microservices.eventsplanner.services;

import Listener.EventRequestMessage;
import com.esprit.microservices.eventsplanner.entities.Event;
import com.esprit.microservices.eventsplanner.interfaces.IEventService;
import com.esprit.microservices.eventsplanner.repositories.EventRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class EventServiceImpl implements IEventService {

    @Autowired
    EventRepository eventRepository;


    @RabbitListener(queues = "reservation-queue")
    public void receiveMessage(EventRequestMessage eventRequestMessage) {
        log.info("Recieved");
        log.info("" + eventRequestMessage.getEventId());
        Event event = eventRepository.findById(Math.toIntExact(eventRequestMessage.getEventId())).get();
        log.info(event.getStatus());
       event.setNumberOfAttendees(event.getNumberOfAttendees() + eventRequestMessage.getGuestNumbers());
     eventRepository.save(event);
//        System.out.println("Received message: " + eventRequestMessage);
//        // Add your logic to handle the eventRequestMessage
    }

    @Bean
    public Jackson2JsonMessageConverter converter() {
        return new Jackson2JsonMessageConverter();
    }

    @Override
    public List<Event> retrieveAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    public Event addEvent(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public Event updateEvent(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public Optional<Event> retrieveEvent(Integer idEvent) {
        return eventRepository.findById(idEvent);
    }

    @Override
    public void removeEvent(Integer idEvent) {
        eventRepository.deleteById(idEvent);
    }

    @Override
    public List<Event> retrieveEventsByTitle(String title) {
        return eventRepository.findByTitle(title);
    }

    @Override
    public List<Event> retrieveEventsByStatus(String status) {
        return eventRepository.findByStatus(status);
    }

    @Override
    public List<Event> retrieveEventsByDate(LocalDate date) {
        return eventRepository.findByStartDate(date);
    }

    @Override
    public List<Event> retrieveEventsByType(String type) {
        return eventRepository.findByType(type);
    }

    @Override
    public List<Event> retrieveEventsByLocation(String location) {
        return eventRepository.findByLocation(location);
    }

    @Override
    public List<Event> retrieveEventsBetweenTwoDates(LocalDate startDate, LocalDate endDate) {
        return eventRepository.getEventBetweenTwoDates(startDate, endDate);
    }

    @Override
    public List<Event> retrieveEventsByNumberOfAttendees(Integer numberOfAttendeesCount) {
        return eventRepository.findByNumberOfAttendees(numberOfAttendeesCount);
    }


}
