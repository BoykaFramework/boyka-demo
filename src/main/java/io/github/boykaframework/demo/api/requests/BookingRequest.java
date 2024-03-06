package io.github.boykaframework.demo.api.requests;

import io.github.boykaframework.builders.ApiRequest;
import io.github.boykaframework.demo.api.pojo.Booking;
import io.github.boykaframework.enums.ContentType;
import io.github.boykaframework.enums.RequestMethod;
import lombok.experimental.UtilityClass;

@UtilityClass
public class BookingRequest {
    public static ApiRequest createBooking (final Booking booking) {
        return ApiRequest.createRequest ()
            .method (RequestMethod.POST)
            .header ("Accept", "application/json")
            .contentType (ContentType.JSON)
            .path ("/booking")
            .bodyObject (booking)
            .create ();
    }

    public static ApiRequest getBooking (final String id) {
        return ApiRequest.createRequest ()
            .method (RequestMethod.GET)
            .path ("/booking/${id}")
            .pathParam ("id", id)
            .create ();
    }

    public static ApiRequest getBookings () {
        return ApiRequest.createRequest ()
            .method (RequestMethod.GET)
            .path ("/booking")
            .create ();
    }
}
