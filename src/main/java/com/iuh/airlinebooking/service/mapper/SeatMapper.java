package com.iuh.airlinebooking.service.mapper;

import com.iuh.airlinebooking.domain.Seat;
import com.iuh.airlinebooking.service.dto.SeatDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SeatMapper extends EntityMapper<SeatDto, Seat> {

}
