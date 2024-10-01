package com.amalitech.services;

import com.amalitech.models.Order;
import com.amalitech.models.Product;
import com.amalitech.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order placeOrder(String customerName, List<Product> products){
        Order order = Order.builder()
                .customerName(customerName)
                .products(products)
                .totalAmount(products.stream().mapToDouble(Product::getPrice).sum())
                .build();

        return orderRepository.save(order);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
