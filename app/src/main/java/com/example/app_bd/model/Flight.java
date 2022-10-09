package com.example.app_bd.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Flight extends RealmObject {
    @PrimaryKey
    private int id;
    private String name;
    private String origin;
    private String destiny;
    private String price;
    private String plane;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestiny() {
        return destiny;
    }

    public void setDestiny(String destiny) {
        this.destiny = destiny;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPlane() {
        return plane;
    }

    public void setPlane(String plane) {
        this.plane = plane;
    }
}
