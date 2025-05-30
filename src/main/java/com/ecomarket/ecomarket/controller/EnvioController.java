package com.ecomarket.ecomarket.controller;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecomarket.ecomarket.model.Envio;
import com.ecomarket.ecomarket.service.EnvioService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/envíos")
public class EnvioController {

    @Autowired
    private EnvioService envioService;

    @GetMapping
    public List<Envio> listarEnvios() {
        return envioService.getEnvios();
    }

    @PostMapping
    public Envio agregarEnvios(@RequestBody Envio producto) {
        return envioService.saveEnvio(producto);
    }
    
    @GetMapping("{id}")
    public Envio buscarEnvio(@PathVariable int id) {
        return envioService.getEnvioId(id);
    }

    @PutMapping("{id}")
    public Envio actualizarEnvio(@PathVariable int id, @RequestBody Envio producto) {
        return envioService.updateEnvio(producto);
    }
}
