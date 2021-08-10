package com.bennettanderson.model;

public class TripDTO {
    private String date;
    private String location;
    private String weather;
    private String comments;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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
        return "FishDTO{" +
                "date='" + date + '\'' +
                ", location='" + location + '\'' +
                ", weather='" + weather + '\'' +
                ", comments='" + comments + '\'' +
                '}';
    }
}
