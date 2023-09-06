package com.iuh.airlinebooking.service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServiceOptDto {

    private String id;

    private String optionCode;

    private String optionName;

    private String optionDescription;

    private Double value;

    private String luggageType;

    private Double optionPrice;

    private String optionImage;

    private String optionType;

    private String seatClass;

    private String status;

    private String airlineId;

    public void setId(String id) {
        this.id = id;
    }

    public ServiceOptDto setOptionCode(String optionCode) {
        this.optionCode = optionCode;
        return this;
    }

    public ServiceOptDto setOptionName(String optionName) {
        this.optionName = optionName;
        return this;
    }

    public ServiceOptDto setOptionDescription(String optionDescription) {
        this.optionDescription = optionDescription;
        return this;
    }

    public ServiceOptDto setValue(Double value) {
        this.value = value;
        return this;
    }

    public ServiceOptDto setLuggageType(String luggageType) {
        this.luggageType = luggageType;
        return this;
    }

    public ServiceOptDto setOptionPrice(Double optionPrice) {
        this.optionPrice = optionPrice;
        return this;
    }

    public ServiceOptDto setOptionImage(String optionImage) {
        this.optionImage = optionImage;
        return this;
    }

    public ServiceOptDto setOptionType(String optionType) {
        this.optionType = optionType;
        return this;
    }

    public ServiceOptDto setSeatClass(String seatClass) {
        this.seatClass = seatClass;
        return this;
    }

    public ServiceOptDto setStatus(String status) {
        this.status = status;
        return this;
    }

    public ServiceOptDto setAirlineId(String airlineId) {
        this.airlineId = airlineId;
        return this;
    }
}
