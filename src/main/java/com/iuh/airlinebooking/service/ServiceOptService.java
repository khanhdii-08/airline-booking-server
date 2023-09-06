package com.iuh.airlinebooking.service;

import com.iuh.airlinebooking.service.criteria.ServiceOptCriteria;
import com.iuh.airlinebooking.service.dto.ServiceAirlineOptDto;

public interface ServiceOptService {
    ServiceAirlineOptDto getServiceAirlineOptDto(ServiceOptCriteria criteria);
}
