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

@Entity
@Table(name = "seat")
@Getter
@NoArgsConstructor
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "seats_code")
    private String seatsCode;

    @Column(name = "row_number")
    private Integer rowNumber;

    @Column(name = "column_number")
    private Integer columnNumber;

    @Column(name = "seat_class")
    private String seatClass;

    @Column(name = "status")
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "aircraft_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Aircraft aircraft;

    public Seat setId(String id) {
        this.id = id;
        return this;
    }

    public Seat setSeatsCode(String seatsCode) {
        this.seatsCode = seatsCode;
        return this;
    }

    public Seat setRowNumber(Integer rowNumber) {
        this.rowNumber = rowNumber;
        return this;
    }

    public Seat setColumnNumber(Integer columnNumber) {
        this.columnNumber = columnNumber;
        return this;
    }

    public Seat setSeatClass(String seatClass) {
        this.seatClass = seatClass;
        return this;
    }

    public Seat setStatus(String status) {
        this.status = status;
        return this;
    }

    public Seat setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
        return this;
    }
}
