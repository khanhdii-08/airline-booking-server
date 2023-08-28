package com.iuh.airlinebooking.service.impl;

import com.iuh.airlinebooking.domain.Ticket;
import com.iuh.airlinebooking.repository.TicketRepository;
import com.iuh.airlinebooking.service.TicketService;
import com.iuh.airlinebooking.service.dto.TicketDto;
import com.iuh.airlinebooking.service.mapper.TicketMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private TicketMapper ticketMapper;

    @Override
    public List<TicketDto> getTicketAll() {
        return ticketMapper.toDto(ticketRepository.findAll());
    }
}
