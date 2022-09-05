package com.coin.collection;

public class Coins {
    String country;
    String denomination;
    String yearOfMinting;
    String currentValue;
    String acquiredDate;
    
    public Coins() {
    }

    public Coins(String v1, String v2, String v3, String v4, String v5) {
        country = v1;
        denomination = v2;
        yearOfMinting = v3;
        currentValue = v4;
        acquiredDate = v5;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDenomination() {
        return denomination;
    }

    public void setDenomination(String denomination) {
        this.denomination = denomination;
    }

    public String getYearOfMinting() {
        return yearOfMinting;
    }

    public void setYearOfMinting(String yearOfMinting) {
        this.yearOfMinting = yearOfMinting;
    }

    public String getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(String currentValue) {
        this.currentValue = currentValue;
    }

    public String getAcquiredDate() {
        return acquiredDate;
    }

    public void setAcquiredDate(String acquiredDate) {
        this.acquiredDate = acquiredDate;
    }
}
