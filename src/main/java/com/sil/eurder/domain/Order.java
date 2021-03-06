package com.sil.eurder.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class Order {
    private String customerId;
    private String orderId;
    private List<ItemGroup> itemGroupList;
    private LocalDate shippingDate;
    private double totalPrice;

    public Order(String customerId, String orderId, List<ItemGroup> itemGroupList, LocalDate shippingDate, double totalPrice) {
        this.customerId = customerId;
        this.orderId = orderId;
        this.itemGroupList = itemGroupList;
        this.shippingDate = shippingDate;
        this.totalPrice = totalPrice;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public List<ItemGroup> getItemGroupList() {
        return itemGroupList;
    }

    public void setItemGroupList(List<ItemGroup> itemGroupList) {
        this.itemGroupList = itemGroupList;
    }

    public LocalDate getShippingDate() {
        return shippingDate;
    }

    public void setShippingDate(LocalDate shippingDate) {
        this.shippingDate = shippingDate;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}