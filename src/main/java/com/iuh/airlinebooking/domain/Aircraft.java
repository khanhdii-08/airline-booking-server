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

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "aircraft")
@Getter
@NoArgsConstructor
public class Aircraft {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "aircraft_code")
    private String aircraftCode;

    @Column(name = "aircraft_name")
    private String aircraftName;

    @Column(name = "capacity ")
    private String capacity;

    @Column(name = "row_numbers")
    private Integer rowNumbers;

    @Column(name = "column_numbers")
    private Integer columnNumbers;

    @ManyToOne
    @JoinColumn(columnDefinition = "airline_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Airline airline;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "aircraft")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<Seat> seats;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "aircraft")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<Flight> flights;

    public Aircraft setId(String id) {
        this.id = id;
        return this;
    }

    public Aircraft setAircraftCode(String aircraftCode) {
        this.aircraftCode = aircraftCode;
        return this;
    }

    public Aircraft setAircraftName(String aircraftName) {
        this.aircraftName = aircraftName;
        return this;
    }

    public Aircraft setCapacity(String capacity) {
        this.capacity = capacity;
        return this;
    }

    public Aircraft setRowNumbers(Integer rowNumbers) {
        this.rowNumbers = rowNumbers;
        return this;
    }

    public Aircraft setColumnNumbers(Integer columnNumbers) {
        this.columnNumbers = columnNumbers;
        return this;
    }

    public Aircraft setAirline(Airline airline) {
        this.airline = airline;
        return this;
    }

    public Aircraft setSeats(Set<Seat> seats) {
        this.seats = seats;
        return this;
    }

    public Aircraft setFlights(List<Flight> flights) {
        this.flights = flights;
        return this;
    }
}
