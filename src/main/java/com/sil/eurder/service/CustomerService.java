package com.sil.eurder.service;

import com.sil.eurder.exceptiona.AdminPrivilegeException;
import com.sil.eurder.domain.user.Customer;
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
        if (customer.getFirstName() == null ||customer.getFirstName().equals("")) {
            throw new IllegalArgumentException("Please enter the first name.");
        }
        if (customer.getLastName() == null ||customer.getLastName().equals("")) {
            throw new IllegalArgumentException("Please enter the last name.");
        }
        if (customer.getAddress() == null ||customer.getAddress().equals("")) {
            throw new IllegalArgumentException("Please enter the address.");
        }
        if (customer.getEmail() == null ||customer.getEmail().equals("")) {
            throw new IllegalArgumentException("Please enter the email address.");
        }
        customers.put(UUID.fromString(customer.getId()), customer);
    }

    public List<Customer> getAllCustomers(String adminId) {
        if (!adminId.equals("admin"))
        {throw new AdminPrivilegeException("admin required");}

        return customers.values().stream().collect(Collectors.toList());
    }

    public Customer getCustomer(UUID id, String adminId) {

        if (!adminId.equals("admin"))
        {throw new AdminPrivilegeException("admin required");}
        return customers.get(id);
    }

    public boolean userExists(UUID id) {
        return customers.containsKey(id);
    }

}
