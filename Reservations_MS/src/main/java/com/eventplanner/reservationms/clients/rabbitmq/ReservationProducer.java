package com.eventplanner.reservationms.clients.rabbitmq;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReservationProducer {


   @Autowired
   private RabbitMessagingTemplate rabbitMessagingTemplate;

    @Autowired
    private MappingJackson2MessageConverter mappingJackson2MessageConverter;

    public void  sendMessage(Integer numbersGuest,Long eventId){
       EventRequestMessage eventRequestMessage= new EventRequestMessage();
       eventRequestMessage.setEventId(eventId);
       eventRequestMessage.setGuestNumbers(numbersGuest);
        rabbitMessagingTemplate.convertAndSend("reservation-exchange", "reservation-routing",eventRequestMessage);
    }
}
