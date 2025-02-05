package lld.BookMyShow;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class Movie {
    //Det
    // ails of the particular movie that is currently running.
    String movieName;
    int movieId;
    int durationInMins;
    String language;
    Genre genre;//  type of the movie
    Date releaseDate;
    Map<String, List<Show>> cityShowMap;//Which movie is running on which city
}
