package com.example.learnanimals;

import android.app.Application;

public class Animal extends Application {
    private int image;
    private String name;

    public Animal() {

    }

    public Animal(int image, String name) {
        this.image = image;
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }
}
