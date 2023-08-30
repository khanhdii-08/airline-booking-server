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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "seat")
@Getter
@NoArgsConstructor
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "seats_code")
    private String seatCode;

    @Column(name = "seats_name")
    private String seatName;

    @Column(name = "seat_class")
    @Enumerated(EnumType.STRING)
    private SeatClass seatClass;

    @Column(name = "status")
    private String status;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "seat")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<AircraftSeat> aircraftSeats;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "seat")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<FlightSeatPrice> flightSeatPrices;

    public Seat setId(String id) {
        this.id = id;
        return this;
    }

    public Seat setSeatName(String seatName) {
        this.seatName = seatName;
        return this;
    }

    public Seat setSeatsCode(String seatCode) {
        this.seatCode = seatCode;
        return this;
    }

    public Seat setSeatClass(SeatClass seatClass) {
        this.seatClass = seatClass;
        return this;
    }

    public Seat setStatus(String status) {
        this.status = status;
        return this;
    }
}
