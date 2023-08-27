package com.iuh.airlinebooking.repository;

import com.iuh.airlinebooking.domain.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger, String> {
}
