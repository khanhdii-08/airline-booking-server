package com.iuh.airlinebooking.service.dto;

import lombok.Getter;

@Getter
public class AirportDto {
    private String id;
    private String cityId;
    private String cityName;
    private String airportCode;
    private String airportName;

    public AirportDto setId(String id) {
        this.id = id;
        return this;
    }

    public AirportDto setCityId(String cityId) {
        this.cityId = cityId;
        return this;
    }

    public AirportDto setCityName(String cityName) {
        this.cityName = cityName;
        return this;
    }

    public AirportDto setAirportCode(String airportCode) {
        this.airportCode = airportCode;
        return this;
    }

    public AirportDto setAirportName(String airportName) {
        this.airportName = airportName;
        return this;
    }
}
