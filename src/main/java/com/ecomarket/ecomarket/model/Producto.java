package com.ecomarket.ecomarket.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Producto {

    private int id;
    private String nombre;
    private String descripcion;
    private int precio;
    private int cantidad;
    
} // id, nombre, descripcion, precio, cantidad
