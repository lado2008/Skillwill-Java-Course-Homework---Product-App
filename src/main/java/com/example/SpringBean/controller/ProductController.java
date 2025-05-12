package com.example.SpringBean.controller;

import com.example.SpringBean.model.Product;
import com.example.SpringBean.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    public final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping("/addProduct")
    public Product createProduct(@RequestBody Product product) {
        return service.addProduct(product);
    }

    @GetMapping("/getProducts")
    public List<Product> getAllProducts() {
        return service.getAllProducts();
    }

    @GetMapping("/getProduct/{id}")
    public Product getProduct(@PathVariable Long id) {
        return service.getProductById(id);
    }

}
