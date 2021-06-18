package com.techelevator.model;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;


import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcFishDao implements FishDao {
    private JdbcTemplate jdbcTemplate;

    public JdbcFishDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void addFish(Fish fish, Long tripId) {
        String sql = "INSERT INTO fish (trip_id, species, length, lure) " +
                "VALUES (?, ?, ?, ?);";
        jdbcTemplate.update(sql, tripId, fish.getSpecies(), fish.getLength(), fish.getLure());
    }

    @Override
    public List<Fish> getFishFromTrip(Long tripId) {
        List<Fish> fishes = new ArrayList<>();
        String sql = "SELECT fish_id, species, length, lure FROM fish WHERE trip_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, tripId);
        while (results.next()) {
            fishes.add(mapRowToFish(results));
        }
        return fishes;
    }

    private Fish mapRowToFish(SqlRowSet rowSet) {
        Fish fish = new Fish();
        fish.setFishId(rowSet.getLong("fish_id"));
        fish.setSpecies(rowSet.getString("species"));
        fish.setLength(rowSet.getLong("length"));
        fish.setLure(rowSet.getString("lure"));
        return fish;
    }
}
