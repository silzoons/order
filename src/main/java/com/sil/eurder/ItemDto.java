package com.sil.eurder;

import java.util.UUID;

public class ItemDto {

        private String itemId;
        private String name;
        private String description;
        private String price;
        private String amountInStock;

        public ItemDto(String name, String description, String price, String amountInStock, String itemId) {
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
            return Double.valueOf(price);
        }

        public int getAmountInStock() {
            return Integer.valueOf(amountInStock);
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
