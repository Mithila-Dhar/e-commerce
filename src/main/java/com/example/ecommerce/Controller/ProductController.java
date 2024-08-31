package com.example.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.ecommerce.model.Product;
import com.example.ecommerce.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService; // Correctly inject the ProductService

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product newProduct = productService.createProduct(product); // Use the productService correctly
        return ResponseEntity.status(HttpStatus.CREATED).body(newProduct);
    }

    @GetMapping("/getUsers")
    public ResponseEntity<List<Product>> getProducts() {
        List<Product> products = productService.getAllProducts(); // Use the productService correctly
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }

    @PutMapping("/updateUser/{id}")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product, @PathVariable Long id) {
        Product updatedProduct = productService.updateProduct(id, product); // Use the productService correctly
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(updatedProduct);
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id); // Use the productService correctly
        return ResponseEntity.noContent().build();
    }
}
