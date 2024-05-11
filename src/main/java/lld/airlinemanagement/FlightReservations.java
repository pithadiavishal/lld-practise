package lld.airlinemanagement;

import java.util.Date;
import java.util.Map;

public class FlightReservations {
    String reservationId;
    FlightInstance flightInstance;
    Map<Passenger, FlightSeat> passengerSeatMap;
    Date createdAt;
    ReservationStatus status;
}
