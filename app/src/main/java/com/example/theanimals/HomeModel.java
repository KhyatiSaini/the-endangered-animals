package com.example.theanimals;

public class HomeModel {
    private int animalImageResource;
    private String nameOfAnimal;
    private int nextImageView;

    public HomeModel(int animalImageResource, String nameOfAnimal, int nextImageView) {
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