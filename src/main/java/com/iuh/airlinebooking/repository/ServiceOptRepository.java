package com.iuh.airlinebooking.repository;

import com.iuh.airlinebooking.domain.ServiceOption;
import com.iuh.airlinebooking.enumtype.OptionType;
import com.iuh.airlinebooking.enumtype.SeatClass;
import com.iuh.airlinebooking.enumtype.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiceOptRepository extends JpaRepository<ServiceOption, String> {

    List<ServiceOption> findAllByAirlineIdAndOptionTypeAndSeatClassAndStatus(String airlineId, OptionType optionType, SeatClass seatClass, Status status);

    List<ServiceOption> findAllByAirlineIdAndOptionTypeAndStatusAndSeatClassIsNull(String airlineId, OptionType optionType, Status status);
}
