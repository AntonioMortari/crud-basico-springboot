package com.api.crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.crud.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
