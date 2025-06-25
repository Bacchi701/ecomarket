package com.ecomarket.ecomarket.controller;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.ecomarket.ecomarket.model.Cuenta;
import com.ecomarket.ecomarket.service.CuentaService;

@WebMvcTest(CuentaControllerTest.class) // Indica que se está probando el controlador de Cuenta
public class CuentaControllerTest {
    
    @Autowired
    private MockMvc mockMvc;
    
    @MockBean
    private CuentaService cuentaService;

    @Autowired
    private ObjectMapper objectMapper; // Se usa para convertir objetos Java a JSON y viceversa

    private Cuenta cuenta;

    @BeforeEach // id, usuario, password, rol
    void setUp() {
        // Configura un objeto Cuenta de ejemplo antes de cada prueba
        cuenta = new Cuenta();
        cuenta.setId(1);
        cuenta.setUsuario("JuanGamer");
        cuenta.setPassword("987654321");
        cuenta.setRol("cliente");
    }

    @Test
    public void testGetAllCuentas() throws Exception {
        // Define el comportamiento del mock: cuando se llame a findAll(), devuelve una lista con un Cuenta
        when(cuentaService.findAll()).thenReturn(List.of(cuenta));

        mockMvc.perform(get("/api/cuenta"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1)) // Verifica que el primer elemento tenga id 1
                .andExpect(jsonPath("$[0].usuario").value("JuanGamer")) // Verifica que el primer elemento tenga el nombre "Juan"
                .andExpect(jsonPath("$[0].password").value("987654321")) // Verifica que el primer elemento tenga la contraseña "987654321"
                .andExpect(jsonPath("$[0].rol").value("cliente"));// Verifica que el primer elemento tenga el correo "cliente"
    }

    @Test
    public void testGetCuentaById() throws Exception {
        // Define el comportamiento del mock: cuando se llame a findById() con 1, devuelve el objeto Cuentas
        when(cuentaService.findById(1)).thenReturn(cuenta);

        // Realiza una petición GET a /api/cuentas/1 y verifica que la respuesta sea correcta
        mockMvc.perform(get("/api/cuenta/1"))
                .andExpect(status().isOk()) // Verifica que el estado de la respuesta sea 200 OK
                .andExpect(jsonPath("$.id").value(1)) // Verifica que el id del objeto devuelto sea 1
                .andExpect(jsonPath("$.usuario").value("JuanGamer")) // Verifica que el usuario del objeto devuelto sea "Juan"
                .andExpect(jsonPath("$[0].password").value("987654321")) // Verifica que el contraseña del objeto devuelto sea "987654321"
                .andExpect(jsonPath("$[0].rol").value("cliente"));// Verifica que el rol del objeto devuelto sea "cliente"
    }

    @Test
    public void testCreateCuenta() throws Exception {
        // Define el comportamiento del mock: cuando se llame a save(), devuelve el objeto Cuenta
        when(cuentaService.save(any(Cuenta.class))).thenReturn(cuenta);

        // Realiza una petición POST a /api/cuenta con el objeto Cuenta en formato JSON y verifica que la respuesta sea correcta
        mockMvc.perform(post("/api/cuenta}")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(cuenta))) // Convierte el objeto Cuenta a JSON
                .andExpect(status().isOk()) // Verifica que el estado de la respuesta sea 200 OK
                .andExpect(jsonPath("$.id").value(1)) // Verifica que el id del objeto devuelto sea 1
                .andExpect(jsonPath("$.usuario").value("JuanGamer")) // Verifica que el nombre del objeto devuelto sea "Juan"
                .andExpect(jsonPath("$[0].password").value("987654321")) // Verifica que el contraseña del objeto devuelto sea"987654321"
                .andExpect(jsonPath("$[0].rol").value("cliente"));// Verifica que el correo del objeto devuelto sea "cliente"

    }

    @Test
    public void testUpdateCuenta() throws Exception {
        // Define el comportamiento del mock: cuando se llame a save(), devuelve el objeto Cuenta
        when(cuentaService.save(any(Cuenta.class))).thenReturn(cuenta);

        // Realiza una petición PUT a /api/cuenta/1 con el objeto Cuenta en formato JSON y verifica que la respuesta sea correcta
        mockMvc.perform(put("/api/cuenta/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(cuenta))) // Convierte el objeto Cuenta a JSON
                .andExpect(status().isOk()) // Verifica que el estado de la respuesta sea 200 OK
                .andExpect(jsonPath("$.id").value(1)) // Verifica que el id del objeto devuelto sea 1
                .andExpect(jsonPath("$.usuario").value("JuanGamer")) // Verifica que el nombre del objeto devuelto sea "Juan"
                .andExpect(jsonPath("$[0].password").value("987654321")) // Verifica que la password del objeto devuelto sea"987654321"
                .andExpect(jsonPath("$[0].rol").value("cliente"));// Verifica que el rol del objeto devuelto sea "cliente"
    }

    /** 
    @Test
    public void testDeleteCuenta() throws Exception {
        // Define el comportamiento del mock: cuando se llame a deleteById(), no hace nada
        doNothing().when(cuentaService).deleteById(1);

        // Realiza una petición DELETE a /api/cuenta/1 y verifica que la respuesta sea correcta
        mockMvc.perform(delete("/api/cuenta/1"))
                .andExpect(status().isOk()); // Verifica que el estado de la respuesta sea 200 OK

        // Verifica que el método deleteById() del servicio se haya llamado exactamente una vez con el id 1
        verify(cuentaService, times(1)).deleteById(1);
    }
    */
}
