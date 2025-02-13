package controller;

import jakarta.xml.ws.Endpoint;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import service.AgenceReservationImpl;

@SpringBootApplication
public class WebServiceHotelApplication {
    public static void main(String[] args) {
        // Démarrer Spring Boot
        SpringApplication.run(WebServiceHotelApplication.class, args);

        /*
        // Démarrer le SOAP
        String url = "http://localhost:8082/agencereservation";
        Endpoint.publish(url, new AgenceReservationImpl());
        System.out.println("Service SOAP lancé sur " + url);
        */
    }
}
