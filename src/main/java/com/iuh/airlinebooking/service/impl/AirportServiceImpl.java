package com.iuh.airlinebooking.service.impl;

import com.iuh.airlinebooking.domain.Airport;
import com.iuh.airlinebooking.domain.City;
import com.iuh.airlinebooking.repository.AirportRepository;
import com.iuh.airlinebooking.repository.CityRepository;
import com.iuh.airlinebooking.service.AirportService;
import com.iuh.airlinebooking.service.dto.AirportDto;
import com.iuh.airlinebooking.service.mapper.AirportMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class AirportServiceImpl implements AirportService {

    @Autowired
    private AirportRepository airportRepository;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private AirportMapper airportMapper;

    @Override
    public List<AirportDto> getAllAirport() {
        List<Airport> airports = airportRepository.findAll();

        List<String> cityIds = airports.stream().map(airport -> airport.getCity().getId()).distinct().collect(Collectors.toList());
        List<City> cities = cityRepository.findAllByIdIn(cityIds);
        Map<String, City> cityMap = cities.stream().collect(Collectors.toMap(City::getId, Function.identity()));

        List<AirportDto> airportDtos = airportMapper.toDto(airports);
        airportDtos.forEach(airportDto -> airportDto.setCityName(cityMap.get(airportDto.getCityId()).getCityName()));

        return airportDtos;
    }
}
