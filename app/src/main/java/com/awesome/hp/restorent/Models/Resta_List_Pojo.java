package com.awesome.hp.restorent.Models;

public class Resta_List_Pojo {
    int image;
    String name, subTitle, location;



    public Resta_List_Pojo(int image, String name, String subTitle, String location) {
        this.image = image;
        this.name = name;
        this.subTitle = subTitle;
        this.location=location;
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