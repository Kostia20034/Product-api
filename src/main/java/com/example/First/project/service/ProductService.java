package com.example.First.project.service;

import com.example.First.project.dto.ProductRequestDTO;
import com.example.First.project.dto.ProductResponseDTO;
import com.example.First.project.exceptions.ProductNotFoundException;
import com.example.First.project.model.Product;
import com.example.First.project.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repo;

    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    public ProductResponseDTO getProduct(int id) {
        Product product = repo.findById(id).orElseThrow(() -> new ProductNotFoundException("Product not found"));
        return toResponseDTO(product);
    }

    public List<ProductResponseDTO> getAllProducts() {
        List<Product> products = repo.findAll();
        List<ProductResponseDTO> productResponseDTOS = new ArrayList<>();
        for(Product product : products){
            ProductResponseDTO responseDTO = toResponseDTO(product);
            productResponseDTOS.add(responseDTO);
        }
        return productResponseDTOS;
    }

    public ProductResponseDTO createProduct(ProductRequestDTO p) {
        Product product = new Product();
        product.setName(p.getName());
        product.setPrice(p.getPrice());
        Product saved = repo.save(product);
        return toResponseDTO(saved);
    }

    public ProductResponseDTO updateProduct(int id, ProductRequestDTO np) {
        Product existing = repo.findById(id).orElseThrow(() -> new ProductNotFoundException("Product not found"));
        existing.setName(np.getName());
        existing.setPrice(np.getPrice());
        Product saved = repo.save(existing);
        return toResponseDTO(saved);
    }

    public List<ProductResponseDTO> getProductByName(String name) {
        List<Product> products = repo.findByNameContainingIgnoreCase(name);
        List<ProductResponseDTO> productResponseDTOS = new ArrayList<>();
        for(Product product : products){
            ProductResponseDTO responseDTO = toResponseDTO(product);
            productResponseDTOS.add(responseDTO);
        }
        return productResponseDTOS;
    }

    public void deleteProductById(int id) {
        repo.findById(id).orElseThrow(() -> new ProductNotFoundException("Item not found"));
        repo.deleteById(id);
    }

    private ProductResponseDTO toResponseDTO(Product product) {
        ProductResponseDTO dto = new ProductResponseDTO();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setPrice(product.getPrice());
        return dto;
    }
}