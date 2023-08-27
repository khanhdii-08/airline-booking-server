package com.iuh.airlinebooking.service;

import jakarta.servlet.http.HttpServletRequest;

public interface BaseService {

    String getMessageCode(String code, HttpServletRequest request);

    String getPlatform(HttpServletRequest request);
    String getUserId(HttpServletRequest request);

    String generateRandomColor();

}
