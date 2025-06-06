package com.ecomarket.ecomarket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecomarket.ecomarket.model.Cuenta;
import com.ecomarket.ecomarket.repository.CuentaRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CuentaService {

    @Autowired
    private CuentaRepository cuentaRepository;

    public List<Cuenta> findAll(){
        return cuentaRepository.findAll();
    }

    public Cuenta findById(long id){
        return cuentaRepository.findById(id).get();
    }

    public Cuenta save(Cuenta cuenta){
        return cuentaRepository.save(cuenta);
    }
    
    public void delete(Long id){
        cuentaRepository.deleteById(id);
    }
    
}
