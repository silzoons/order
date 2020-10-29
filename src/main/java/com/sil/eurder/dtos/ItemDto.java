package com.sil.eurder.dtos;

import java.util.UUID;

public class ItemDto {

        private String itemId;
        private String name;
        private String description;
        private double price;
        private Integer amountInStock;

        public ItemDto(String name, String description, double price, Integer amountInStock, String itemId) {
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


        public String getItemId() {
            return itemId;
        }

    }
