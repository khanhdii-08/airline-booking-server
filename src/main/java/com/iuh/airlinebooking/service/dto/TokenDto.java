package com.iuh.airlinebooking.service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TokenDto {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String access_token;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String refresh_token;

    public TokenDto setAccessToken(String access_token) {
        this.access_token = access_token;
        return this;
    }

    public TokenDto setRefreshToken(String refresh_token) {
        this.refresh_token = refresh_token;
        return this;
    }
}
