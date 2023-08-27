package com.iuh.airlinebooking.service.impl;

import com.iuh.airlinebooking.config.Constants;
import com.iuh.airlinebooking.security.SecurityUtils;
import com.iuh.airlinebooking.service.BaseService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.LocaleResolver;

import java.util.Locale;
import java.util.Random;

@Service
public abstract class BaseServiceImpl implements BaseService {

    @Autowired
    protected MessageSource messageResource;
    @Autowired
    protected LocaleResolver localeResolver;

    public String getMessageCode(String code, HttpServletRequest request) {
        Locale locale = this.localeResolver.resolveLocale(request);
        Locale.setDefault(locale);
        return this.messageResource.getMessage(code, (Object[]) null, locale);
    }

    public String getPlatform(HttpServletRequest request){
        return request.getHeader(Constants.X_REQUEST_SOURCE);
    }
    public String getUserId(HttpServletRequest request) {
        return SecurityUtils.getCurrentUserLogin().get();
    }

    public String generateRandomColor(){
        Random rand = new Random();
        int red = rand.nextInt(256);
        int green = rand.nextInt(256);
        int blue = rand.nextInt(256);
        String color = String.format("#%02X%02X%02X", red, green, blue);
        return color;
    }
}
