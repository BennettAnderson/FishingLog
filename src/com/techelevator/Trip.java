package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class Trip {
    private String date = "-";
    private String location;
    private String weather = "-";
    private String comments = "-";
    private List<Fish> catchList;

    public Trip(String date, String location, String weather, String comments, List<Fish> catchList) {
        this.date = date;
        this.location = location;
        this.weather = weather;
        this.comments = comments;
        this.catchList = catchList;
    }

    public Trip(String date, String location, String weather, String comments) {
        this.date = date;
        this.location = location;
        this.weather = weather;
        this.comments = comments;
    }

    public Trip() {};

    public List<Fish> getCatchList() {
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

    public void addCatch(Fish fish) {
        catchList.add(fish);
    }

    @Override
    public String toString() {
        StringBuilder tripDetails = new StringBuilder();
        tripDetails.append("\n*********************** ").append(location).append(" ***********************").append("\nDate: ").append(date).append("\nWeather Conditions: ").append(weather).append("\nCatch: ");
        for (Fish fish : catchList) {
            tripDetails.append(fish.toString());
        }
        tripDetails.append("\nNotes: ").append(comments);
        return tripDetails.toString();
    }

}
