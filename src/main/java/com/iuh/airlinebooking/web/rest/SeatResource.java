package com.iuh.airlinebooking.web.rest;

import com.iuh.airlinebooking.service.AirportService;
import com.iuh.airlinebooking.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SeatResource extends BaseResource {

    private static final String root = "/seat";

    @Autowired
    private SeatService seatService ;

    @GetMapping(V1 + root + "/all")
    public ResponseEntity<?> getAllAirport() {
        return new ResponseEntity<>(seatService.getAllSeat(), HttpStatus.OK);
    }
}
