package com.example.airline_api.controllers;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.services.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/passengers")
public class PassengerController {

    @Autowired
    PassengerService passengerService;

    // TODO: Display details of all passengers
    @GetMapping
    public ResponseEntity<List<Passenger>> getAllPassengers(){
        return new ResponseEntity<>(passengerService.getAllPassengers(), HttpStatus.OK);
    }

    // TODO: Display specific passenger details
    @GetMapping(value = "/{id}")
    public ResponseEntity<Passenger> getFlightById(@PathVariable Long id){
        Optional<Passenger> passenger = passengerService.findSinglePassenger(id);
        if (passenger.isPresent()){
            return new ResponseEntity<>(passenger.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    // TODO: Add a new passenger
    @PostMapping
    public ResponseEntity<List<Passenger>> addNewPassenger(@RequestBody Passenger passenger){
        passengerService.savePassenger(passenger);
        return new ResponseEntity<>(passengerService.getAllPassengers(), HttpStatus.CREATED);
    }

}
