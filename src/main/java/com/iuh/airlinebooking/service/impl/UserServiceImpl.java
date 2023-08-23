package com.iuh.airlinebooking.service.impl;

import com.iuh.airlinebooking.repository.UserRepository;
import com.iuh.airlinebooking.security.jwt.TokenProvider;
import com.iuh.airlinebooking.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenProvider tokenProvider;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, TokenProvider tokenProvider) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.tokenProvider = tokenProvider;
    }

//    @Transactional
//    @Override
//    public RegisterResDto register(RegisterReqDto req) {
//        User user = new User();
//        user.setName(req.getName())
//                .setPhoneNumber(req.getPhoneNumber())
//                .setEmail(req.getEmail())
//                .setPassword(passwordEncoder.encode(req.getPassword()))
//                .setUserType(RoleEnum.ROLE_USER.toString());
//        userRepository.save(user);
//        Map<String, Object> claims = new HashMap<>();
//        claims.put("userId", user.getId());
//        claims.put("role", user.getUserType());
//        String token = tokenProvider.createToken(claims, user);
//        return new RegisterResDto().setToken(token);
//    }
}
