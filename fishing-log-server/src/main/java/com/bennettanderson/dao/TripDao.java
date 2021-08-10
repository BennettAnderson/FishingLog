package com.bennettanderson.dao;

import com.bennettanderson.model.Trip;
import com.bennettanderson.model.TripDTO;

import java.util.List;

public interface TripDao {

    public List<Trip> getAllTrips(int userId);

    public int addTrip(TripDTO tripDTO, int userId);

    public Trip getTrip(int newId, int userId);
}
