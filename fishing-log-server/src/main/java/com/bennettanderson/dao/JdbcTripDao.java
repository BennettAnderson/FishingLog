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

    public JdbcTripDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Trip> getAllTrips() {
        List<Trip> trips = new ArrayList<>();
        String sql = "SELECT trip_id, date, location, weather, comments FROM trip;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            trips.add(mapRowToTrip(results));
        }
        return trips;
    }

    @Override
    public Trip addTrip(Trip trip) {
        String sql = "INSERT INTO trip (date, location, weather, comments) " +
                "VALUES (?, ?, ?, ?) RETURNING trip_id;";
        Long newId = jdbcTemplate.queryForObject(sql, Long.class, trip.getDate(), trip.getLocation(), trip.getWeather(), trip.getComments());
        return getTrip(newId);
    }

    private Trip getTrip(Long newId) {
        Trip trip = null;
        String sql = "SELECT trip_id, date, location, weather, comments " +
                "FROM trip " +
                "WHERE trip_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, newId);
        if (results.next()) {
            trip = mapRowToTrip(results);
        }
        return trip;
    }

    private Trip mapRowToTrip(SqlRowSet rowset) {
        Trip trip = new Trip();
        trip.setTripId(rowset.getLong("trip_id"));
        trip.setDate(rowset.getString("date"));
        trip.setLocation(rowset.getString("location"));
        trip.setWeather(rowset.getString("weather"));
        trip.setComments(rowset.getString("comments"));
        return trip;
    }
}
