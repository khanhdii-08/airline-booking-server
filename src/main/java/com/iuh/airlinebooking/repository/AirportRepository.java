package com.iuh.airlinebooking.repository;

import com.iuh.airlinebooking.domain.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepository extends JpaRepository<Airport, String> {
}
