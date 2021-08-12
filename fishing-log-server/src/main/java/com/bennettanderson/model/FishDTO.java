package com.bennettanderson.model;

import javax.validation.constraints.NotEmpty;

public class FishDTO {

    private int fishId;
    private String species;
    private int length;
    private String lure;
    private int tripId;

    public int getFishId() {
        return fishId;
    }

    public void setFishId(int fishId) {
        this.fishId = fishId;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getTripId() {
        return tripId;
    }

    public void setTripId(int tripId) {
        this.tripId = tripId;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public int getLength() {
        return length;
    }

    public String getLure() {
        return lure;
    }

    public void setLure(String lure) {
        this.lure = lure;
    }

    @Override
    public String toString() {
        return "FishDTO{" +
                "species='" + species + '\'' +
                ", length='" + length + '\'' +
                ", lure='" + lure + '\'' +
                '}';
    }
}
