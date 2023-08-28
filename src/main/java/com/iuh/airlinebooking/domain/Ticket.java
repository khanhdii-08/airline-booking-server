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
@Table(name = "ticket")
@Getter
@NoArgsConstructor
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "ticket_code")
    private String ticketCode;

    @Column(name = "ticket_name")
    private String ticketName;

    @Column(name = "definition")
    private String definition;

    @Column(name = "seat_class")
    @Enumerated(EnumType.STRING)
    private SeatClass seatClass;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "ticket")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<AirlineTicket> airlineTickets;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "ticket")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<FlightTicket> flightTickets;

    public Ticket setId(String id) {
        this.id = id;
        return this;
    }

    public Ticket setTicketCode(String ticketCode) {
        this.ticketCode = ticketCode;
        return this;
    }

    public Ticket setTicketName(String ticketName) {
        this.ticketName = ticketName;
        return this;
    }

    public Ticket setDefinition(String definition) {
        this.definition = definition;
        return this;
    }

    public Ticket setSeatClass(SeatClass seatClass) {
        this.seatClass = seatClass;
        return this;
    }

    public Ticket setAirlineTickets(List<AirlineTicket> airlineTickets) {
        this.airlineTickets = airlineTickets;
        return this;
    }

    public Ticket setFlightTickets(List<FlightTicket> flightTickets) {
        this.flightTickets = flightTickets;
        return this;
    }
}
