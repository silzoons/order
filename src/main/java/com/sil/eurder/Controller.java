package com.sil.eurder;

import org.springframework.http.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/")
public class Controller {

    private final static Logger LOGGER = LoggerFactory.getLogger(Controller.class);
    private final CustomerService customerService;
    private final ItemService itemService;
    private final OrderService orderService;

    @Autowired
    public Controller(CustomerService customerService, ItemService itemService, OrderService orderService) {
        this.customerService = customerService;
        this.itemService = itemService;
        this.orderService = orderService;
    }

    @PostMapping(value = "/customer", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public CustomerDto createCustomer(@RequestBody CustomerDto newCustomerDto) {
        LOGGER.info("Register new customer");
        Customer newCustomer = EurderMapper.convertCustomerDtoToCustomer(newCustomerDto);
        customerService.createCustomer(newCustomer);
        return newCustomerDto;
    }

    @PostMapping(value = "/item", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ItemDto createItem(@RequestBody ItemDto newItemDto) {
        LOGGER.info("Register new item");
        Item newItem = EurderMapper.convertItemDtotoItem(newItemDto);
        itemService.createItem(newItem);
        return newItemDto;
    }

    @GetMapping("/customers")
    public List<CustomerDto> getAllCustomers(){
        List<Customer> customers = customerService.getAllCustomers();
        return  EurderMapper.convertCustomerListToCustomerDtoList(customers);
    }


}

