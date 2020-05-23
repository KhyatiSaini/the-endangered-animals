package com.example.theanimals;

public class FactsModel {
    private int animalImageResource;
    private String fact;

    public FactsModel(int animalImageResource, String fact) {
        this.animalImageResource = animalImageResource;
        this.fact = fact;
    }

    public int getAnimalImageResource() {
        return animalImageResource;
    }

    public String getFact() {
        return fact;
    }
}
