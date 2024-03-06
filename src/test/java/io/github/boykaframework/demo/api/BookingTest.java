package io.github.boykaframework.demo.api;

import static io.github.boykaframework.actions.api.ApiActions.withRequest;
import static io.github.boykaframework.enums.PlatformType.API;
import static io.github.boykaframework.manager.ParallelSession.clearSession;
import static io.github.boykaframework.manager.ParallelSession.createSession;

import io.github.boykaframework.demo.api.pojo.Booking;
import io.github.boykaframework.demo.api.pojo.BookingDates;
import io.github.boykaframework.demo.api.requests.BookingRequest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BookingTest {
    @BeforeClass
    public void setupClass () {
        createSession (API, "test_booking");
    }

    @AfterClass
    public void tearDownClass () {
        clearSession ();
    }

    @Test
    public void testCreateBooking () {
        final var booking = Booking.builder ()
            .firstname ("Wasiq")
            .lastname ("Bhamla")
            .additionalneeds ("Lunch")
            .depositpaid (true)
            .totalprice (1000)
            .bookingdates (new BookingDates ("2024-02-22", "2024-02-28"))
            .build ();
        final var request = BookingRequest.createBooking (booking);
        final var response = withRequest (request).execute ();
        response.verifyStatusCode ()
            .isEqualTo (200);
        response.verifyIntField ("bookingid")
            .isGreaterThan (0);
        response.verifyTextField ("booking.firstname")
            .isEqualTo ("Wasiq");

        final int id = response.getResponseData ("bookingid", Integer.class);
        System.out.println (id);
    }

    @Test
    public void testGetBookings () {
        final var request = BookingRequest.getBookings ();
        final var response = withRequest (request).execute ();
        response.verifyStatusCode ()
            .isEqualTo (200);
    }
}
