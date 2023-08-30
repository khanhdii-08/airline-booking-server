package com.iuh.airlinebooking.repository;

import com.iuh.airlinebooking.domain.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository<Seat, String> {

}
