package io.github.boykaframework.demo.api.requests;

import static io.github.boykaframework.enums.ContentType.JSON;
import static io.github.boykaframework.enums.RequestMethod.GET;
import static io.github.boykaframework.enums.RequestMethod.POST;

import io.github.boykaframework.builders.ApiRequest;
import io.github.boykaframework.demo.api.pojo.Booking;
import lombok.experimental.UtilityClass;

@UtilityClass
public class BookingRequest {
    public static ApiRequest createBooking (final Booking booking) {
        return ApiRequest.createRequest ()
            .method (POST)
            .header ("Accept", "application/json")
            .contentType (JSON)
            .path ("/booking")
            .bodyObject (booking)
            .create ();
    }

    public static ApiRequest getBooking (final String id) {
        return ApiRequest.createRequest ()
            .method (GET)
            .path ("/booking/${id}")
            .pathParam ("id", id)
            .create ();
    }

    public static ApiRequest getBookings () {
        return ApiRequest.createRequest ()
            .method (GET)
            .path ("/booking")
            .create ();
    }
}
