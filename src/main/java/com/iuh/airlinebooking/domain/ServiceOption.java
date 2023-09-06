package com.iuh.airlinebooking.domain;

import com.iuh.airlinebooking.enumtype.LuggageType;
import com.iuh.airlinebooking.enumtype.OptionType;
import com.iuh.airlinebooking.enumtype.SeatClass;
import com.iuh.airlinebooking.enumtype.Status;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "service_option")
@Getter
@NoArgsConstructor
public class ServiceOption extends AbstractAuditingEntity<String>{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "option_code")
    private String optionCode;

    @Column(name = "option_name")
    private String optionName;

    @Column(name = "option_description")
    private String optionDescription;

    @Column(name = "value")
    private Double value;

    @Column(name = "luggage_type")
    @Enumerated(EnumType.STRING)
    private LuggageType luggageType;

    @Column(name = "option_price")
    private Double optionPrice;

    @Column(name = "option_image")
    private String optionImage;

    @Column(name = "option_type")
    @Enumerated(EnumType.STRING)
    private OptionType optionType;

    @Column(name = "seat_class")
    @Enumerated(EnumType.STRING)
    private SeatClass seatClass;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "airline_id", nullable = false)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Airline airline;

    public ServiceOption setId(String id) {
        this.id = id;
        return this;
    }

    public ServiceOption setOptionCode(String optionCode) {
        this.optionCode = optionCode;
        return this;
    }

    public ServiceOption setOptionName(String optionName) {
        this.optionName = optionName;
        return this;
    }

    public ServiceOption setOptionDescription(String optionDescription) {
        this.optionDescription = optionDescription;
        return this;
    }

    public ServiceOption setValue(Double value) {
        this.value = value;
        return this;
    }

    public ServiceOption setLuggageType(LuggageType luggageType) {
        this.luggageType = luggageType;
        return this;
    }

    public ServiceOption setOptionPrice(Double optionPrice) {
        this.optionPrice = optionPrice;
        return this;
    }

    public ServiceOption setOptionImage(String optionImage) {
        this.optionImage = optionImage;
        return this;
    }

    public ServiceOption setOptionType(OptionType optionType) {
        this.optionType = optionType;
        return this;
    }

    public ServiceOption setStatus(Status status) {
        this.status = status;
        return this;
    }

    public ServiceOption setSeatClass(SeatClass seatClass) {
        this.seatClass = seatClass;
        return this;
    }

    public ServiceOption setAirline(Airline airline) {
        this.airline = airline;
        return this;
    }
}
