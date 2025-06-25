package com.ecomarket.ecomarket;

import com.ecomarket.ecomarket.model.*;
import com.ecomarket.ecomarket.repository.*;

import net.datafaker.Faker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;


@Profile("dev")
@Component
public class DataLoader implements CommandLineRunner{

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private CuentaRepository cuentaRepository;

    @Override
    public void run(String... args) throws Exception {
        Faker faker = new Faker();
        

        //Generar cliente: id, run, nombre, apellido, correo, direccion
        for (int i = 0; i < 50; i++){
            Cliente cliente = new Cliente();
            cliente.setId(i + 1);
            cliente.setRun(faker.idNumber().valid());
            cliente.setNombre(faker.name().firstName());
            cliente.setApellido(faker.name().lastName());
            cliente.setCorreo(faker.internet().emailAddress());
            cliente.setDireccionEnvio(faker.address().streetAddress());
            clienteRepository.save(cliente);
        }
        

        //generar cuenta: id, usuario, contraseña, rol
        for (int i = 0; i < 50; i++){
            Cuenta cuenta = new Cuenta();
            cuenta.setId(i + 1);
            cuenta.setUsuario(faker.name().firstName()); //Deprecated, no deja usar Internet.username()
            cuenta.setPassword(faker.idNumber().valid());    
            cuenta.setRol(faker.darkSouls().classes()); 
            cuentaRepository.save(cuenta);
        }

        

    }
    
}
