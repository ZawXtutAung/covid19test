package com.zawxtut.dev.covid_19test.modes;

public class KnowModeMain {
    private String name;
    private int img;

//    public KnowModeMain(String name) {
//        this.name = name;
//    }


    public KnowModeMain(String name, int img) {
        this.name = name;
        this.img = img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public void setName(String name) {
        this.name = name;
    }



    public int getImg() {
        return img;
    }

    public String getName() {
        return name;
    }
}
