package com.bennettanderson.controller;

import com.bennettanderson.dao.FishDao;
import com.bennettanderson.model.Fish;
import com.bennettanderson.model.Trip;
import com.bennettanderson.dao.TripDao;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class TripController {
    private FishDao fishDao;
    private TripDao tripDao;

    public TripController(FishDao fishDao, TripDao tripDao) {
        this.fishDao = fishDao;
        this.tripDao = tripDao;
    }

    @RequestMapping(path = "/trips", method = RequestMethod.GET)
    List<Trip> getTrips() {
        return tripDao.getAllTrips();
    }

    @RequestMapping(path = "trip/{id}", method = RequestMethod.GET)
    Trip getTripById(@PathVariable long id) {
        return tripDao.getTrip(id);
    }

    @RequestMapping(path = "fish", method = RequestMethod.GET)
    List<Fish> allFish() {
        return fishDao.getAllFish();
    }

    @RequestMapping(path = "trip", method = RequestMethod.POST)
    public Trip addTrip(@RequestBody Trip trip) {
        return tripDao.addTrip(trip);
    }
}
