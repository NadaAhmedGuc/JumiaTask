package com.jumia.interview.task.model.entity;

public class PhoneNumberListResponseModel {

    private String countryName;
    private String countryCode;
    private String numberPostfix;
    private Status status;

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getNumberPostfix() {
        return numberPostfix;
    }

    public void setNumberPostfix(String numberPostfix) {
        this.numberPostfix = numberPostfix;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
