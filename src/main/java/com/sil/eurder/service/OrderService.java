package com.sil.eurder.service;

import com.sil.eurder.domain.Order;
import com.sil.eurder.exceptiona.NotACustomerException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class OrderService {
    public static final int DAYS_TO_ADD_WHEN_IN_STOCK = 1;
    public static final int DAYS_TO_ADD_WHEN_NOT_IN_STOCK = 7;
    CustomerService customerService;
    ItemService itemService;
    Map<String, Order> orders = new HashMap<>();

    public void createOrder(Order neworder, String customerId) {
        if (!customerService.userExists(UUID.fromString(customerId)))
            throw new NotACustomerException("you must first register");

        if (itemService.checkIfItemsAreInStock(neworder))
            neworder.setShippingDate(LocalDate.now().plusDays(DAYS_TO_ADD_WHEN_IN_STOCK));
        else neworder.setShippingDate(LocalDate.now().plusDays(DAYS_TO_ADD_WHEN_NOT_IN_STOCK));


        orders.put(neworder.getOrderId(), neworder);
    }


}
