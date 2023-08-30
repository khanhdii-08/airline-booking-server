package com.iuh.airlinebooking.web.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

public class FlightResouce extends BaseResource {

    private static final String root = "/flight";
    @GetMapping(V1 + root + "/search")
    public ResponseEntity<?> getListByCondition(@RequestParam("sourceAirport") String sourceAirport,
                                                @RequestParam("destinationAirport") String destinationAirport,
                                                @RequestParam("departureDate") LocalDate departureTime,
                                                @RequestParam(value = "returnDate", required = false) LocalDate returnDate,
                                                @RequestParam("seatClass") String seatClass,
                                                @RequestParam("total") Integer total) {
        return null;
    }

}
