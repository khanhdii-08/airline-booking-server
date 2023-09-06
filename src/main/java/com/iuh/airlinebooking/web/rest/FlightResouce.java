package com.iuh.airlinebooking.web.rest;

import com.iuh.airlinebooking.enumtype.SeatClass;
import com.iuh.airlinebooking.service.FlightService;
import com.iuh.airlinebooking.service.criteria.FlightCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class FlightResouce extends BaseResource {

    private static final String root = "/flight";

    @Autowired
    private FlightService flightService;

    @GetMapping(V1 + root + "/search")
    public ResponseEntity<?> getListByCondition(@RequestParam(name = "sourceAirportId") String sourceAirportId,
                                                @RequestParam(name = "destinationAirportId") String destinationAirportId,
                                                @RequestParam(name = "departureDate") LocalDate departureDate,
                                                @RequestParam(name = "seatClass") String seatClass,
                                                @RequestParam(name = "numAdults") Integer numAdults,
                                                @RequestParam(name = "numChildren") Integer numChildren,
                                                @RequestParam(name = "numInfants") Integer numInfants) {

        FlightCriteria criteria = new FlightCriteria();
        criteria.setSourceAirportId(sourceAirportId);
        criteria.setDestinationAirportId(destinationAirportId);
        criteria.setDepartureDate(departureDate);
        criteria.setSeatClass(seatClass);
        criteria.setNumAdults(numAdults);
        criteria.setNumChildren(numChildren);
        criteria.setNumInfants(numInfants);

        return new ResponseEntity<>(flightService.getListByCondition(criteria), HttpStatus.OK);
    }

}
