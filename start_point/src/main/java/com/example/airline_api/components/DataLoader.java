package com.example.airline_api.components;

import com.example.airline_api.models.Passenger;
import com.example.airline_api.services.FlightService;
import com.example.airline_api.services.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    FlightService flightService;

    @Autowired
    PassengerService passengerService;

}
