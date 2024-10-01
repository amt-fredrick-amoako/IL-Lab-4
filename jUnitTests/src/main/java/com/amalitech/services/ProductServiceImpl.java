package com.amalitech.services;

import com.amalitech.models.Product;
import com.amalitech.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> getAllProducts(){
        return this.repository.findAll();
    }

    public Product getProductById(Long id){
        return repository.findById(id).orElse(null);
    }
}
