package com.api.crud.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.crud.services.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.api.crud.entities.Product;


@RestController
@RequestMapping(value = "/products")
public class ProductController {
    
    @Autowired
    private ProductService service;
    
    @GetMapping
    public ResponseEntity<List<Product>> index() {
        List<Product> result = service.findAll();

        return ResponseEntity.ok().body(result);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> show(@PathVariable Long id){
        Product result = service.findById(id);

        return ResponseEntity.ok().body(result);
    }

    @PostMapping
    public ResponseEntity<Long> store(@RequestBody Product product){
        Long result = service.create(product);

        return ResponseEntity.created(null).body(result);
    }
    

}
