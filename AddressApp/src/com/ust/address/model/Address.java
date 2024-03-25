package com.ust.address.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * Address class
 */
public class Address implements Serializable {

    private final String flatId;
    private final String firstName;
    private final String pinCode;
    private final String stateName;

    public Address(String flatId, String firstName, String pinCode, String stateName) {
        this.flatId = flatId;
        this.firstName = firstName;
        this.pinCode = pinCode;
        this.stateName = stateName;
    }

    public String getFlatId() {
        return flatId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPinCode() {
        return pinCode;
    }

    public String getStateName() {
        return stateName;
    }

    @Override
    public String toString() {
        return "Address{" +
                "flatId='" + flatId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", pinCode='" + pinCode + '\'' +
                ", stateName='" + stateName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(flatId, address.flatId) && Objects.equals(pinCode, address.pinCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flatId, pinCode);
    }
}
