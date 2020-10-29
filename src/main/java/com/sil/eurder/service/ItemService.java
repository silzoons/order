package com.sil.eurder.service;

import com.sil.eurder.domain.Item;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
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

    public Item getItem(UUID id) {
        return items.get(id);
    }
}
