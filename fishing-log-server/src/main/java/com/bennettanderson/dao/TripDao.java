package com.bennettanderson.dao;

import com.bennettanderson.model.Trip;

import java.util.List;

public interface TripDao {

    public List<Trip> getAllTrips();

    public Trip addTrip(Trip trip);

    public Trip getTrip(Long newId);
}
