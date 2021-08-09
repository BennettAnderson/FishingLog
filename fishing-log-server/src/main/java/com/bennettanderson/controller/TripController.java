package com.bennettanderson.controller;

import com.bennettanderson.dao.FishDao;
import com.bennettanderson.dao.UserDao;
import com.bennettanderson.model.Fish;
import com.bennettanderson.model.Trip;
import com.bennettanderson.dao.TripDao;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@CrossOrigin
@RestController
public class TripController {
    private FishDao fishDao;
    private TripDao tripDao;
    private UserDao userDao;

    public TripController(FishDao fishDao, TripDao tripDao, UserDao userDao) {
        this.fishDao = fishDao;
        this.tripDao = tripDao;
        this.userDao = userDao;
    }

    @RequestMapping(path = "/trips", method = RequestMethod.GET)
    List<Trip> getTrips(Principal principal) {
        return tripDao.getAllTrips(userDao.findIdByUsername(principal.getName()));
    }

    @RequestMapping(path = "/trip/{id}", method = RequestMethod.GET)
    Trip getTripById(@PathVariable int id, Principal principal) {
        return tripDao.getTrip(id, userDao.findIdByUsername(principal.getName()));
    }

    @RequestMapping(path = "/trip", method = RequestMethod.POST)
    public Long addTrip(@RequestBody Trip trip, Principal principal) {
        return tripDao.addTrip(trip, userDao.findIdByUsername(principal.getName()));
    }
}
