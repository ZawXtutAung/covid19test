package com.zawxtut.dev.covid_19test.modes;

public class MohViews {
    private String  casesOne;
    private String  casesTwo;
    private String  casesThree;
    private String  casestotal;

    public MohViews(String casesOne, String casesTwo, String casesThree, String casestotal) {
        this.casesOne = casesOne;
        this.casesTwo = casesTwo;
        this.casesThree = casesThree;
        this.casestotal = casestotal;
    }

    public String getCasesOne() {
        return casesOne;
    }

    public String getCasesTwo() {
        return casesTwo;
    }

    public String getCasesThree() {
        return casesThree;
    }

    public String getCasestotal() {
        return casestotal;
    }
}
