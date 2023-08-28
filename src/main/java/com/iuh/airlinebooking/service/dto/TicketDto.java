package com.iuh.airlinebooking.service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TicketDto {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String id;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String ticketCode;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String ticketName;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String definition;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String seatClass;

    public TicketDto setId(String id) {
        this.id = id;
        return this;
    }

    public TicketDto setTicketCode(String ticketCode) {
        this.ticketCode = ticketCode;
        return this;
    }

    public TicketDto setTicketName(String ticketName) {
        this.ticketName = ticketName;
        return this;
    }

    public TicketDto setDefinition(String definition) {
        this.definition = definition;
        return this;
    }

    public TicketDto setSeatClass(String seatClass) {
        this.seatClass = seatClass;
        return this;
    }

}
