package com.ecomarket.ecomarket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecomarket.ecomarket.model.Envio;
import com.ecomarket.ecomarket.repository.EnvioRepository;

@Service
public class EnvioService {
    @Autowired
    private EnvioRepository envioRepository;

    public List<Envio> getEnvios(){
        return envioRepository.obtenerEnvios();
    }

    public Envio saveEnvio(Envio envio) {
        return envioRepository.guardar(envio);
    }

    public Envio getEnvioId(int id){
        return envioRepository.buscarPorId(id);
    }

    public Envio updateEnvio(Envio envio){
        return envioRepository.actualizar(envio);
    }
}
