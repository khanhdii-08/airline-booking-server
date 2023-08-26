package com.iuh.airlinebooking.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Getter
@Entity
@Table(name = "passenger")
@NoArgsConstructor
public class Passenger extends AbstractAuditingEntity<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private User user;

    @Column(name = "passenger_code")
    private String passengerCode;

    private String color;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private char gender;

    private String country;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    private String email;

    @Column(name = "is_passerby")
    private Boolean isPasserby;

    private String status;

    public Passenger setId(String id) {
        this.id = id;
        return this;
    }

    public Passenger setUser(User user) {
        this.user = user;
        return this;
    }

    public Passenger setPassengerCode(String passengerCode) {
        this.passengerCode = passengerCode;
        return this;
    }

    public Passenger setColor(String color) {
        this.color = color;
        return this;
    }

    public Passenger setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public Passenger setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public Passenger setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Passenger setGender(char gender) {
        this.gender = gender;
        return this;
    }

    public Passenger setCountry(String country) {
        this.country = country;
        return this;
    }

    public Passenger setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public Passenger setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public Passenger setEmail(String email) {
        this.email = email;
        return this;
    }

    public Passenger setPasserby(Boolean passerby) {
        isPasserby = passerby;
        return this;
    }

    public Passenger setStatus(String status) {
        this.status = status;
        return this;
    }
}
