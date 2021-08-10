package com.bennettanderson.dao;


import com.bennettanderson.dao.FishDao;
import com.bennettanderson.model.Fish;
import com.bennettanderson.model.FishDTO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;


import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcFishDao implements FishDao {
    private JdbcTemplate jdbcTemplate;

    public JdbcFishDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void addFish(FishDTO fishDTO, int userId) {
        String sql = "INSERT INTO fish (trip_id, species, length, lure, user_id) " +
                "VALUES (?, ?, ?, ?, ?);";
        jdbcTemplate.update(sql, fishDTO.getTripId(), fishDTO.getSpecies(), fishDTO.getLength(), fishDTO.getLure(), userId);
    }

    @Override
    public List<Fish> getFishFromTrip(int tripId, int userId) {
        List<Fish> fishes = new ArrayList<>();
        String sql = "SELECT fish_id, species, length, lure FROM fish WHERE trip_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, tripId);
        while (results.next()) {
            fishes.add(mapRowToFish(results));
        }
        return fishes;
    }

    @Override
    public List<Fish> getAllFish(int userId) {
        List<Fish> fishes = new ArrayList<>();
        String sql = "SELECT fish_id, species, length, lure FROM fish ORDER BY length DESC;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            fishes.add(mapRowToFish(results));
        }
        return fishes;
    }

    @Override
    public String getLocationFromFish(int fishId, int userId) {
        String location = null;
        String sql = "SELECT location FROM trip JOIN fish ON trip.trip_id = fish.trip_id " +
                "WHERE fish_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, fishId);
        if (results.next()) {
            location = results.getString("location");
        }
        return location;
    }

    private Fish mapRowToFish(SqlRowSet rowSet) {
        Fish fish = new Fish();
        fish.setFishId(rowSet.getInt("fish_id"));
        fish.setSpecies(rowSet.getString("species"));
        fish.setLength(rowSet.getInt("length"));
        fish.setLure(rowSet.getString("lure"));
        return fish;
    }
}
