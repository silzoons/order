package com.sil.eurder.service;

import com.sil.eurder.domain.Item;
import com.sil.eurder.domain.Order;
import com.sil.eurder.exceptiona.AdminPrivilegeException;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class ItemService {


    Map<String, Item> items = new HashMap<>();

    public void createItem(Item item, String adminId){
        if (!adminId.equals("admin"))
        {throw new AdminPrivilegeException("admin required");}
        items.put(item.getItemId(), item);
    }
    public boolean checkIfItemsAreInStock(Order neworder) {
        return true;
    }

    public List<Item> getAllItems() {
        return items.values().stream().collect(Collectors.toList());
    }

    public Item getItem(UUID id) {
        return items.get(id);
    }
}
