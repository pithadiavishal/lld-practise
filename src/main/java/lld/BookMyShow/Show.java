package lld.BookMyShow;

import java.util.Date;
import java.util.List;

public class Show {
    int showId;
    Movie movie;
    Date startTime;
    Date endTime;
    CinemaHall cinemaPlayedAt;
    List<Seat> seats;
}
