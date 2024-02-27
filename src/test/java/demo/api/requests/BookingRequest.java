package demo.api.requests;

import com.github.wasiqb.boyka.builders.ApiRequest;
import com.github.wasiqb.boyka.enums.ContentType;
import com.github.wasiqb.boyka.enums.RequestMethod;
import demo.api.pojo.Booking;

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
