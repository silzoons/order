package com.sil.eurder.dtos;

import com.sil.eurder.domain.ItemGroup;

import java.util.Date;
import java.util.List;

public class OrderDto {

    private String customerId;
    private String orderId;
    private List<ItemGroup> itemGroupList;
    private Date shippingDate;
    private double totalPrice;

    public OrderDto(String customerId, String orderId, List<ItemGroup> itemGroupList, Date shippingDate, double totalPrice) {
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

    public Date getShippingDate() {
        return shippingDate;
    }

    public void setShippingDate(Date shippingDate) {
        this.shippingDate = shippingDate;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
