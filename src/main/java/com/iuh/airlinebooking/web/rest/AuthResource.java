package com.iuh.airlinebooking.web.rest;

import com.iuh.airlinebooking.security.UserNotActivatedException;
import com.iuh.airlinebooking.service.PassengerService;
import com.iuh.airlinebooking.service.dto.PassengerDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthResource extends BaseResource{

    public static final String root = "/auth";

    @Autowired
    private PassengerService passengerService;

    @PostMapping(value = {V1 + root + "/register"})
    public ResponseEntity<?> register(@RequestBody PassengerDto passengerDto, HttpServletRequest request) {
        return new ResponseEntity<>(passengerService.create(passengerDto, request), HttpStatus.CREATED);
    }

    @GetMapping(value = {V1 + root + "/test"})
    public ResponseEntity<?> test(){
        if(true){
            throw new UserNotActivatedException("aassddfg");
        }
        return new ResponseEntity<>( "dss", HttpStatus.NOT_FOUND);
    }
}
