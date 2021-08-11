package com.example.football;

import java.io.Serializable;

public class KitInfo implements Serializable {
    String name;
    String price;
    String size;
    int brand;

    public KitInfo(){}

    public KitInfo(String name, String price, String size, int brand) {
        this.name = name;
        this.price= price;
        this.size = size;
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getBrand() {
        return brand;
    }

    public void setBrand(int brand) {
        this.brand = brand;
    }
}
