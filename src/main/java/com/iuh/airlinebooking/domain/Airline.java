package com.iuh.airlinebooking.domain;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "airline")
@Getter
@NoArgsConstructor
public class Airline {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "airline_code")
    private String airlineCode;

    @Column(name = "airline_name")
    private String airlineName;

    @Column(name = "avater_url")
    private String avatarUrl;

    @OneToMany(mappedBy = "airline", fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<AirlineAirport> airlineAirports;

    @OneToMany(mappedBy = "airline", fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<Aircraft> aircrafts;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "airline")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<Flight> flights;

    public Airline setId(String id) {
        this.id = id;
        return this;
    }

    public Airline setAirlineCode(String airlineCode) {
        this.airlineCode = airlineCode;
        return this;
    }

    public Airline setAirlineName(String airlineName) {
        this.airlineName = airlineName;
        return this;
    }

    public Airline setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
        return this;
    }

    public Airline setAirlineAirports(List<AirlineAirport> airlineAirports) {
        this.airlineAirports = airlineAirports;
        return this;
    }

    public Airline setAircraft(Set<Aircraft> aircrafts) {
        this.aircrafts = aircrafts;
        return this;
    }

    public Airline setFlights(List<Flight> flights) {
        this.flights = flights;
        return this;
    }
}
