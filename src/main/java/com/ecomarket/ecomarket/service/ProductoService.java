package com.ecomarket.ecomarket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecomarket.ecomarket.model.Producto;
import com.ecomarket.ecomarket.repository.ProductoRepository;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> getProductos(){
        return productoRepository.obtenerProductos();
    }
    
    public Producto saveProducto(Producto producto){
        return productoRepository.guardar(producto);
    }

    public Producto getProductoId(int id){
        return productoRepository.buscarPorId(id);
    }

    public Producto updateProducto(Producto producto){
        return productoRepository.actualizar(producto);
    }
    
    public String deleteProducto(int id){
        productoRepository.eliminar(id);
        return "producto eliminado";
    }
}
