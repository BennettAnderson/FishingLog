package com.bennettanderson.model;

import java.util.ArrayList;
import java.util.List;

public class Trip {
    private long tripId;
    private String date = "-";
    private String location;
    private String weather = "-";
    private String comments = "-";
    private List<Fish> fishList = new ArrayList<>();

    public Trip(String date, String location, String weather, String comments) {
        this.date = date;
        this.location = location;
        this.weather = weather;
        this.comments = comments;
    }

    public Trip() { }

    public Trip(String location) {
        this.location = location;
    }

    public List<Fish> getFishList() {
        return fishList;
    }

    public void setFishList(List<Fish> fishList) {
        this.fishList = fishList;
    }

    public long getTripId() {
        return tripId;
    }

    public void setTripId(long tripId) {
        this.tripId = tripId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
    
    @Override
    public String toString() {
        return "\n*********************** " + location + " ***********************" +
                "\nDate: " + date +
                "\nWeather Conditions: " + weather +
                "\nNotes: " + comments;
    }
}
