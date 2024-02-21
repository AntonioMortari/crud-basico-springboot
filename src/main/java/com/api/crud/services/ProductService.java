package com.api.crud.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.crud.entities.Product;
import com.api.crud.exceptions.NotFoundException;
import com.api.crud.repositories.ProductRepository;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepository repository;

    public List<Product> findAll(){
        return repository.findAll();
    }

    public Product findById(Long id){
        Product product = repository.findById(id).orElseThrow(() ->  new NotFoundException("Product not found"));

        return product;
    }

    public Long create(Product product){
        Product result = repository.save(product);

        return result.getId();
    }

    public void update(Long id, Product obj){
        if(!repository.existsById(id)){
            throw new NotFoundException("Product not found");
        }

        Product entity = repository.getReferenceById(id);
        this.updateData(entity, obj);
        repository.save(entity);
    }

    private void updateData(Product entity, Product obj){
        if(obj.getName() != null){
            entity.setName(obj.getName());
        }
        if(obj.getPrice() != null){
            entity.setPrice(obj.getPrice());
        }
        if(obj.getQuantity() != null){
            entity.setQuantity(obj.getQuantity());
        }
        if(obj.getDescription() != null){
            entity.setDescription(obj.getDescription());
        }
    }

    public void delete(Long id){
        if(!repository.existsById(id)){
            throw new NotFoundException("Product not found");
        }

        repository.deleteById(id);
    }

}
