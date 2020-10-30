package com.sil.eurder;

import com.sil.eurder.domain.Item;
import com.sil.eurder.domain.Order;
import com.sil.eurder.dtos.CustomerDto;
import com.sil.eurder.dtos.ItemDto;
import com.sil.eurder.dtos.OrderDto;
import com.sil.eurder.service.CustomerService;
import com.sil.eurder.service.ItemService;
import com.sil.eurder.service.OrderService;
import com.sil.eurder.domain.user.Admin;
import com.sil.eurder.domain.user.Customer;
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

    private static Logger LOGGER = LoggerFactory.getLogger(Controller.class);
    private CustomerService customerService;
    private ItemService itemService;
    private OrderService orderService;
    private Admin admin;

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
    public ItemDto createItem(@RequestBody ItemDto newItemDto, @RequestHeader String adminId) {
        LOGGER.info("Request to register a new item");
        Item newItem = EurderMapper.convertItemDtotoItem(newItemDto);
        itemService.createItem(newItem, adminId);
        return newItemDto;
    }

    @PostMapping(value = "/order", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public OrderDto createOrder(@RequestHeader String customerId, @RequestBody OrderDto newOrderDto){
        LOGGER.info("Create a new order, or what do you think?");
        Order neworder = EurderMapper.convertOrderDtoToOrder(newOrderDto);
        orderService.createOrder(neworder, customerId);
        return newOrderDto;
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
    public List<CustomerDto> getAllCustomers( @RequestHeader String adminId) {
        List<Customer> customers = customerService.getAllCustomers(adminId);
        return EurderMapper.convertCustomerListToCustomerDtoList(customers);
    }

    @GetMapping(value = "/customer/{customerId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public  CustomerDto getCustomerById(@PathVariable String customerId, @RequestHeader String adminId){
    Customer customer = customerService.getCustomer(UUID.fromString(customerId), adminId);
    return EurderMapper.convertCustomerToCustomerDto(customerService.getCustomer(UUID.fromString(customerId), adminId));
    }
}

