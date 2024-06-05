package com.example.airline_api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "passengers")
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email_address")
    private String email;

    @OneToMany(mappedBy = "passenger")
    @JsonIgnoreProperties({"passenger"})
    private List<Booking> flights;

    public Passenger(String name, String email) {
        this.name = name;
        this.email = email;
        this.flights = new ArrayList<>();
    }

    public Passenger() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Booking> getFlights() {
        return flights;
    }

    public void setFlights(List<Booking> flights) {
        this.flights = flights;
    }
}
