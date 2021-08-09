package com.bennettanderson.model;

public class Fish {
    private int fishId;
    private String species;
    private int length;
    private String lure;

    public Fish(String species) {
        this.species = species;
    }

    public Fish(String species, int length, String lure) {
        this.species = species;
        this.length = length;
        this.lure = lure;
    }

    public Fish() {

    }

    public String fishDataString() {
        return species + ", " + length + ", " + lure + "^";
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public int getFishId() {
        return fishId;
    }

    public void setFishId(int fishId) {
        this.fishId = fishId;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setLure(String lure) {
        this.lure = lure;
    }

    public String getSpecies() {
        return species;
    }

    public int getLength() {
        return length;
    }

    public String getLure() {
        return lure;
    }

    @Override
    public String toString() {
        return String.format(" - %s (%s\") %s", species, length, lure);
    }
}
