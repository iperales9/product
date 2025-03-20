package com.example.product.controller;


import com.example.product.entities.Product;
import com.example.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/v1")
public class productApi {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        //Descartamos el id que envie el usaurio par que tome el de la sequencia definido en el entity
        product.setId(null);
        return productRepository.save(product);
    }

    @PutMapping("/{id}")
    public Product editProduct(@PathVariable Long id, @RequestBody Product product) {
        product.setId(id); // Asegura que el ID sea el correcto
        return productRepository.save(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productRepository.deleteById(id);
    }
}