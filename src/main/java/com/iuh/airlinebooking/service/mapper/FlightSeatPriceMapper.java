package com.iuh.airlinebooking.service.mapper;

import com.iuh.airlinebooking.domain.FlightSeatPrice;
import com.iuh.airlinebooking.service.dto.FlightSeatPriceDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface FlightSeatPriceMapper extends EntityMapper<FlightSeatPriceDto, FlightSeatPrice>{

    @Mapping(target = "flightId", source = "flight.id")
    @Mapping(target = "seatId", source = "seat.id")
    FlightSeatPriceDto toDto(FlightSeatPrice entity);
}
