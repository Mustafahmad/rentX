package com.example.rentxapplication.models;

import android.widget.ImageView;

import com.google.firebase.database.IgnoreExtraProperties;

import java.io.Serializable;
@IgnoreExtraProperties
public class clothesModels implements Serializable {
    int image;
    String clothes_title,clothes_price,clothes_area,imageURL,key,number,description;

    public clothesModels (int image,String clothes_title, String clothes_price,String clothes_area){
        this.image = image;
        this.clothes_title = clothes_title;
        this.clothes_price = clothes_price;
        this.clothes_area = clothes_area;

    }

    public clothesModels() {
    }

    public clothesModels(String title, String price, String area,String number,String description, String imageURL) {

        this.clothes_title = title;
        this.clothes_price = price;
        this.clothes_area = area;
        this.imageURL = imageURL;
        this.number = number;
        this.description = description;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
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

    public void setKey(String key) {
        this.key = key;
    }

    public String getImageURL() {
        return imageURL;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getClothes_title() {
        return clothes_title;
    }

    public void setClothes_title(String clothes_title) {
        this.clothes_title = clothes_title;
    }

    public String getClothes_price() {
        return clothes_price;
    }

    public void setClothes_price(String clothes_price) {
        this.clothes_price = clothes_price;
    }

    public String getClothes_area() {
        return clothes_area;
    }

    public void setClothes_area(String clothes_area) {
        this.clothes_area = clothes_area;
    }
}
