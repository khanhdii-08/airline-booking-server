package com.iuh.airlinebooking.repository;

import com.iuh.airlinebooking.domain.Airport;
import com.iuh.airlinebooking.domain.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AirportRepository extends JpaRepository<Airport, String> {

    List<Airport> findAllBySourceFlightsIn(List<Flight> sourceFlights);

    List<Airport> findAllByDestinationFlightsIn(List<Flight> destinationFlights);

}
