package com.sil.eurder;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class CustomerService {

    Map<String, Customer> customers = new HashMap<>();

    public void createCustomer(Customer customer){
        customers.put(customer.getId(), customer);
    }

    public List<Customer> getAllCustomers() {
        return customers.values().stream().collect(Collectors.toList());
    }
}
