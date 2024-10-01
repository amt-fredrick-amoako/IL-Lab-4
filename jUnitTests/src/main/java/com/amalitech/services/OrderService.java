package com.amalitech.services;

import com.amalitech.models.Order;
import com.amalitech.models.Product;

import java.util.List;

public interface OrderService {
    Order placeOrder(String customerName, List<Product> products);
    List<Order> getAllOrders();
}
