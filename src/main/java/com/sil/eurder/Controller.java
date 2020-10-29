package com.sil.eurder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


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
        LOGGER.info("Request to register a new customer");
        Customer newCustomer = EurderMapper.convertCustomerDtoToCustomer(newCustomerDto);
        customerService.createCustomer(newCustomer);
        return newCustomerDto;
    }

    @PostMapping(value = "/item", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ItemDto createItem(@RequestBody ItemDto newItemDto) {
        LOGGER.info("Request to register a new item");
        Item newItem = EurderMapper.convertItemDtotoItem(newItemDto);
        itemService.createItem(newItem);
        return newItemDto;
    }

    @GetMapping(value = "/items")
    public List<ItemDto> getAllItems() {
        List<Item> items = itemService.getAllItems();
        return EurderMapper.convertItemListtoItemDtoList(items);
    }

    @GetMapping(value = "/item/{itemId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ItemDto getItemById(@PathVariable String itemId) {
        Item item = itemService.getItem(UUID.fromString(itemId));
        return EurderMapper.convertItemtoItemDto(itemService.getItem(UUID.fromString(item.getItemId())));
    }

    @GetMapping("/customers")
    public List<CustomerDto> getAllCustomers() {
        List<Customer> customers = customerService.getAllCustomers();
        return EurderMapper.convertCustomerListToCustomerDtoList(customers);
    }

    @GetMapping(value = "/customer/{customerId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public  CustomerDto getCustomerById(@PathVariable String customerId){
    Customer customer = customerService.getCustomer(UUID.fromString(customerId));
    return EurderMapper.convertCustomerToCustomerDto(customerService.getCustomer(UUID.fromString(customerId)));
    }
}

