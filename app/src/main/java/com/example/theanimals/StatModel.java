package com.example.theanimals;

public class StatModel {

    private int imageResource;
    private String animalName;
    private String info;

    public StatModel(int imageResource, String animalName, String info) {
        this.imageResource = imageResource;
        this.animalName = animalName;
        this.info = info;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getAnimalName() {
        return animalName;
    }

    public String getInfo() {
        return info;
    }
}
