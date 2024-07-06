package com.esprit.microservices.eventsplanner.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Event implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;
    private String description;
    private String location;
    // @Temporal(TemporalType.DATE)
    private LocalDate startDate;
    // @Temporal(TemporalType.DATE)
    private LocalDate endDate;
    private String organizer;
    private String mailAddressOfOrganizer;
    private Integer numberOfAttendees;
    private String status;
    private String type;
    private String summary;


}
