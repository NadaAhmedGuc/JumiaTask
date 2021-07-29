package com.jumia.interview.task.model.entity;

import javax.persistence.*;

@Entity
@Table
public class PhoneNumber {

    @Column
    private String countryName;
    @Id
    @Column
    private String numberPostfix;
    @Enumerated
    @Column
    private Status status;

    public PhoneNumber() {
    }

    public PhoneNumber(String countryName, String numberPostfix, Status status) {
        this.countryName = countryName;
        this.numberPostfix = numberPostfix;
        this.status = status;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
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
