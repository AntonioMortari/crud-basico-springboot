package com.api.crud.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.crud.entities.Category;
import com.api.crud.exceptions.NotFoundException;
import com.api.crud.repositories.CategoryRepository;

@Service
public class CategoryService {
    
    @Autowired
    private CategoryRepository repository;

    public List<Category> findAll(){
        return repository.findAll();
    }

    public Long create(Category category){
        Category result = repository.save(category);

        return result.getId();
    }

    public void update(Long id, Category obj){
        if(!repository.existsById(id)){
            throw new NotFoundException("Category not found");
        }

        Category entity = repository.getReferenceById(id);
        this.updateData(entity, obj);
        repository.save(entity);
    }

    private void updateData(Category entity, Category obj){
        entity.setName(obj.getName());
    }

    public void delete(Long id){
        if(!repository.existsById(id)){
            throw new NotFoundException("Category not found");
        }

        repository.deleteById(id);
    }

}
