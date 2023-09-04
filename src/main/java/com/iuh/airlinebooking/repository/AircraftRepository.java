package com.iuh.airlinebooking.repository;

import com.iuh.airlinebooking.domain.Aircraft;
import com.iuh.airlinebooking.domain.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AircraftRepository extends JpaRepository<Aircraft, String> {
    List<Aircraft> findAllByFlightsIn(List<Flight> flights);
}
