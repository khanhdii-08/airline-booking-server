package com.iuh.airlinebooking.service.mapper;

import com.iuh.airlinebooking.domain.Airport;
import com.iuh.airlinebooking.service.dto.AirportDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AirportMapper extends EntityMapper<AirportDto, Airport> {

    @Mapping(target = "cityId", source = "city.id")
    AirportDto toDto(Airport entity);
}
