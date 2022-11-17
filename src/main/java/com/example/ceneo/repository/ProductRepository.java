package com.example.ceneo.repository;

import com.example.ceneo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> getProductByProductCode(String productCode);
    List<Product> getProductsByProductCategory(String productCategory);
}
