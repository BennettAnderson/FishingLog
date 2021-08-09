package com.bennettanderson.dao;

import com.bennettanderson.model.Trip;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcTripDao implements TripDao {
    private JdbcTemplate jdbcTemplate;
    private FishDao fishDao;

    public JdbcTripDao(DataSource dataSource, FishDao fishDao) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        this.fishDao = new JdbcFishDao(dataSource);
    }

    @Override
    public List<Trip> getAllTrips(int userId) {
        List<Trip> trips = new ArrayList<>();
        String sql = "SELECT trip_id, date, location, weather, comments FROM trip WHERE user_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            trips.add(mapRowToTrip(results, userId));
        }
        return trips;
    }

    @Override
    public Long addTrip(Trip trip, int userId) {
        String sql = "INSERT INTO trip (user_id, date, location, weather, comments) " +
                "VALUES (?, ?, ?, ?, ?) RETURNING trip_id;";
        Long newId = jdbcTemplate.queryForObject(sql, Long.class, userId, trip.getDate(), trip.getLocation(), trip.getWeather(), trip.getComments());
        return newId;
    }

    @Override
    public Trip getTrip(int newId, int userId) {
        Trip trip = null;
        String sql = "SELECT trip_id, date, location, weather, comments " +
                "FROM trip " +
                "WHERE trip_id = ? AND user_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, newId, userId);
        if (results.next()) {
            trip = mapRowToTrip(results, userId);
        }
        return trip;
    }

    private Trip mapRowToTrip(SqlRowSet rowset, int userId) {
        Trip trip = new Trip();
        trip.setTripId(rowset.getInt("trip_id"));
        trip.setDate(rowset.getString("date"));
        trip.setLocation(rowset.getString("location"));
        trip.setWeather(rowset.getString("weather"));
        trip.setComments(rowset.getString("comments"));
        trip.setFishList(fishDao.getFishFromTrip(rowset.getInt("trip_id"), userId));
        return trip;
    }
}
