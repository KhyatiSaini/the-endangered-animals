package com.example.theanimals;

public class Home_Model {
    private int animalImageResource;
    private String nameOfAnimal;
    private int nextImageView;

    public Home_Model(int animalImageResource, String nameOfAnimal, int nextImageView) {
        this.animalImageResource = animalImageResource;
        this.nameOfAnimal = nameOfAnimal;
        this.nextImageView = nextImageView;
    }

    public int getAnimalImageResource() {
        return animalImageResource;
    }

    public String getNameOfAnimal() {
        return nameOfAnimal;
    }

    public int getNextImageView() {
        return nextImageView;
    }
}
