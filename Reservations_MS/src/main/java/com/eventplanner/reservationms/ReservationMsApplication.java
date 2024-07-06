package com.eventplanner.reservationms;

import org.modelmapper.ModelMapper;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ReservationMsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReservationMsApplication.class, args);
    }
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    Queue queue() {
        return new Queue("reservation-queue");
    }
    @Bean
    DirectExchange exchange() {
        return new DirectExchange("reservation-exchange");
    }

    @Bean
    Binding binding(DirectExchange exchange,Queue queue) {
        return BindingBuilder.bind(queue).to(exchange).with("reservation-routing");
    }

    @Bean
    public Jackson2JsonMessageConverter converter() {
        return new Jackson2JsonMessageConverter();
    }
    @Bean
    public MappingJackson2MessageConverter jackson2Converter() {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        return converter;
    }


}
