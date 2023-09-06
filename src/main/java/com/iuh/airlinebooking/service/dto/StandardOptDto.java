package com.iuh.airlinebooking.service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StandardOptDto {

    private List<ServiceOptDto> standardBaggageOptions;

    private List<ServiceOptDto> standardMealOptions;

    public StandardOptDto setStandardBaggageOptions(List<ServiceOptDto> baggageOptions) {
        this.standardBaggageOptions = baggageOptions;
        return this;
    }

    public StandardOptDto setStandardMealOptions(List<ServiceOptDto> standardMealOptions) {
        this.standardMealOptions = standardMealOptions;
        return this;
    }
}
