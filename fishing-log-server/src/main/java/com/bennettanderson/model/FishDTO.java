package com.bennettanderson.model;

import javax.validation.constraints.NotEmpty;

public class FishDTO {

    private String species;
    private Long length;
    private String lure;

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public Long getLength() {
        return length;
    }

    public void setLength(Long length) {
        this.length = length;
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
