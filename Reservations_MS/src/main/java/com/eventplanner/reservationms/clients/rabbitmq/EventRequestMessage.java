package com.eventplanner.reservationms.clients.rabbitmq;


import lombok.*;

import java.io.Serializable;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EventRequestMessage implements Serializable {
  private static final long serialVersionUID = 2322432303657657201L;
  private  Long eventId;
  private  Integer guestNumbers;
}
