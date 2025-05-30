package com.ecomarket.ecomarket.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tienda {
    private int id;
    private int stock;
    private String personal;
    private String horarioApertura;
    private String reportes;

    
}
