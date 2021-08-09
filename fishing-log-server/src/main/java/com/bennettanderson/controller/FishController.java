package com.bennettanderson.controller;


import com.bennettanderson.dao.FishDao;
import com.bennettanderson.dao.TripDao;
import com.bennettanderson.dao.UserDao;
import com.bennettanderson.model.Fish;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@CrossOrigin
@RestController
public class FishController {
    private FishDao fishDao;
    private TripDao tripDao;
    private UserDao userDao;

    public FishController(FishDao fishDao, TripDao tripDao, UserDao userDao) {
        this.fishDao = fishDao;
        this.tripDao = tripDao;
        this.userDao = userDao;
    }

    @RequestMapping(path = "/fish", method = RequestMethod.GET)
    public List<Fish> allFish(Principal principal) {
        return fishDao.getAllFish(userDao.findIdByUsername(principal.getName()));
    }

    @RequestMapping(path = "/fish/{id}", method = RequestMethod.GET)
    public List<Fish> fishFromTrip(int id, Principal principal) {
        return fishDao.getFishFromTrip(id, userDao.findIdByUsername(principal.getName()));
    }

    @RequestMapping(path = "/add-fish/{tripId}", method = RequestMethod.POST)
    public void addFish (@RequestBody Fish fish, @PathVariable int tripId, Principal principal) {
        fishDao.addFish(fish, tripId, userDao.findIdByUsername(principal.getName()));
    }
}
