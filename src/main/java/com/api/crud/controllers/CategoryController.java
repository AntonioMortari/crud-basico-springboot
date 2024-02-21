package com.api.crud.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.crud.entities.Category;
import com.api.crud.services.CategoryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {
    
    @Autowired
    private CategoryService service;

    @GetMapping
    public ResponseEntity<List<Category>> index(){
        List<Category> result = service.findAll();

        return ResponseEntity.ok().body(result);
    }

    @PostMapping
    public ResponseEntity<Long> store(@Valid @RequestBody Category category){
        Long result = service.create(category);

        return ResponseEntity.created(null).body(result);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> edit(@PathVariable Long id, @Valid @RequestBody Category obj){
        service.update(id, obj);    

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> destroy(@PathVariable Long id){
        service.delete(id);

        return ResponseEntity.noContent().build();
    }

}
