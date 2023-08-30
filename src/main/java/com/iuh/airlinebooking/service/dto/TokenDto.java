package com.iuh.airlinebooking.service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TokenDto {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("access_token")
    private String accessToken;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("refresh_token")
    private String refreshToken;

    public TokenDto setAccessToken(String access_token) {
        this.accessToken = access_token;
        return this;
    }

    public TokenDto setRefreshToken(String refresh_token) {
        this.refreshToken = refresh_token;
        return this;
    }
}
