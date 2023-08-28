package com.iuh.airlinebooking.web.rest;

import com.iuh.airlinebooking.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AirportResource extends BaseResource {
    private static final String root = "/airport";

    @Autowired
    private AirportService airportService;

    @GetMapping(V1 + root + "/all")
    public ResponseEntity<?> getAllAirport() {
        return new ResponseEntity<>(airportService.getAllAirport(), HttpStatus.OK);
    }
}
