package com.example.rentxapplication.models;

import android.widget.ImageView;

import com.google.firebase.database.IgnoreExtraProperties;

import java.io.Serializable;
@IgnoreExtraProperties
public class propertyModels implements Serializable {
    int image;
    String property_title,property_price,property_area,imageURL,key,number,description;

    public propertyModels (int image,String property_title, String property_price,String property_area){
        this.image = image;
        this.property_title = property_title;
        this.property_price = property_price;
        this.property_area = property_area;

    }

    public propertyModels(String title, String price, String area,String number,String description, String imageURL) {

        this.property_title = title;
        this.property_price = price;
        this.property_area = area;
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

    public propertyModels() {
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

    public String getProperty_title() {
        return property_title;
    }

    public void setProperty_title(String property_title) {
        this.property_title = property_title;
    }

    public String getProperty_price() {
        return property_price;
    }

    public void setProperty_price(String property_price) {
        this.property_price = property_price;
    }

    public String getProperty_area() {
        return property_area;
    }

    public void setProperty_area(String property_area) {
        this.property_area = property_area;
    }
}
