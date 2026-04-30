package com.example.First.project;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/home")
@CrossOrigin(origins = "*")
public class Controller {

    private final ProductService service;

    public Controller(ProductService service) {
        this.service = service;
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductC(@PathVariable int id) {
        return ResponseEntity.ok(service.getProduct(id));
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
            return ResponseEntity.ok(service.getAllProducts());

    }

    @PostMapping("/product")
    public ResponseEntity<Product> createNewProduct(@RequestBody Product p) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createProduct(p));
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable int id, @RequestBody Product p) {
        return ResponseEntity.status(HttpStatus.OK).body(service.updateProduct(id, p));
    }

    @GetMapping("/product")
    public ResponseEntity<List<Product>> getProductByName(@RequestParam String name) {
        return ResponseEntity.ok(service.getProductByName(name));
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<Void> deleteProductById(@PathVariable int id) {
        service.deleteProductById(id);
        return ResponseEntity.ok().build();
    }
}
