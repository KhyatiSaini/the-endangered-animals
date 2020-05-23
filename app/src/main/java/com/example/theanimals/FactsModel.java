package com.example.theanimals;

public class FactsModel {
    private int animalImageResource;
    private String fact;
    private String animalName;

    public FactsModel(int animalImageResource, String fact, String animalName) {
        this.animalImageResource = animalImageResource;
        this.fact = fact;
        this.animalName = animalName;
    }

    public int getAnimalImageResource() {
        return animalImageResource;
    }

    public String getFact() {
        return fact;
    }

    public String getAnimalName() {
        return animalName;
    }
}
