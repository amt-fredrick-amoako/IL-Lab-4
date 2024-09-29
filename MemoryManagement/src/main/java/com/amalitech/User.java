package com.amalitech;

public class User implements Observer{
    private String fullName;
    private String emailAddress;
    private String cellPhone;
    private String streetAddress;
    private String city;
    private String state;
    private String zipCode;

    public User(String fullName, String emailAddress, String cellPhone, String streetAddress, String city, String state, String zipCode) {
        this.fullName = fullName;
        this.emailAddress = emailAddress;
        this.cellPhone = cellPhone;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public void update(final String quote) {
        // user got updated with a new quote
    }

    @Override
    public void subscribe(final Subject subject) {
        subject.attach(this);
    }

    @Override
    public void unsubscribe(final Subject subject) {
        subject.detach(this);
    }

    @Override
    public String toString() {
        return "User [name=" + fullName + "]";
    }
}
