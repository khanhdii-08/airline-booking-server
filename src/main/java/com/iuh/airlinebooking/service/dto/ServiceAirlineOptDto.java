package com.iuh.airlinebooking.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class ServiceAirlineOptDto {

    private StandardOptDto standardOptDto;

    private List<ServiceOptDto> baggageOptions;

    private List<ServiceOptDto> mealOptions;

    public ServiceAirlineOptDto setStandardOptDto(StandardOptDto standardOptDto) {
        this.standardOptDto = standardOptDto;
        return this;
    }

    public ServiceAirlineOptDto setBaggageOptions(List<ServiceOptDto> baggageOptions) {
        this.baggageOptions = baggageOptions;
        return this;
    }

    public ServiceAirlineOptDto setMealOptions(List<ServiceOptDto> mealOptions) {
        this.mealOptions = mealOptions;
        return this;
    }
}
