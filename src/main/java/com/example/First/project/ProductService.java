package com.example.First.project;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final Repo repo;

    public ProductService(Repo repo) {
        this.repo = repo;
    }

    public Product getProduct(int id) {
        // FIX: was orElseThrow() which crashes when product not found,
        // but controller was checking for null — now consistent
        return repo.findById(id).orElse(null);
    }

    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    public Product createProject(Product p) {
        return repo.save(p);
    }

    public Product updateProduct(int id, Product np) {
        Product p = repo.findById(id).orElse(null);
        if (p == null) return null;
        p.setName(np.getName());
        p.setPrice(np.getPrice());
        return repo.save(p);
    }

    public List<Product> getProductByName(String name) {
        return repo.findByNameContainingIgnoreCase(name);
    }

    public void deleteProductById(int id) {
        repo.deleteById(id);
    }
}