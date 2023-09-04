package com.iuh.airlinebooking.service.mapper;

import com.iuh.airlinebooking.domain.Flight;
import com.iuh.airlinebooking.service.dto.FlightDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface FlightMapper extends EntityMapper<FlightDto, Flight> {

    @Mapping(target = "airlineId", source = "airline.id")
    @Mapping(target = "aircraftId", source = "aircraft.id")
    @Mapping(target = "sourceAirportId", source = "sourceAirport.id")
    @Mapping(target = "destinationAirportId", source = "destinationAirport.id")
    FlightDto toDto(Flight entity);
}
