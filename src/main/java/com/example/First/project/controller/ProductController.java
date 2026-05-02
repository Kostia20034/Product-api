package com.example.First.project.controller;

import com.example.First.project.dto.ProductRequestDTO;
import com.example.First.project.dto.ProductResponseDTO;
import com.example.First.project.model.Product;
import com.example.First.project.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@CrossOrigin(origins = "*")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> getProductC(@PathVariable int id) {
        return ResponseEntity.ok(service.getProduct(id));
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> getAllProducts() {
            return ResponseEntity.ok(service.getAllProducts());

    }

    @PostMapping
    public ResponseEntity<ProductResponseDTO> createNewProduct(@Valid @RequestBody ProductRequestDTO p) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createProduct(p));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> updateProduct(@PathVariable int id, @Valid @RequestBody ProductRequestDTO p) {
        return ResponseEntity.status(HttpStatus.OK).body(service.updateProduct(id, p));
    }

    @GetMapping("/search")
    public ResponseEntity<List<ProductResponseDTO>> getProductByName(@RequestParam String name) {
        return ResponseEntity.ok(service.getProductByName(name));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductById(@PathVariable int id) {
        service.deleteProductById(id);
        return ResponseEntity.noContent().build();
    }
}
