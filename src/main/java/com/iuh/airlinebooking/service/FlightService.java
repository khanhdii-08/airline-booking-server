package com.iuh.airlinebooking.service;

import com.iuh.airlinebooking.service.criteria.FlightCriteria;
import com.iuh.airlinebooking.service.dto.FlightDto;

import java.util.List;

public interface FlightService {
    List<FlightDto> getListByCondition(FlightCriteria criteria);
}
