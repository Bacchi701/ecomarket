package com.ecomarket.ecomarket.model;

import jakarta.persistence.*;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name= "cuenta")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(unique=true, length = 13, nullable=false)
    private String usuario;


    
    @Column(length = 15, nullable=false)
    private String password;

    @Column(nullable=false)
    private String rol;

} // id, usuario, password, rol
