package com.sil.eurder;

import java.util.UUID;

public class Item {
    private String itemId;
    private String name;
    private String description;
    private double price;
    private int amountInStock;

    public Item(String name, String description, double price, int amountInStock, String itemId) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.amountInStock = amountInStock;
        this.itemId = UUID.randomUUID().toString();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getAmountInStock() {
        return amountInStock;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setAmountInStock(int amountInStock) {
        this.amountInStock = amountInStock;
    }

    public String getItemId() {
        return itemId;
    }


}
