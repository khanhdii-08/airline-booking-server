package com.iuh.airlinebooking.service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class FlightSeatPriceDto {
    private String id;

    private Double price;

    private Double infantPrice;

    private String sateClass;

    private String flightId;

    private String seatId;

    public FlightSeatPriceDto setId(String id) {
        this.id = id;
        return this;
    }

    public FlightSeatPriceDto setPrice(Double price) {
        this.price = price;
        return this;
    }

    public FlightSeatPriceDto setInfantPrice(Double infantPrice) {
        this.infantPrice = infantPrice;
        return this;
    }

    public FlightSeatPriceDto setSateClass(String sateClass) {
        this.sateClass = sateClass;
        return this;
    }

    public FlightSeatPriceDto setFlightId(String flightId) {
        this.flightId = flightId;
        return this;
    }

    public FlightSeatPriceDto setSeatId(String seatId) {
        this.seatId = seatId;
        return this;
    }
}
