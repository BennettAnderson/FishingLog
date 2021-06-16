package com.techelevator;

public class Fish {
    private String species;
    private String length;
    private String lure;

    public Fish(String species) {
        this.species = species;
    }

    public Fish(String species, String length, String lure) {
        this.species = species;
        this.length = length;
        this.lure = lure;
    }

    public String fishDataString() {
        return species + ", " + length + ", " + lure + "^";
    }

    public void setLength(String length) {
        this.length = length;
    }

    public void setLure(String lure) {
        this.lure = lure;
    }

    public String getSpecies() {
        return species;
    }

    public String getLength() {
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
