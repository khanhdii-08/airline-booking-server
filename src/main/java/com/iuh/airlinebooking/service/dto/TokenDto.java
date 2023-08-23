package com.iuh.airlinebooking.service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
public class TokenDto {
    private String access_token;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String refresh_token;
}
