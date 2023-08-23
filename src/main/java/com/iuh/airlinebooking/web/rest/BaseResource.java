package com.iuh.airlinebooking.web.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping({"/api"})
public class BaseResource {
    protected final String V1 = "v1";
    protected final String V2 = "v2";
    @Value("${spring.application.name}")
    public String appName;
}
