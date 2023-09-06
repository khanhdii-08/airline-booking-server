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
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "flight")
@Getter
@NoArgsConstructor
public class Flight extends AbstractAuditingEntity<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "flight_code")
    private String flightCode;

    @Column(name = "flight_name")
    private String flightName;

    @Column(name = "departure_time")
    private LocalDateTime departureTime;

    @Column(name = "arrival_time")
    private LocalDateTime arrivalTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "airline_id", nullable=false)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Airline airline;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "aircraft_id", nullable=false)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Aircraft aircraft;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "source_airport_id", nullable=false)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Airport sourceAirport;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "destination_airport_id", nullable=false)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Airport destinationAirport;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "flight")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<FlightSeatPrice> flightSeatPrices;

    @Column(name = "status")
    private String status;

    public Flight setId(String id) {
        this.id = id;
        return this;
    }

    public Flight setFlightCode(String flightCode) {
        this.flightCode = flightCode;
        return this;
    }

    public Flight setFlightName(String flightName) {
        this.flightName = flightName;
        return this;
    }

    public Flight setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
        return this;
    }

    public Flight setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
        return this;
    }

    public Flight setAirline(Airline airline) {
        this.airline = airline;
        return this;
    }

    public Flight setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
        return this;
    }

    public Flight setSourceAirport(Airport sourceAirport) {
        this.sourceAirport = sourceAirport;
        return this;
    }

    public Flight setDestinationAirport(Airport destinationAirport) {
        this.destinationAirport = destinationAirport;
        return this;
    }

    public Flight setStatus(String status) {
        this.status = status;
        return this;
    }
}
