package com.example.rentxapplication.models;

import android.widget.ImageView;

import com.google.firebase.database.IgnoreExtraProperties;

import java.io.Serializable;
@IgnoreExtraProperties
public class applianceModels implements Serializable {
    int applianceImage;
    String appliance_title,appliance_price,appliance_area,imageURL,key,appliNumber,appliDescription;

    public applianceModels (int applianceImage,String appliance_title, String appliance_price,String appliance_area){
        this.applianceImage = applianceImage;
        this.appliance_title = appliance_title;
        this.appliance_price = appliance_price;
        this.appliance_area = appliance_area;

    }

    public applianceModels() {
    }

    public applianceModels(String title, String price, String area,String number,String desc, String imageURL) {

        this.appliance_title = title;
        this.appliance_price = price;
        this.appliance_area = area;
        this.imageURL = imageURL;
        this.appliNumber = number;
        this.appliDescription = desc;


    }

    public String getAppliNumber() {
        return appliNumber;
    }

    public void setAppliNumber(String appliNumber) {
        this.appliNumber = appliNumber;
    }

    public String getAppliDescription() {
        return appliDescription;
    }

    public void setAppliDescription(String appliDescription) {
        this.appliDescription = appliDescription;
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

    public int getApplianceImage() {
        return applianceImage;
    }

    public void setApplianceImage(int applianceimage) {
        this.applianceImage = applianceimage;
    }

    public String getAppliance_title() {
        return appliance_title;
    }

    public void setAppliance_title(String appliance_title) {
        this.appliance_title = appliance_title;
    }

    public String getAppliance_price() {
        return appliance_price;
    }

    public void setAppliance_price(String appliance_price) {
        this.appliance_price = appliance_price;
    }

    public String getAppliance_area() {
        return appliance_area;
    }

    public void setAppliance_area(String appliance_area) {
        this.appliance_area = appliance_area;
    }
}
