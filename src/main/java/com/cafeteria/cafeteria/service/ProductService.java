package com.cafeteria.cafeteria.service;

import com.cafeteria.cafeteria.models.Products;

import java.util.List;

public interface ProductService {

    public List<Products> listarProductos();

    public Products guardarProducto(Products products);

    public Products obtenerProductoId(Long id);

    public Products actualizarProducto(Products product);

    public void eliminarProducto(Long id);
}
