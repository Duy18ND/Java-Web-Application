package com.re.bai2;

public class Dish {
    private int id;
    private String name;
    private double price;
    private boolean isAvalible; //True = còn hàng || False = hết hàng

    public Dish() {
    }

    public Dish(int id, String name, double price, boolean isAvalible) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.isAvalible = isAvalible;
    }

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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvalible() {
        return isAvalible;
    }

    public void setAvalible(boolean avalible) {
        isAvalible = avalible;
    }
}
