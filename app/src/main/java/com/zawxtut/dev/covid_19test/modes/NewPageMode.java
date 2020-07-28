package com.zawxtut.dev.covid_19test.modes;

public class NewPageMode {
    private String  dates;
    private String  title;
    private String  bodytext;

    public NewPageMode(String dates, String title, String bodytext) {
        this.dates = dates;
        this.title = title;
        this.bodytext = bodytext;
    }

    public String getDates() {
        return dates;
    }

    public void setDates(String dates) {
        this.dates = dates;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBodytext() {
        return bodytext;
    }

    public void setBodytext(String bodytext) {
        this.bodytext = bodytext;
    }
}
