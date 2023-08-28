package com.iuh.airlinebooking.repository;

import com.iuh.airlinebooking.domain.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, String> {
}
