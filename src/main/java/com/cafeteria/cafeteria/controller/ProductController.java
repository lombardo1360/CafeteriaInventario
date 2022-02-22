package com.cafeteria.cafeteria.controller;

import com.cafeteria.cafeteria.models.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.cafeteria.cafeteria.service.ProductService;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.nio.charset.StandardCharsets;

@Controller
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping({"/productos", "/"})
    public String listarProductos(Model model){
        model.addAttribute("productos", service.listarProductos());
        return "productos";
    }

    @GetMapping("/productos/nuevo")
    public String mostrarFormulario(Model model){
        Products product = new Products();
        model.addAttribute("producto", product);
        return "crearProducto";
    }

    @PostMapping("/productos")
    public  String guardarProducto(@ModelAttribute("producto") Products product){
        service.guardarProducto(product);
        return "redirect:/productos";
    }

    @GetMapping("/productos/editar/{id}")
    public String mostrarFormEditar(@PathVariable Long id, Model model){
        model.addAttribute("producto", service.obtenerProductoId(id));
        return "editarProducto";
    }

    @PostMapping("/productos/{id}")
    public String actualizarProducto(@PathVariable Long id, @ModelAttribute("producto") Products product, Model model){
        Products existenciaProducto = service.obtenerProductoId(id);
        existenciaProducto.setId(id);
        existenciaProducto.setNombre(product.getNombre());
        existenciaProducto.setReferencia(product.getReferencia());
        existenciaProducto.setPrecio(product.getPrecio());
        existenciaProducto.setPeso(product.getPeso());
        existenciaProducto.setCategoria(product.getCategoria());
        existenciaProducto.setStock(product.getStock());

        service.actualizarProducto(existenciaProducto);
        return "redirect:/productos";
    }

    @GetMapping("/productos/{id}")
    public String eliminarProducto(@PathVariable Long id){
        service.eliminarProducto(id);
        return "redirect:/productos";
    }

}
