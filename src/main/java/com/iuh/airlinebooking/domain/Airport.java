package com.iuh.airlinebooking.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.Set;

@Getter
@Entity
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "airport_code")
    private String airportCode;

    @Column(name = "airport_name")
    private String airportName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="city_id", nullable=false)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private City city;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "airport")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<AirlineAirport> airlineAirports;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "sourceAirport")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<Flight> sourceFlights;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "destinationAirport")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<Flight> destinationFlights;

    public Airport setId(String id) {
        this.id = id;
        return this;
    }

    public Airport setAirportCode(String airportCode) {
        this.airportCode = airportCode;
        return this;
    }

    public Airport setAirportName(String airportName) {
        this.airportName = airportName;
        return this;
    }

    public Airport setCity(City city) {
        this.city = city;
        return this;
    }

    public Airport setAirlineAirports(List<AirlineAirport> airlineAirports) {
        this.airlineAirports = airlineAirports;
        return this;
    }

    public Airport setSourceFlights(List<Flight> sourceFlights) {
        this.sourceFlights = sourceFlights;
        return this;
    }

    public Airport setDestinationFlights(List<Flight> destinationFlights) {
        this.destinationFlights = destinationFlights;
        return this;
    }
}
