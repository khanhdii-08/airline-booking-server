package com.iuh.airlinebooking.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
public class PassengerDto {

    private String id;

    private String userId;

    private String passengerCode;

    private String color;

    private String imageUrl;

    private String firstName;

    private String lastName;

    private char gender;

    private String country;

    private String phoneNumber;

    private Date dateOfBirth;

    private String email;

    private String password;

    private Boolean isPasserby;

    private String status;

    public PassengerDto setId(String id) {
        this.id = id;
        return this;
    }

    public PassengerDto setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public PassengerDto setPassengerCode(String passengerCode) {
        this.passengerCode = passengerCode;
        return this;
    }

    public PassengerDto setColor(String color) {
        this.color = color;
        return this;
    }

    public PassengerDto setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public PassengerDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public PassengerDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public PassengerDto setGender(char gender) {
        this.gender = gender;
        return this;
    }

    public PassengerDto setCountry(String country) {
        this.country = country;
        return this;
    }

    public PassengerDto setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public PassengerDto setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public PassengerDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public PassengerDto setPassword(String password) {
        this.password = password;
        return this;
    }

    public PassengerDto setPasserby(Boolean passerby) {
        isPasserby = passerby;
        return this;
    }

    public PassengerDto setStatus(String status) {
        this.status = status;
        return this;
    }
}
