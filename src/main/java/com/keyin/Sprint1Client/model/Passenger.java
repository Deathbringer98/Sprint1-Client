package com.keyin.Sprint1Client.model;

public class Passenger {
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;

    // Getters
    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Passenger{id=" + id + ", firstName='" + firstName + "', lastName='" + lastName + "', phoneNumber='" + phoneNumber + "'}";
    }
}
