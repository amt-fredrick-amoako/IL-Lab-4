package com.amalitech.controllers;

import com.amalitech.models.Product;
import com.amalitech.services.OrderService;
import com.amalitech.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {
    private final ProductService productService;

    private final OrderService orderService;

    private List<Product> cart = new ArrayList<>();

    public ProductController(ProductService productService, OrderService orderService) {
        this.productService = productService;
        this.orderService = orderService;
    }

    @GetMapping("/products")
    public String getAllProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "product-list";
    }

    @GetMapping("/add-to-cart/{id}")
    public String addToCart(@PathVariable("id") Long id) {
        Product product = productService.getProductById(id);
        if (product != null) {
            cart.add(product);
        }
        return "redirect:/products";
    }

    @GetMapping("/view-cart")
    public String viewCart(Model model) {
        model.addAttribute("cart", cart);
        return "cart";
    }

    @PostMapping("/place-order")
    public String placeOrder(@RequestParam("customerName") String customerName) {
        orderService.placeOrder(customerName, new ArrayList<>(cart));
        cart.clear();
        return "redirect:/orders";
    }

    @GetMapping("/orders")
    public String viewOrders(Model model) {
        model.addAttribute("orders", orderService.getAllOrders());
        return "orders";
    }
}

