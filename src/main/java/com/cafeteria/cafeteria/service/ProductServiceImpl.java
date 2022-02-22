package com.cafeteria.cafeteria.service;

import com.cafeteria.cafeteria.models.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cafeteria.cafeteria.repository.ProductRepository;

import java.util.List;


@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repository;


    @Override
    public List<Products> listarProductos() {
        return repository.findAll();
    }

    @Override
    public Products guardarProducto(Products products) {
        return repository.save(products);
    }

    @Override
    public Products obtenerProductoId(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public Products actualizarProducto(Products product) {
        return repository.save(product);
    }

    @Override
    public void eliminarProducto(Long id) {
        repository.deleteById(id);
    }
}
