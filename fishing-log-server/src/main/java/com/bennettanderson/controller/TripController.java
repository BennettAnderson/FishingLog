package com.bennettanderson.controller;

import com.bennettanderson.dao.FishDao;
import com.bennettanderson.model.Trip;
import com.bennettanderson.dao.TripDao;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TripController {
    private FishDao fishDao;
    private TripDao tripDao;

    public TripController(FishDao fishDao, TripDao tripDao) {
        this.fishDao = fishDao;
        this.tripDao = tripDao;
    }

    @PreAuthorize("permitAll")
    @RequestMapping(path = "trips", method = RequestMethod.GET)
    List<Trip> getTrips() {
        return tripDao.getAllTrips();
    }
}
