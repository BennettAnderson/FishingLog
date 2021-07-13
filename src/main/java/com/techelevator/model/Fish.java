package com.techelevator.model;

public class Fish {
    private long fishId;
    private String species;
    private long length;
    private String lure;

    public Fish(String species) {
        this.species = species;
    }

    public Fish(String species, long length, String lure) {
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

    public long getFishId() {
        return fishId;
    }

    public void setFishId(long fishId) {
        this.fishId = fishId;
    }

    public void setLength(long length) {
        this.length = length;
    }

    public void setLure(String lure) {
        this.lure = lure;
    }

    public String getSpecies() {
        return species;
    }

    public long getLength() {
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
