package com.ecomarket.ecomarket.model;




import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

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

    @Size(min = 8, message= "La contraseña debe tener entres 8 a 15 caracteres")
    
    @Column(length = 15, nullable=false)
    private String password;

    @Column(nullable=false)
    private String rol;

}
