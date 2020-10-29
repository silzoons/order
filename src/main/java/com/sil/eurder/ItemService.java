package com.sil.eurder;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class ItemService {

    Map<String, Item> items = new HashMap<>();

    public void createItem(Item item){
        items.put(item.getItemId(), item);
    }


    public List<Item> getAllItems() {
        return items.values().stream().collect(Collectors.toList());
    }
}
