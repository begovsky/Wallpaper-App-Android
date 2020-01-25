package com.begovsky.pozadineaplikacija.models;


public class Image {

    private String imageId;
    private String imageUrl;
    private String category;

    public Image(String imageId, String imageUrl, String category) {
        this.imageId = imageId;
        this.imageUrl = imageUrl;
        this.category = category;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public String getImageId() {
        return this.imageId;
    }

    public String getCategory() {
        return this.category;
    }
}