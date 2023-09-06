package com.iuh.airlinebooking.repository;

import com.iuh.airlinebooking.domain.Flight;
import com.iuh.airlinebooking.enumtype.SeatClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, String> {

    @Query(value = "select f from Flight f " +
            " join Aircraft a on a.id = f.aircraft.id " +
            " join AircraftSeat as2 on a.id = as2.aircraft.id " +
            " join Seat s on s.id = as2.seat.id " +
            " where (f.sourceAirport.id =:sourceAirportId " +
            " and f.destinationAirport.id =:destinationAirportId " +
            " and date(f.departureTime) =:departureDate " +
            " and s.seatClass = :seatClass) ")
    List<Flight> findAllByCriteria(String sourceAirportId, String destinationAirportId, LocalDate departureDate, SeatClass seatClass);
}
