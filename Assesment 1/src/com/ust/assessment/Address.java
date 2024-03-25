package com.ust.assessment;

public class Address {

    private int houseNo;
    private String street;
    private String city;
    private int pinCode;

    public Address(int houseNo, String street, String city, int pinCode) {
        this.houseNo = houseNo;
        this.street = street;
        this.city = city;
        this.pinCode = pinCode;
    }

    public int getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(int houseNo) {
        this.houseNo = houseNo;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPinCode() {
        return pinCode;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "houseNo=" + houseNo +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", pinCode=" + pinCode +
                '}';
    }
}
