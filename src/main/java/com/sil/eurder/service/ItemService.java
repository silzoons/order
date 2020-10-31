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
        if (item.getName() == null ||item.getName().equals("")) {
            throw new IllegalArgumentException("Please provide a name for this item.");
        }
        if (item.getDescription() == null ||item.getDescription().equals("")) {
            throw new IllegalArgumentException("Please provide a description for this item.");
        }


        items.put(item.getItemId(), item);
    }
    public boolean checkIfItemsAreInStock(Order neworder) {
        boolean result = true;
        for (int i = 0; i < neworder.getItemGroupList().size(); i++) {
            if (neworder.getItemGroupList().get(i).getAmountOrdered()<items.get(neworder.getItemGroupList().get(i).getItem().getItemId()).getAmountInStock())
            result = false;
        }
        return result;
    }

    public List<Item> getAllItems() {
        return items.values().stream().collect(Collectors.toList());
    }

    public Item getItem(UUID id) {
        return items.get(id);
    }
}
