package com.iuh.airlinebooking.service.criteria;


import com.iuh.airlinebooking.annotation.Query;
import lombok.Data;
import java.time.LocalDate;

@Data
public class FlightCriteria {
    @Query
    private String id;

    private String sourceAirportId;

    private String destinationAirportId;

    private LocalDate departureDate;

    @Query(type = Query.Type.EQUAL)
    private String seatClass;

    private Integer numAdults;

    private Integer numChildren;

    private Integer numInfants;

}
