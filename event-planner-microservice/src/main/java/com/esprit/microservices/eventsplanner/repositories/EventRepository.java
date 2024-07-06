package com.esprit.microservices.eventsplanner.repositories;

import com.esprit.microservices.eventsplanner.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {
    List<Event> findByTitle(String title);

    List<Event> findByLocation(String location);
    List<Event> findByType(String type);
    List<Event> findByStatus(String status);

    List<Event> findByNumberOfAttendees(Integer numberOfAttendees);
    List<Event> findByStartDate(LocalDate localDate);

    @Query("SELECT event FROM Event event where ((event.startDate BETWEEN :sDate AND :eDate)) and (event.endDate BETWEEN :sDate AND :eDate)")
    public List<Event> getEventBetweenTwoDates(@Param("sDate") LocalDate startDate, @Param("eDate") LocalDate endDate);


}
