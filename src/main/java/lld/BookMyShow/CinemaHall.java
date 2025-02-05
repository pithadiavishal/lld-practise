package lld.BookMyShow;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CinemaHall {
    //Contains the details of Cinema Hall
    int cinemaHallId;
    String cinemaHallName;

    Address address;

    List<Auditorium>audiList;

    public Map<Date, Movie> getMovies(List<Date> dateList){
        return new HashMap<>();
    }
    public Map<Date, Show> getShows(List<Date> dateList){
        return new HashMap<>();
    }
}
