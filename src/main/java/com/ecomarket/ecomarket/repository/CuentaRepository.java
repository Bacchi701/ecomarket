package com.ecomarket.ecomarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecomarket.ecomarket.model.Cuenta;

@Repository
public interface CuentaRepository extends JpaRepository<Cuenta, Long>{
    
}