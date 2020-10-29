package com.sil.eurder;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ItemService {

    Map<String, Item> items = new HashMap<>();

    public void createItem(Item item){
        items.put(item.getItemId(), item);
    }



}
