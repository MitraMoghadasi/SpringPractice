package com.company.controllers;

import com.company.models.entity.OrdersEntity;
import com.company.services.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;

    @GetMapping("/{id}")
    public OrdersEntity getOrderById(@PathVariable Integer id) {
        return ordersService.getId(id);
    }

    @PostMapping
    public void saveOrders(@RequestBody OrdersEntity orders) {
        ordersService.saveOrders(orders);
    }

    @PutMapping("/{id}")
    public void putOrders(@RequestBody OrdersEntity newOrders, @PathVariable Integer id) {
        ordersService.putOrders(newOrders, id);
    }

    @DeleteMapping("/{id}")
    public void deleteOrders(@PathVariable Integer id) {
        ordersService.deleteOrders(id);
    }


}
