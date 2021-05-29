package com.techelevator;

public abstract class Fish {
    private String species;
    private int length;
    private String lure;

    public Fish(String species) {
        this.species = species;
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
}
