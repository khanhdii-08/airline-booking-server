package com.iuh.airlinebooking.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SeatDto {

    private String id;

    private String seatCode;

    private String seatName;

    private String seatClass;

    private String status;

    public SeatDto setId(String id) {
        this.id = id;
        return this;
    }

    public SeatDto setSeatCode(String seatCode) {
        this.seatCode = seatCode;
        return this;
    }

    public SeatDto setSeatName(String seatName) {
        this.seatName = seatName;
        return this;
    }

    public SeatDto setSeatClass(String seatClass) {
        this.seatClass = seatClass;
        return this;
    }

    public SeatDto setStatus(String status) {
        this.status = status;
        return this;
    }
}
