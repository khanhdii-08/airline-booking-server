package com.iuh.airlinebooking.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "airline_airport")
@Getter
@NoArgsConstructor
public class AirlineAirport {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "airline_id", nullable = false)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Airline airline;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "airport_id", nullable = false)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Airport airport;

    public AirlineAirport setId(String id) {
        this.id = id;
        return this;
    }

    public AirlineAirport setAirline(Airline airline) {
        this.airline = airline;
        return this;
    }

    public AirlineAirport setAirport(Airport airport) {
        this.airport = airport;
        return this;
    }
}
