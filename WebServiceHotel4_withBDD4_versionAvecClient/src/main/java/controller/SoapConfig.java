
package controller;

import jakarta.xml.ws.Endpoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import service.AgenceReservationImpl;

@Configuration
public class SoapConfig {

    @Bean
    public Endpoint soapEndpoint() {
        String url = "http://localhost:8082/agencereservation";
        Endpoint endpoint = Endpoint.create(new AgenceReservationImpl());
        endpoint.publish(url);
        System.out.println("Service SOAP lancé sur " + url);
        return endpoint;
    }
}
