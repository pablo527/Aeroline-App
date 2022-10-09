package com.example.app_bd.model;

import io.realm.RealmObject;

public class Plane extends RealmObject {
    private String id;
    private String brand;
    private String capacity;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

