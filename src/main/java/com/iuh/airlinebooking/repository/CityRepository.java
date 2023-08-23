package com.iuh.airlinebooking.repository;

import com.iuh.airlinebooking.domain.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityRepository extends JpaRepository<City, String> {

    List<City> findAllByIdIn(List<String> ids);
}
