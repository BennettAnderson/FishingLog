package com.bennettanderson.dao;

import com.bennettanderson.model.Trip;

import java.util.List;

public interface TripDao {

    public List<Trip> getAllTrips(int userId);

    public Long addTrip(Trip trip, int userId);

    public Trip getTrip(int newId, int userId);
}
