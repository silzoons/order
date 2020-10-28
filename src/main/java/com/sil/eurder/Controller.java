package com.sil.eurder;

import org.apache.tomcat.util.http.parser.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;


@RestController
@RequestMapping(path ="/")
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

    @PostMapping(value = "/customer", produces = MediaType.APPLICATION_JSON) }

