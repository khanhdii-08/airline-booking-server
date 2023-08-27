package com.iuh.airlinebooking.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
@Table(name = "employee")
@NoArgsConstructor
public class Employee extends AbstractAuditingEntity<String> {

    @Id
    private String id;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private User user;

    @Column(name = "empoloyee_code")
    private String employeeCode;

    private String code;

    @Column(name = "image_url")
    private String imageUrl;

    private String name;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    private char gender;

    @Column(name = "id_card")
    private String idCard;

    @Column(name = "phone_number")
    private String phoneNumber;

    private String email;

    private String street;

    @Column(name = "country_name")
    private String countryName;

    @Column(name = "province_name")
    private String provinceName;

    @Column(name = "district_name")
    private String districtName;

    @Column(name = "ward_name")
    private String wardName;

    private String status;

    public Employee setId(String id) {
        this.id = id;
        return this;
    }

    public Employee setUser(User user) {
        this.user = user;
        return this;
    }

    public Employee setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
        return this;
    }

    public Employee setCode(String code) {
        this.code = code;
        return this;
    }

    public Employee setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public Employee setName(String name) {
        this.name = name;
        return this;
    }

    public Employee setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public Employee setGender(char gender) {
        this.gender = gender;
        return this;
    }

    public Employee setIdCard(String idCard) {
        this.idCard = idCard;
        return this;
    }

    public Employee setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public Employee setEmail(String email) {
        this.email = email;
        return this;
    }

    public Employee setStreet(String street) {
        this.street = street;
        return this;
    }

    public Employee setCountryName(String countryName) {
        this.countryName = countryName;
        return this;
    }

    public Employee setProvinceName(String provinceName) {
        this.provinceName = provinceName;
        return this;
    }

    public Employee setDistrictName(String districtName) {
        this.districtName = districtName;
        return this;
    }

    public Employee setWardName(String wardName) {
        this.wardName = wardName;
        return this;
    }

    public Employee setStatus(String status) {
        this.status = status;
        return this;
    }
}
