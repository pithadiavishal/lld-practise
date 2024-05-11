package lld.airlinemanagement;

import java.util.List;

public class Flight {
    String flightNumber;
    Airport departure;
    Airport arrival;
    int durationInMinuted;
    List<WeeklySchedule> weeklySchedule;
    List<CustomSchedule> customSchedule;

    private List<FlightInstance> flightInstances;
}
