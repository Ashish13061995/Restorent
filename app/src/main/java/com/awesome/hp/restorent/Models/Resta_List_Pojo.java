package com.awesome.hp.restorent.Models;

import com.google.firebase.firestore.Exclude;

public class Resta_List_Pojo {

    @Exclude
    private String id;

    int image;
    String name, subTitle, location;



    public Resta_List_Pojo(int image, String name, String subTitle, String location) {
        this.image = image;
        this.name = name;
        this.subTitle = subTitle;
        this.location=location;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }


    public String getSubTitle() {
        return subTitle;
    }

    public String getLocation() {
        return location;
    }
}