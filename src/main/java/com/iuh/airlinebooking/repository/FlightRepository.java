package com.iuh.airlinebooking.repository;

import com.iuh.airlinebooking.domain.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, String> {

}
