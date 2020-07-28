package com.zawxtut.dev.covid_19test.modes;

public class CovidCountry {
    String mCovidCountry,mcases,mtodayCases,mdeaths,mtodayDeaths,mrecovered,mactive;

    public CovidCountry(String mCovidCountry, String mcases,String mdeaths,String mtodayDeaths,String mtodayCases) {
        this.mCovidCountry = mCovidCountry;
        this.mcases = mcases;
        this.mtodayCases = mtodayCases;
        this.mdeaths = mdeaths;
        this.mtodayDeaths = mtodayDeaths;
        this.mrecovered = mrecovered;
        this.mactive = mactive;
    }

    public String getmCovidCountry() {
        return mCovidCountry;
    }

    public String getMcases() {
        return mcases;
    }

    public String getMtodayCases() {
        return mtodayCases;
    }

    public String getMdeaths() {
        return mdeaths;
    }

    public String getMtodayDeaths() {
        return mtodayDeaths;
    }

    public String getMrecovered() {
        return mrecovered;
    }
}
