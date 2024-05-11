package lld.airlinemanagement;

import java.util.Date;
import java.util.List;

public class Itinerary {
    String customerId;
    Airport startingAirport;
    Airport finalAirport;
    Date createdAt;
    List<FlightReservations> reservations;

}
