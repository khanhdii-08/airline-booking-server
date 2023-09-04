package com.iuh.airlinebooking.repository;

import com.iuh.airlinebooking.domain.Airline;
import com.iuh.airlinebooking.domain.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AirlineRepository extends JpaRepository<Airline, String> {

    List<Airline> findAllByFlightsIn(List<Flight> flights);
}
