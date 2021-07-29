package com.jumia.interview.task.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Country {

    @Id
    @Column
    private String countryName;
    @Column
    private String countryCode;
    @Column
    private String countryRegex;

    public Country() {
    }

    public Country(String countryName, String countryCode, String countryRegex) {
        this.countryName = countryName;
        this.countryCode = countryCode;
        this.countryRegex = countryRegex;
    }

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

    public String getCountryRegex() {
        return countryRegex;
    }

    public void setCountryRegex(String countryRegex) {
        this.countryRegex = countryRegex;
    }
}
