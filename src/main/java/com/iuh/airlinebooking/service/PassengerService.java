package com.iuh.airlinebooking.service;

import com.iuh.airlinebooking.service.dto.PassengerDto;
import com.iuh.airlinebooking.service.dto.TokenDto;
import jakarta.servlet.http.HttpServletRequest;

public interface PassengerService {
    TokenDto create (PassengerDto passengerDto, HttpServletRequest request);
}
