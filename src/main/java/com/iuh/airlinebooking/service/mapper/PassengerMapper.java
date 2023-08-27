package com.iuh.airlinebooking.service.mapper;

import com.iuh.airlinebooking.domain.Passenger;
import com.iuh.airlinebooking.service.dto.PassengerDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PassengerMapper extends EntityMapper<PassengerDto, Passenger> {

    @Mapping(target = "userId", source = "user.id")
    PassengerDto toDto(Passenger entity);
}
