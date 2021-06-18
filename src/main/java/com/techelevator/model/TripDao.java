package com.techelevator.model;

import java.util.List;

public interface TripDao {

    public List<Trip> getAllTrips();

    public Trip addTrip(Trip trip);

}
