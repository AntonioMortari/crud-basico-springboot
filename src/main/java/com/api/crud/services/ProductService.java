package com.api.crud.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.crud.entities.Product;
import com.api.crud.repositories.ProductRepository;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepository repository;

    public List<Product> findAll(){
        return repository.findAll();
    }

    public Optional<Product> findById(Long id){
        Optional<Product> product = repository.findById(id);

        return product;
    }

    public Long create(Product product){
        Product result = repository.save(product);

        return result.getId();
    }

}
