package com.example.airline_api.models;

public class BookingDTO {

    private long flightId;

    private long passengerId;

    public BookingDTO(long flightId, long passengerId){
        this.flightId = flightId;
        this.passengerId = passengerId;
    }
    
    public BookingDTO(){
        
    }

    public long getFlightId() {
        return flightId;
    }

    public void setFlightId(long flightId) {
        this.flightId = flightId;
    }

    public long getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(long passengerId) {
        this.passengerId = passengerId;
    }
}
