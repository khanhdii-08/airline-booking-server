package com.iuh.airlinebooking.service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class FlightSeatPriceDto {
    private String id;

    private Double adultsPrice;

    private Double childrenPrice;

    private Double infantPrice;

    private String seatClass;

    private String flightId;

    private String seatId;

    public FlightSeatPriceDto setId(String id) {
        this.id = id;
        return this;
    }

    public FlightSeatPriceDto setAdultsPrice(Double adultsPrice) {
        this.adultsPrice = adultsPrice;
        return this;
    }

    public FlightSeatPriceDto setChildrenPrice(Double childrenPrice) {
        this.childrenPrice = childrenPrice;
        return this;
    }

    public FlightSeatPriceDto setInfantPrice(Double infantPrice) {
        this.infantPrice = infantPrice;
        return this;
    }

    public FlightSeatPriceDto setSeatClass(String seatClass) {
        this.seatClass = seatClass;
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
