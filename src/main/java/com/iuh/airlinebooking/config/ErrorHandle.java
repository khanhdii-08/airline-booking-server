package com.iuh.airlinebooking.config;

import com.iuh.airlinebooking.web.rest.errors.CustomRestExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ErrorHandle extends CustomRestExceptionHandler {
}
