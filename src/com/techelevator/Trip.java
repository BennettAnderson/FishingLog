package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class Trip {
    private String date = "-";
    private String location;
    private String weather = "-";
    private String comments = "-";
    private List<String> catchList = new ArrayList<>(); // might change this to list of fish

    public Trip(String date, String location, String weather, String comments) {
        this.date = date;
        this.location = location;
        this.weather = weather;
        this.comments = comments;
    }

    public Trip(String location) {
        this.location = location;
    }

    public List<String> getCatchList() {
        return catchList;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

    public void addCatch(String fish) {
        catchList.add(fish);
    }

}
