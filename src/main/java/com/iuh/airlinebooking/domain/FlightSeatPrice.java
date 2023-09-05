package com.iuh.airlinebooking.domain;

import com.iuh.airlinebooking.enumtype.SeatClass;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Getter
@Table(name = "flight_seat_price")
@NoArgsConstructor
public class FlightSeatPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "adult_price")
    private Double adultsPrice;

    @Column(name = "children_price")
    private Double childrenPrice;

    @Column(name = "infant_price")
    private Double infantPrice;

    @Column(name = "seat_class")
    @Enumerated(EnumType.STRING)
    private SeatClass seatClass;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "flight_id", nullable = false)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Flight flight;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seat_id", nullable = false)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Seat seat;

    public FlightSeatPrice setId(String id) {
        this.id = id;
        return this;
    }

    public FlightSeatPrice setAdultsPrice(Double adultsPrice) {
        this.adultsPrice = adultsPrice;
        return this;
    }

    public FlightSeatPrice setChildrenPrice(Double childrenPrice) {
        this.childrenPrice = childrenPrice;
        return this;
    }

    public FlightSeatPrice setInfantPrice(Double infantPrice) {
        this.infantPrice = infantPrice;
        return this;
    }

    public FlightSeatPrice setSeatClass(SeatClass seatClass) {
        this.seatClass = seatClass;
        return this;
    }

    public FlightSeatPrice setFlight(Flight flight) {
        this.flight = flight;
        return this;
    }

    public FlightSeatPrice setSeat(Seat seat) {
        this.seat = seat;
        return this;
    }
}
