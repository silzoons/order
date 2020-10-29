package com.sil.eurder.domain.user;

public class Admin {

    private final String name;
    private final String id;

    public Admin(String name) {
        this.name = name;
        this.id = "admin";
    }

    public String getId() {
        return id;
    }
}
