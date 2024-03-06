package io.github.boykaframework.demo.api.pojo;

import lombok.Builder;

@Builder
public class Booking {
    private String       additionalneeds;
    private BookingDates bookingdates;
    private boolean      depositpaid;
    private String       firstname;
    private String       lastname;
    private int          totalprice;
}
