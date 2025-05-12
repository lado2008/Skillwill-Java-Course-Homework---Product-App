package com.example.SpringBean.service;

import com.example.SpringBean.model.Product;
import org.springframework.stereotype.Service;

import java.util.*;

public interface ProductService {
    Product addProduct(Product product);
    List<Product> getAllProducts();
    Product getProductById(Long id);
}

@Service
class ProductServiceImpl implements ProductService {

    private final List<Product> dummyProducts = new ArrayList<>();

    @Override
    public Product addProduct(Product product) {
        product.setId((long) (dummyProducts.size() + 1));
        dummyProducts.add(product);
        return product;
    }

    @Override
    public List<Product> getAllProducts() {
        return dummyProducts;
    }

    @Override
    public Product getProductById(Long id) {
        Optional<Product> found = dummyProducts.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();

        return found.orElseThrow(() -> new RuntimeException("Product not found with this id: " + id));
    }
}
