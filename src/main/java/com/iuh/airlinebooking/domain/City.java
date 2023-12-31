package com.iuh.airlinebooking.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Set;

@Getter
@Entity
@Table(name = "city")
@NoArgsConstructor
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "city_code")
    private String cityCode;

    @Column(name = "city_name")
    private String cityName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy="city")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<Airport> airports;

    public City setId(String id) {
        this.id = id;
        return this;
    }

    public City setCityCode(String cityCode) {
        this.cityCode = cityCode;
        return this;
    }

    public City setCityName(String cityName) {
        this.cityName = cityName;
        return this;
    }

    public City setAirports(Set<Airport> airports) {
        this.airports = airports;
        return this;
    }
}
