package com.cafeteria.cafeteria.repository;

import com.cafeteria.cafeteria.models.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Products, Long>{
}
