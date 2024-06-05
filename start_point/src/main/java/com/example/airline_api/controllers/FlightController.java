package com.example.airline_api.controllers;

import com.example.airline_api.models.Flight;
import com.example.airline_api.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    FlightService flightService;

    // TODO: Display all available flights
    @GetMapping
    public ResponseEntity<List<Flight>> getAllFlights(){
        return new ResponseEntity<>(flightService.getAllFlights(), HttpStatus.OK);
    }

    // TODO: Display a specific flight
    @GetMapping(value = "/{id}")
    public ResponseEntity<Flight> getFlightById(@PathVariable Long id){
        Optional<Flight> flight = flightService.findSingleFlight(id);
        if (flight.isPresent()){
            return new ResponseEntity<>(flight.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    // TODO: Add details of a new flight
    @PostMapping
    public ResponseEntity<List<Flight>> addNewFlight(@RequestBody Flight flight){
        flightService.saveFlight(flight);
        return new ResponseEntity<>(flightService.getAllFlights(), HttpStatus.CREATED);
    }

    // TODO: Extension - Cancel flight
    @DeleteMapping(value = "/{id}")
    public ResponseEntity cancelFlight(){
        return null;
    }

}
