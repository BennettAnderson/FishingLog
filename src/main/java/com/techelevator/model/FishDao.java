package com.techelevator.model;

import java.util.List;

public interface FishDao {

    public void addFish(Fish fish, Long tripId);

    public List<Fish> getFishFromTrip(Long tripId);

    public List<Fish> getAllFish();

    public String getLocationFromFish(long fishId);
}
