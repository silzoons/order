package com.sil.eurder;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class CustomerService {

    Map<UUID, Customer> customers = new HashMap<>();

    public void createCustomer(Customer customer){
        customers.put(UUID.fromString(customer.getId()), customer);
    }

    public List<Customer> getAllCustomers() {
        return customers.values().stream().collect(Collectors.toList());
    }

    public Customer getCustomer(UUID id) {
        return customers.get(id);
    }



}
