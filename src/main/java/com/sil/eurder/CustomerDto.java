package com.sil.eurder;

import java.util.UUID;

public class CustomerDto {
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String phoneNumber;
    private String id;

    public CustomerDto(String firstName, String lastName, String email, String address, String phoneNumber) {

    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getId() {
        return id;
    }
}
