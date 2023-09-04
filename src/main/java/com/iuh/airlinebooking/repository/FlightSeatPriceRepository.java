package com.iuh.airlinebooking.repository;

import com.iuh.airlinebooking.domain.Flight;
import com.iuh.airlinebooking.domain.FlightSeatPrice;
import com.iuh.airlinebooking.enumtype.SeatClass;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlightSeatPriceRepository extends JpaRepository<FlightSeatPrice, String> {
    List<FlightSeatPrice> findAllByFlightInAndSeatClass(List<Flight> flights, SeatClass seatClass);
}
