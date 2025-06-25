package com.ecomarket.ecomarket.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Envio {

    private int id;
    private int idProducto;
    private String runComprador;
    private String fechaCompra;
    private String fechaEntrega;

} //id, idProducto, runComprador, fechaCompra, fechaEntrega
