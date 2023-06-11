package com.example.rentxapplication.models;

import android.widget.ImageView;

import com.google.firebase.database.IgnoreExtraProperties;

import java.io.Serializable;
@IgnoreExtraProperties

public class carModels implements Serializable {
    int car_image;
    String car_title,car_price,car_area,imageURL,key,car_number,car_description;

    public carModels (int car_image,String car_title, String car_price,String car_area){
        this.car_image = car_image;
        this.car_title = car_title;
        this.car_price = car_price;
        this.car_area = car_area;

    }
    public carModels() {
    }

    public carModels(String title, String price, String area, String number, String description, String imageURL) {
        this.car_title = title;
        this.car_price = price;
        this.car_area = area;
        this.imageURL = imageURL;
        this.car_number = number;
        this.car_description = description;


    }

    public String getCar_number() {
        return car_number;
    }

    public void setCar_number(String car_number) {
        this.car_number = car_number;
    }

    public String getCar_description() {
        return car_description;
    }

    public void setCar_description(String car_description) {
        this.car_description = car_description;
    }

    public String getImageURL() {
        return imageURL;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getCar_image() {
        return car_image;
    }

    public void setCar_image(int car_image) {
        this.car_image = car_image;
    }

    public String getCar_title() {
        return car_title;
    }

    public void setCar_title(String car_title) {
        this.car_title = car_title;
    }

    public String getCar_price() {
        return car_price;
    }

    public void setCar_price(String car_price) {
        this.car_price = car_price;
    }

    public String getCar_area() {
        return car_area;
    }

    public void setCar_area(String car_area) {
        this.car_area = car_area;
    }


}

