package com.iuh.airlinebooking.service.mapper;

import com.iuh.airlinebooking.domain.ServiceOption;
import com.iuh.airlinebooking.service.dto.ServiceOptDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ServiceOptMapper extends EntityMapper<ServiceOptDto, ServiceOption> {

    @Mapping(target = "airlineId", source = "airline.id")
    ServiceOptDto toDto(ServiceOption entity);
}
