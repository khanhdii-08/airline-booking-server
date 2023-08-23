package com.iuh.airlinebooking.repository;

import com.iuh.airlinebooking.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
