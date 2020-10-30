package com.sil.eurder.dtos;

import com.sil.eurder.domain.Item;

public class ItemgroupDto {

    private Item item;
    private int amountOrdered;

    public ItemgroupDto(Item item, int amountOrdered) {
        this.item = item;
        this.amountOrdered = amountOrdered;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getAmountOrdered() {
        return amountOrdered;
    }

    public void setAmountOrdered(int amountOrdered) {
        this.amountOrdered = amountOrdered;
    }
}
