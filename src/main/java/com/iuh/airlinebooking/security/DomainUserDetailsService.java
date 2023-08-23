package com.iuh.airlinebooking.security;

import com.iuh.airlinebooking.domain.User;
import com.iuh.airlinebooking.repository.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Component("userDetailsService")
public class DomainUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    public DomainUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(final String userId) {
        return userRepository
                .findById(userId)
                .map(user -> createSpringSecurityUser(userId, user))
                .orElseThrow(() -> new UsernameNotFoundException("User with email " + userId + " was not found in the database"));
    }

    private org.springframework.security.core.userdetails.User createSpringSecurityUser(String lowercaseLogin, User user) {
        if (!user.isActivated()) {
            throw new UserNotActivatedException("User was not activated");
        }
        List<SimpleGrantedAuthority> grantedAuthorities = Arrays.asList(new SimpleGrantedAuthority( user.getUserType()));
        return new org.springframework.security.core.userdetails.User(user.getId(), user.getPassword(), grantedAuthorities);
    }
}
