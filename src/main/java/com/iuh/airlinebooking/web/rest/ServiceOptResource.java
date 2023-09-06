package com.iuh.airlinebooking.web.rest;

import com.iuh.airlinebooking.service.ServiceOptService;
import com.iuh.airlinebooking.service.criteria.ServiceOptCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceOptResource extends BaseResource {
    private static final String root = "/service-option";

    @Autowired
    private ServiceOptService serviceOptService;

    @GetMapping(V1 + root )
    public ResponseEntity<?> getAllServiceOpt(@RequestParam("airlineId") String airlineId,
                                                @RequestParam("seatClass") String seatClass) {

        ServiceOptCriteria criteria = new ServiceOptCriteria();
        criteria.setAirlineId(airlineId);
        criteria.setSeatClass(seatClass);

        return new ResponseEntity<>(serviceOptService.getServiceAirlineOptDto(criteria), HttpStatus.OK) ;
    }
}
