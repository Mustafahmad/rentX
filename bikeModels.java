package com.example.rentxapplication.models;

import com.google.firebase.database.IgnoreExtraProperties;

import java.io.Serializable;
@IgnoreExtraProperties
public class bikeModels implements Serializable {
    int image;
    String bike_title,bike_price,bike_area,imageURl,key,number,description;

    public bikeModels (int image,String bike_title, String bike_price,String bike_area){
        this.image = image;
        this.bike_title = bike_title;
        this.bike_price = bike_price;
        this.bike_area = bike_area;

    }
    public bikeModels(){

    }

    public bikeModels(String title, String price, String area,String number,String description, String imageURL) {
        this.imageURl = imageURL;
        this.bike_title = title;
        this.bike_price = price;
        this.bike_area = area;
        this.number = number;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getKey() {
        return key;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getImageURl() {
        return imageURl;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getBike_title() {
        return bike_title;
    }

    public void setBike_title(String bike_title) {
        this.bike_title = bike_title;
    }

    public String getBike_price() {
        return bike_price;
    }

    public void setBike_price(String bike_price) {
        this.bike_price = bike_price;
    }

    public String getBike_area() {
        return bike_area;
    }

    public void setBike_area(String bike_area) {
        this.bike_area = bike_area;
    }

}
