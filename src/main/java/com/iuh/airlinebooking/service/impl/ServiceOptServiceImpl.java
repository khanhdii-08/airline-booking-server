package com.iuh.airlinebooking.service.impl;

import com.iuh.airlinebooking.domain.ServiceOption;
import com.iuh.airlinebooking.enumtype.OptionType;
import com.iuh.airlinebooking.enumtype.SeatClass;
import com.iuh.airlinebooking.enumtype.Status;
import com.iuh.airlinebooking.repository.ServiceOptRepository;
import com.iuh.airlinebooking.service.ServiceOptService;
import com.iuh.airlinebooking.service.criteria.ServiceOptCriteria;
import com.iuh.airlinebooking.service.dto.ServiceAirlineOptDto;
import com.iuh.airlinebooking.service.dto.StandardOptDto;
import com.iuh.airlinebooking.service.mapper.ServiceOptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceOptServiceImpl implements ServiceOptService {

    @Autowired
    private ServiceOptRepository serviceOptRepository;
    @Autowired
    private ServiceOptMapper serviceOptMapper;


    @Override
    public ServiceAirlineOptDto getServiceAirlineOptDto(ServiceOptCriteria criteria) {
        List<ServiceOption> standardBaggageOptions = serviceOptRepository.findAllByAirlineIdAndOptionTypeAndSeatClassAndStatus(criteria.getAirlineId(),
                OptionType.BAGGAGE_OPT, SeatClass.valueOf(criteria.getSeatClass()), Status.ACT);

        List<ServiceOption> standardMealOptions = serviceOptRepository.findAllByAirlineIdAndOptionTypeAndSeatClassAndStatus(criteria.getAirlineId(),
                OptionType.MEAL_OPT, SeatClass.valueOf(criteria.getSeatClass()), Status.ACT);

        StandardOptDto standardOptDto = new StandardOptDto();
        standardOptDto.setStandardMealOptions(serviceOptMapper.toDto(standardMealOptions));
        standardOptDto.setStandardBaggageOptions(serviceOptMapper.toDto(standardBaggageOptions));

        List<ServiceOption> baggageOptions = serviceOptRepository.findAllByAirlineIdAndOptionTypeAndStatusAndSeatClassIsNull(criteria.getAirlineId(), OptionType.BAGGAGE_OPT, Status.ACT);
        List<ServiceOption> mealOptions = serviceOptRepository.findAllByAirlineIdAndOptionTypeAndStatusAndSeatClassIsNull(criteria.getAirlineId(), OptionType.MEAL_OPT, Status.ACT);

        ServiceAirlineOptDto serviceAirlineOptDto = new ServiceAirlineOptDto();
        serviceAirlineOptDto.setStandardOptDto(standardOptDto)
                .setBaggageOptions(serviceOptMapper.toDto(baggageOptions))
                .setMealOptions(serviceOptMapper.toDto(mealOptions));

        return serviceAirlineOptDto;
    }
}
