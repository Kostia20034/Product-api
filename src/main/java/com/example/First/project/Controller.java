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
        Product p = service.getProduct(id);
        if (p != null) {
            return ResponseEntity.ok(p);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> list = service.getAllProducts();
        if (!list.isEmpty()) {
            return ResponseEntity.ok(list);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Product> createNewProduct(@RequestBody Product p) {
        if (p.getName() == null || p.getPrice() == 0) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createProject(p));
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable int id, @RequestBody Product p) {
        if (service.getProduct(id) == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(service.updateProduct(id, p));
    }

    @GetMapping("/product")
    public ResponseEntity<List<Product>> getProductByName(@RequestParam String name) {
        List<Product> list = service.getProductByName(name);
        if (list.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(list);
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<Void> deleteProductById(@PathVariable int id) {
        if (service.getProduct(id) == null) {
            return ResponseEntity.notFound().build();
        }
        service.deleteProductById(id);
        return ResponseEntity.ok().build();
    }
}
