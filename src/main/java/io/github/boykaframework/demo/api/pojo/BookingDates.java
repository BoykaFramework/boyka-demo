package io.github.boykaframework.demo.api.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BookingDates {
    private String checkin;
    private String checkout;
}
