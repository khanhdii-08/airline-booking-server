package com.iuh.airlinebooking.domain;

import com.iuh.airlinebooking.enumtype.UserType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @NotNull
    @Size(min = 10, max = 10)
    @Column(name = "phone_number", length = 11, nullable = false)
    private String phoneNumber;

    @NotNull
    @Email
    @Column(name = "email")
    private String email;

    @Size(min = 8, max = 100)
    private String password;

    @Column(name = "is_activated")
    private Boolean isActivated = false;

    @Column(name = "user_type")
    @Enumerated(EnumType.STRING)
    private UserType userType;

    @OneToOne(mappedBy = "user")
    private Passenger passenger;

    @OneToOne(mappedBy = "user")
    private Employee employee;

    public User setId(String id) {
        this.id = id;
        return this;
    }

    public User setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public Boolean isActivated() {
        return isActivated;
    }

    public User setActivated(Boolean activated) {
        isActivated = activated;
        return this;
    }

    public User setUserType(UserType userType) {
        this.userType = userType;
        return this;
    }

    public User setPassenger(Passenger passenger) {
        this.passenger = passenger;
        return this;
    }

    public User setEmployee(Employee employee) {
        this.employee = employee;
        return this;
    }
}
