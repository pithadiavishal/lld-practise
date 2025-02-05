package lld.BookMyShow;

import java.util.Date;
import java.util.List;

public class Booking {
    //Details of who booked, how many seats booked, which movie,payment...every thing.
    String bookingId;
    Date bookingDate;
    User member;
    Auditorium auditorium;
    Show show;
    BookingStatus bookingStatus;
    double totalAmount;
    List<Seat> seats;
    Payment paymentObj;

    public boolean makePayment(Payment payment){
        return true;
    }//api for making payment
}
