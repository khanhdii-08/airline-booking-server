package com.iuh.airlinebooking.service.impl;

import com.iuh.airlinebooking.domain.Aircraft;
import com.iuh.airlinebooking.domain.Airline;
import com.iuh.airlinebooking.domain.Airport;
import com.iuh.airlinebooking.domain.Flight;
import com.iuh.airlinebooking.domain.FlightSeatPrice;
import com.iuh.airlinebooking.enumtype.SeatClass;
import com.iuh.airlinebooking.repository.AircraftRepository;
import com.iuh.airlinebooking.repository.AirlineRepository;
import com.iuh.airlinebooking.repository.AirportRepository;
import com.iuh.airlinebooking.repository.FlightRepository;
import com.iuh.airlinebooking.repository.FlightSeatPriceRepository;
import com.iuh.airlinebooking.service.FlightService;
import com.iuh.airlinebooking.service.criteria.FlightCriteria;
import com.iuh.airlinebooking.service.dto.FlightDto;
import com.iuh.airlinebooking.service.dto.FlightSeatPriceDto;
import com.iuh.airlinebooking.service.mapper.FlightMapper;
import com.iuh.airlinebooking.service.mapper.FlightSeatPriceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class FlightServiceImpl implements FlightService {

    @Autowired
    private FlightRepository flightRepository;
    @Autowired
    private AirlineRepository airlineRepository;
    @Autowired
    private AircraftRepository aircraftRepository;
    @Autowired
    private AirportRepository airportRepository;
    @Autowired
    private FlightSeatPriceRepository flightSeatPriceRepository;
    @Autowired
    private FlightMapper flightMapper;
    @Autowired
    private FlightSeatPriceMapper flightSeatPriceMapper;

    @Override
    public List<FlightDto> getListByCondition(FlightCriteria criteria) {

        List<Flight> flights = flightRepository.findAllByCriteria(criteria.getSourceAirportId(), criteria.getDestinationAirportId(),
                criteria.getDepartureDate(), criteria.getReturnDate(), SeatClass.valueOf(criteria.getSeatClass()));
        List<Airline> airlines = airlineRepository.findAllByFlightsIn(flights);
        Map<String, Airline> airlineMap = airlines.stream().collect(Collectors.toMap(Airline::getId, Function.identity()));
        airlines.clear();
        List<Aircraft> aircrafts = aircraftRepository.findAllByFlightsIn(flights);
        Map<String, Aircraft> aircraftMap = aircrafts.stream().collect(Collectors.toMap(Aircraft::getId, Function.identity()));
        aircrafts.clear();
        List<Airport> sourceAirports = airportRepository.findAllBySourceFlightsIn(flights);
        Map<String, Airport> sourceAirportMap = sourceAirports.stream().collect(Collectors.toMap(Airport::getId, Function.identity()));
        sourceAirports.clear();
        List<Airport> destinationAirports = airportRepository.findAllByDestinationFlightsIn(flights);
        Map<String, Airport> destinationAirportMap = destinationAirports.stream().collect(Collectors.toMap(Airport::getId, Function.identity()));
        destinationAirports.clear();
        List<FlightSeatPrice> flightSeatPrice = flightSeatPriceRepository.findAllByFlightInAndSeatClass(flights, SeatClass.valueOf(criteria.getSeatClass()));
        Map<String, FlightSeatPrice> flightSeatPriceMap = flightSeatPrice.stream().collect(Collectors.toMap(flightSeatPrice1 -> flightSeatPrice1.getFlight().getId(), Function.identity()));

        List<FlightDto> flightDtos = new ArrayList<>();
        flights.forEach(flight -> {
            FlightDto flightDto = flightMapper.toDto(flight);
            Airline airline = airlineMap.get(flight.getAirline().getId());
            Aircraft aircraft = aircraftMap.get(flight.getAircraft().getId());
            Airport sourceAirport = sourceAirportMap.get(flight.getSourceAirport().getId());
            Airport destinationAirport = destinationAirportMap.get(flight.getDestinationAirport().getId());
            FlightSeatPriceDto priceDto = flightSeatPriceMapper.toDto(flightSeatPriceMap.get(flight.getId()));

            flightDto.setAirlineCode(airlineMap.get(flight.getAirline().getId()).getAirlineCode())
                    .setAirlineName(airline.getAirlineName())
                    .setAirlineAvatarUrl(airline.getAvatarUrl())
                    .setAircraftCode(aircraft.getAircraftCode())
                    .setAircraftName(aircraft.getAircraftName())
                    .setSourceAirportCode(sourceAirport.getAirportCode())
                    .setSourceAirportName(sourceAirport.getAirportName())
                    .setDestinationAirportCode(destinationAirport.getAirportCode())
                    .setDestinationAirportName(destinationAirport.getAirportName())
                    .setPriceDto(priceDto);

            flightDtos.add(flightDto);
        });

        return flightDtos;
    }
}
