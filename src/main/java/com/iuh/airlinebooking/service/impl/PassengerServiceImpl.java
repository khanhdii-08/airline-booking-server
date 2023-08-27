package com.iuh.airlinebooking.service.impl;

import com.iuh.airlinebooking.config.Constants;
import com.iuh.airlinebooking.domain.Passenger;
import com.iuh.airlinebooking.domain.User;
import com.iuh.airlinebooking.enumtype.UserType;
import com.iuh.airlinebooking.repository.PassengerRepository;
import com.iuh.airlinebooking.repository.UserRepository;
import com.iuh.airlinebooking.security.jwt.TokenProvider;
import com.iuh.airlinebooking.service.PassengerService;
import com.iuh.airlinebooking.service.dto.PassengerDto;
import com.iuh.airlinebooking.service.dto.TokenDto;
import com.iuh.airlinebooking.service.mapper.PassengerMapper;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
public class PassengerServiceImpl extends BaseServiceImpl implements PassengerService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PassengerRepository passengerRepository;
    @Autowired
    private TokenProvider tokenProvider;
    @Autowired
    private PassengerMapper passengerMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public TokenDto create(PassengerDto passengerDto, HttpServletRequest request) {
        User user = new User();
        user.setPhoneNumber(passengerDto.getPhoneNumber())
                .setEmail(passengerDto.getEmail())
                .setActivated(false)
                .setPassword(passwordEncoder.encode(passengerDto.getPassword()))
                .setUserType(UserType.ROLE_USER);
        userRepository.save(user);
        Passenger passenger = passengerMapper.toEntity(passengerDto);
        passenger.setUser(user);
        passenger.setColor(generateRandomColor());
        passenger.setCreatedBy(user.getId());
        passengerRepository.save(passenger);
        Map<String, Object> claims = new HashMap<>();
        claims.put("role", user.getUserType());
        claims.put("platform", getPlatform(request));
        String token = tokenProvider.createToken(claims, user);
        return new TokenDto().setAccessToken(token);
    }
}
