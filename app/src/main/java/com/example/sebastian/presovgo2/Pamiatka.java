package com.example.sebastian.presovgo2;

public class Pamiatka {
    private String name;
    private String imageUrl;
    private String coordinates;


    public Pamiatka(String name, String imageUrl, String coordinates) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.coordinates = coordinates;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }
}
