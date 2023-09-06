package com.iuh.airlinebooking.service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FlightDto {

    private String id;

    private String flightCode;

    private String flightName;

    private LocalDateTime departureTime;

    private LocalDateTime arrivalTime;

    private String airlineId;

    private String airlineCode;

    private String airlineName;

    private String airlineAvatarUrl;

    private String aircraftId;

    private String aircraftCode;

    private String aircraftName;

    private String sourceAirportId;

    private String sourceAirportCode;

    private String sourceAirportName;

    private String sourceCityId;

    private String sourceCityCode;

    private String sourceCityName;

    private String destinationAirportId;

    private String destinationAirportCode;

    private String destinationAirportName;

    private String destinationCityId;

    private String destinationCityCode;

    private String destinationCityName;

    private FlightSeatPriceDto seatPriceDto;

    private String status;

    public FlightDto setId(String id) {
        this.id = id;
        return this;
    }

    public FlightDto setFlightCode(String flightCode) {
        this.flightCode = flightCode;
        return this;
    }

    public FlightDto setFlightName(String flightName) {
        this.flightName = flightName;
        return this;
    }

    public FlightDto setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
        return this;
    }

    public FlightDto setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
        return this;
    }

    public FlightDto setAirlineId(String airlineId) {
        this.airlineId = airlineId;
        return this;
    }

    public FlightDto setAircraftId(String aircraftId) {
        this.aircraftId = aircraftId;
        return this;
    }

    public FlightDto setSourceAirportId(String sourceAirportId) {
        this.sourceAirportId = sourceAirportId;
        return this;
    }

    public FlightDto setDestinationAirportId(String destinationAirportId) {
        this.destinationAirportId = destinationAirportId;
        return this;
    }

    public FlightDto setStatus(String status) {
        this.status = status;
        return this;
    }

    public FlightDto setAirlineCode(String airlineCode) {
        this.airlineCode = airlineCode;
        return this;
    }

    public FlightDto setAirlineName(String airlineName) {
        this.airlineName = airlineName;
        return this;
    }

    public FlightDto setAirlineAvatarUrl(String airlineAvatarUrl) {
        this.airlineAvatarUrl = airlineAvatarUrl;
        return this;
    }

    public FlightDto setAircraftCode(String aircraftCode) {
        this.aircraftCode = aircraftCode;
        return this;
    }

    public FlightDto setAircraftName(String aircraftName) {
        this.aircraftName = aircraftName;
        return this;
    }

    public FlightDto setSourceAirportCode(String sourceAirportCode) {
        this.sourceAirportCode = sourceAirportCode;
        return this;
    }

    public FlightDto setSourceAirportName(String sourceAirportName) {
        this.sourceAirportName = sourceAirportName;
        return this;
    }

    public FlightDto setDestinationAirportCode(String destinationAirportCode) {
        this.destinationAirportCode = destinationAirportCode;
        return this;
    }

    public FlightDto setDestinationAirportName(String destinationAirportName) {
        this.destinationAirportName = destinationAirportName;
        return this;
    }

    public FlightDto setSeatPriceDto(FlightSeatPriceDto seatPriceDto) {
        this.seatPriceDto = seatPriceDto;
        return this;
    }

    public FlightDto setSourceCityId(String sourceCityId) {
        this.sourceCityId = sourceCityId;
        return this;
    }

    public FlightDto setSourceCityCode(String sourceCityCode) {
        this.sourceCityCode = sourceCityCode;
        return this;
    }

    public FlightDto setSourceCityName(String sourceCityName) {
        this.sourceCityName = sourceCityName;
        return this;
    }

    public FlightDto setDestinationCityId(String destinationCityId) {
        this.destinationCityId = destinationCityId;
        return this;
    }

    public FlightDto setDestinationCityCode(String destinationCityCode) {
        this.destinationCityCode = destinationCityCode;
        return this;
    }

    public FlightDto setDestinationCityName(String destinationCityName) {
        this.destinationCityName = destinationCityName;
        return this;
    }
}
