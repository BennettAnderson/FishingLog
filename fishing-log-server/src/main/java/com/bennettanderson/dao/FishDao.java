package com.bennettanderson.dao;

import com.bennettanderson.model.Fish;
import com.bennettanderson.model.FishDTO;

import java.util.List;

public interface FishDao {

    void addFish(FishDTO fishDTO, int userId);

    List<Fish> getFishFromTrip(int tripId, int userId);

    List<Fish> getAllFish(int userId);

    String getLocationFromFish(int fishId, int userId);
}
