package com.iuh.airlinebooking.service.impl;

import com.iuh.airlinebooking.domain.Seat;
import com.iuh.airlinebooking.repository.SeatRepository;
import com.iuh.airlinebooking.service.SeatService;
import com.iuh.airlinebooking.service.dto.SeatDto;
import com.iuh.airlinebooking.service.mapper.SeatMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatServiceImpl implements SeatService {

    @Autowired
    private SeatRepository seatRepository;
    @Autowired
    private SeatMapper seatMapper;


    @Override
    public List<SeatDto> getAllSeat() {
        List<Seat> seats = seatRepository.findAll();
        return seatMapper.toDto(seats);
    }
}
