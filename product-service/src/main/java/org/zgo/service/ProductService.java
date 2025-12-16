package org.zgo.service;

import org.zgo.entity.Product;
import org.zgo.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> saveProducts(List<Product> products) {
        return productRepository.saveAll(products);
    }

    public Page<Product> getAllProducts(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    public List<Product> getProduct(String category) {
        return productRepository.findByCategory(category);
    }
}
