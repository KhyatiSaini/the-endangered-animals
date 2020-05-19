package com.example.theanimals;

public class Model {

    private int imageResource;
    private String animalName;
    private String info;
    private int next;

    public Model(int imageResource, String animalName, String info, int next) {
        this.imageResource = imageResource;
        this.animalName = animalName;
        this.info = info;
        this.next = next;
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

    public int getNext() {
        return next;
    }
}
