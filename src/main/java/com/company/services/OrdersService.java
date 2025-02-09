package com.company.services;

import com.company.models.entity.OrdersEntity;
import com.company.repositories.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrdersService {
    @Autowired
    OrdersRepository ordersRepository;

    public OrdersEntity getId(Integer id) {
        Optional<OrdersEntity> ordersEntityOptional = ordersRepository.findById(id);
        return ordersEntityOptional.get();
    }

    public void saveOrders(OrdersEntity orders) {
        ordersRepository.save(orders);
    }

    public void putOrders(OrdersEntity newOrder, Integer id) {
        Optional<OrdersEntity> ordersEntityOptional = ordersRepository.findById(id);
        newOrder.setId(id);
        ordersRepository.save(newOrder);
    }

    public void deleteOrders(Integer id) {
        Optional<OrdersEntity> ordersEntityOptional = ordersRepository.findById(id);
        if(ordersEntityOptional.isPresent()){
            ordersRepository.deleteById(id);
        }
    }
}
