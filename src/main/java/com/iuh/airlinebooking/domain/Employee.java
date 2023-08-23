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
import lombok.Getter;

import java.util.Date;

@Getter
@Entity
public class Employee extends AbstractAuditingEntity<String> {

    @Id
    private String id;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
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

}
