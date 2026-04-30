package com.example.First.project;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final Repo repo;

    public ProductService(Repo repo) {
        this.repo = repo;
    }

    public Product getProduct(int id) {
        return repo.findById(id).orElseThrow(() -> new ProductNotFoundException("Product not found"));
    }

    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    public Product createProduct(Product p) {
        if (p.getName() == null || p.getName().isBlank()) {
            throw new ProductNotFoundException("Name cannot be empty");
        }
        if(p.getPrice() <= 0){
            throw new RuntimeException("Price cannot be negative or zero");
        }
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
        if(repo.findById(id) == null){
            throw new ProductNotFoundException("Item not found");
        }
        repo.deleteById(id);
    }
}