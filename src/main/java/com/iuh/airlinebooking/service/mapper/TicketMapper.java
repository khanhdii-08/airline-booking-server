package com.iuh.airlinebooking.service.mapper;

import com.iuh.airlinebooking.domain.Ticket;
import com.iuh.airlinebooking.service.dto.TicketDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TicketMapper extends EntityMapper<TicketDto, Ticket> {

}
