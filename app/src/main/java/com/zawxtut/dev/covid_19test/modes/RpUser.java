package com.zawxtut.dev.covid_19test.modes;

public class RpUser {
    private String  username;
    private String  rpphone;
    private String  rpRegionCity;
    private String  rpIdCard;
    private String  rpCity;
    private String  rpStreet;
    private String  rpVillage;
    private String  rpReson;
    public RpUser(){

    }

    public RpUser(String username, String rpphone, String rpRegionCity, String rpIdCard,
                  String rpCity, String rpStreet, String rpVillage,String rpReson) {
        this.username = username;
        this.rpphone = rpphone;
        this.rpRegionCity = rpRegionCity;
        this.rpIdCard = rpIdCard;
        this.rpCity = rpCity;
        this.rpStreet = rpStreet;
        this.rpVillage = rpVillage;
        this.rpReson=rpReson;
    }
    ////set//

    public void setRpReson(String rpReson) {
        this.rpReson = rpReson;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setRpphone(String rpphone) {
        this.rpphone = rpphone;
    }

    public void setRpRegionCity(String rpRegionCity) {
        this.rpRegionCity = rpRegionCity;
    }

    public void setRpIdCard(String rpIdCard) {
        this.rpIdCard = rpIdCard;
    }

    public void setRpCity(String rpCity) {
        this.rpCity = rpCity;
    }

    public void setRpStreet(String rpStreet) {
        this.rpStreet = rpStreet;
    }
    public void setRpVillage(String rpVillage) {
        this.rpVillage = rpVillage;
    }
    /////////////Get

    public String getUsername() {
        return username;
    }

    public String getRpphone() {
        return rpphone;
    }

    public String getRpRegionCity() {
        return rpRegionCity;
    }

    public String getRpIdCard() {
        return rpIdCard;
    }

    public String getRpCity() {
        return rpCity;
    }

    public String getRpStreet() {
        return rpStreet;
    }
    public String getRpVillage() {
        return rpVillage;
    }

    public String getRpReson() {
        return rpReson;
    }
}

