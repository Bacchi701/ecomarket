package com.ecomarket.ecomarket.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ecomarket.ecomarket.model.Envio;


@Repository
public class EnvioRepository {

    private List<Envio> listaEnvios = new ArrayList<>();

    public List<Envio> obtenerEnvios(){
        return listaEnvios;
    }

    public Envio buscarPorId(int id){
        for (Envio envio : listaEnvios){
            if (envio.getId() == id){
                return envio;
            }
        }
        return null;
    }

    public Envio guardar(Envio env){
        listaEnvios.add(env);
        return env;
    }

    public Envio actualizar(Envio env){
        int id = 0;
        int idPosicion = 0;

        for (int i = 0; i < listaEnvios.size(); i++){
            if (listaEnvios.get(i).getId() == env.getId()){
                id = env.getId();
                idPosicion = i;
            }
        }

        Envio envio1 = new Envio();
        envio1.setId(id);
        envio1.setIdProducto(env.getIdProducto());
        envio1.setRunComprador(env.getRunComprador());
        envio1.setFechaCompra(env.getFechaCompra());
        envio1.setFechaEntrega(env.getFechaEntrega());

        listaEnvios.set(idPosicion, envio1);
        return envio1;
    }
}

