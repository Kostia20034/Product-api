package com.example.First.project.service;

import com.example.First.project.exceptions.ProductNotFoundException;
import com.example.First.project.model.Product;
import com.example.First.project.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repo;

    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    public Product getProduct(int id) {
        return repo.findById(id).orElseThrow(() -> new ProductNotFoundException("Product not found"));
    }

    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    public Product createProduct(Product p) {
        return repo.save(p);
    }

    public Product updateProduct(int id, Product np) {
        Product existing = repo.findById(id).orElseThrow(() -> new ProductNotFoundException("Product not found"));
        existing.setName(np.getName());
        existing.setPrice(np.getPrice());
        return repo.save(existing);
    }

    public List<Product> getProductByName(String name) {
        return repo.findByNameContainingIgnoreCase(name);
    }

    public void deleteProductById(int id) {
        repo.findById(id).orElseThrow(() -> new ProductNotFoundException("Item not found"));
        repo.deleteById(id);
    }
}