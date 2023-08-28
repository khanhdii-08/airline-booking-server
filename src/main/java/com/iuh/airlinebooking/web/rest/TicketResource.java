package com.iuh.airlinebooking.web.rest;

import com.iuh.airlinebooking.service.TicketService;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicketResource extends BaseResource{

    private static final String root = "/ticket";

    @Autowired
    private TicketService ticketService;

    @GetMapping(value = {V1 + root + "/all"})
    public ResponseEntity<?> getTicketAll() {
        return new ResponseEntity<>(ticketService.getTicketAll(), HttpStatus.OK);
    }


}
