package com.sil.eurder;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EurderMapper {

//    public static ItemDto convertItemtoItemDto(Item itemToConevrt) {
//        String id = itemToConevrt.getItemId();
//        String name = itemToConevrt.getName();
//        String description = itemToConevrt.getDescription();
//        String price = itemToConevrt.getPrice().toString;
//        String amountInStock = itemToConevrt.getAmountInStock().toString;
//        return new Item(name, description, price, amountInStock, id);
//    }

    public static Item convertItemDtotoItem(ItemDto itemDtoToConevrt) {
        String id = itemDtoToConevrt.getItemId();
        String name = itemDtoToConevrt.getName();
        String description = itemDtoToConevrt.getDescription();
        double price = itemDtoToConevrt.getPrice();
        int amountInStock = itemDtoToConevrt.getAmountInStock();
        return new Item(name, description, price, amountInStock, id);
    }

    public static List<CustomerDto> convertCustomerListToCustomerDtoList(List<Customer> allCustomers) {
        return allCustomers.stream()
                .map(customer -> new CustomerDto(customer.getFirstName(), customer.getLastName(), customer.getEmail(), customer.getPhoneNumber(), customer.getId()))
                .collect(Collectors.toList());
    }

    public CustomerDto convertCustomerToCustomerDto(Customer customerToConvert) {
        String id = customerToConvert.getId();
        String firstName = customerToConvert.getFirstName();
        String lastName = customerToConvert.getLastName();
        String email = customerToConvert.getEmail();
        String address = customerToConvert.getAddress();
        String phoneNumber = customerToConvert.getPhoneNumber();

        return new CustomerDto(firstName, lastName, email, address, phoneNumber);
    }

    public static Customer convertCustomerDtoToCustomer(CustomerDto customerDtoToConvert) {
        String id = customerDtoToConvert.getId();
        String firstName = customerDtoToConvert.getFirstName();
        String lastName = customerDtoToConvert.getLastName();
        String email = customerDtoToConvert.getEmail();
        String address = customerDtoToConvert.getAddress();
        String phoneNumber = customerDtoToConvert.getPhoneNumber();

        return new Customer(firstName, lastName, email, address, phoneNumber);
    }
}

