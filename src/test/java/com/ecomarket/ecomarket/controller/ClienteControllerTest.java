package com.ecomarket.ecomarket.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import com.ecomarket.ecomarket.model.Cliente;
import com.ecomarket.ecomarket.service.ClienteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List; 

@WebMvcTest(ClienteControllerTest.class) // Indica que se está probando el controlador de Cliente
public class ClienteControllerTest {
    
    @Autowired
    private MockMvc mockMvc;
    
    @MockBean
    private ClienteService clienteService;

    @Autowired
    private ObjectMapper objectMapper; // Se usa para convertir objetos Java a JSON y viceversa

    private Cliente cliente;

    @BeforeEach //Generar cliente: id, run, nombre, apellido, correo, direccion
    void setUp() {
        // Configura un objeto Cliente de ejemplo antes de cada prueba
        cliente = new Cliente();
        cliente.setId(1);
        cliente.setRun("12345678-9");
        cliente.setNombre("Juan");
        cliente.setApellido("Pérez");
        cliente.setCorreo("juanperez123@gmail.com");
        cliente.setDireccionEnvio("Carlos Matte 1059, La Pintana");
    }

    @Test
    public void testGetAllClientes() throws Exception {
        // Define el comportamiento del mock: cuando se llame a findAll(), devuelve una lista con un Cliente
        when(clienteService.findAll()).thenReturn(List.of(cliente));

        mockMvc.perform(get("/api/cliente"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1)) // Verifica que el primer elemento tenga id 1
                .andExpect(jsonPath("$[0].run").value("12345678-9")) // Verifica que el primer elemento tenga el run "12345678-9"
                .andExpect(jsonPath("$[0].nombre").value("Juan")) // Verifica que el primer elemento tenga el nombre "Juan"
                .andExpect(jsonPath("$[0].apellido").value("Pérez")) // Verifica que el primer elemento tenga el apellido "Pérez"
                .andExpect(jsonPath("$[0].correo").value("juanperez123@gmail.com"))// Verifica que el primer elemento tenga el correo "juanperez123@gmail.com"
                .andExpect(jsonPath("$[0].direccionEnvio").value("Carlos Matte 1059, La Pintana"));// Verifica que el primer elemento tenga la direccion de envio "Carlos Matte 1059, La Pintana"
    }

    @Test
    public void testGetClienteById() throws Exception {
        // Define el comportamiento del mock: cuando se llame a findById() con 1, devuelve el objeto Clientes
        when(clienteService.findById(1)).thenReturn(cliente);

        // Realiza una petición GET a /api/clientes/1 y verifica que la respuesta sea correcta
        mockMvc.perform(get("/api/cliente/1"))
                .andExpect(status().isOk()) // Verifica que el estado de la respuesta sea 200 OK
                .andExpect(jsonPath("$.id").value(1)) // Verifica que el id del objeto devuelto sea 1
                .andExpect(jsonPath("$.run").value("12345678-9")) // Verifica que el run del objeto devuelto sea "12345678-9"
                .andExpect(jsonPath("$.nombre").value("Juan")) // Verifica que el nombre del objeto devuelto sea "Juan"
                .andExpect(jsonPath("$[0].apellido").value("Pérez")) // Verifica que el apellido del objeto devuelto sea"Pérez"
                .andExpect(jsonPath("$[0].correo").value("juanperez123@gmail.com"))// Verifica que el correo del objeto devuelto sea "juanperez123@gmail.com"
                .andExpect(jsonPath("$[0].direccionEnvio").value("Carlos Matte 1059, La Pintana"));// Verifica que la direccion de envio del objeto devuelto sea "Carlos Matte 1059, La Pintana"
    }

    @Test
    public void testCreateCliente() throws Exception {
        // Define el comportamiento del mock: cuando se llame a save(), devuelve el objeto Cliente
        when(clienteService.save(any(Cliente.class))).thenReturn(cliente);

        // Realiza una petición POST a /api/cliente con el objeto Cliente en formato JSON y verifica que la respuesta sea correcta
        mockMvc.perform(post("/api/cliente}")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(cliente))) // Convierte el objeto Cliente a JSON
                .andExpect(status().isOk()) // Verifica que el estado de la respuesta sea 200 OK
                .andExpect(jsonPath("$.id").value(1)) // Verifica que el id del objeto devuelto sea 1
                .andExpect(jsonPath("$.run").value("12345678-9")) // Verifica que el run del objeto devuelto sea "12345678-9"
                .andExpect(jsonPath("$.nombre").value("Juan")) // Verifica que el nombre del objeto devuelto sea "Juan"
                .andExpect(jsonPath("$[0].apellido").value("Pérez")) // Verifica que el apellido del objeto devuelto sea"Pérez"
                .andExpect(jsonPath("$[0].correo").value("juanperez123@gmail.com"))// Verifica que el correo del objeto devuelto sea "juanperez123@gmail.com"
                .andExpect(jsonPath("$[0].direccionEnvio").value("Carlos Matte 1059, La Pintana"));// Verifica que la direccion de envio del objeto devuelto sea "Carlos Matte 1059, La Pintana"

    }

    @Test
    public void testUpdateCliente() throws Exception {
        // Define el comportamiento del mock: cuando se llame a save(), devuelve el objeto Cliente
        when(clienteService.save(any(Cliente.class))).thenReturn(cliente);

        // Realiza una petición PUT a /api/cliente/1 con el objeto Cliente en formato JSON y verifica que la respuesta sea correcta
        mockMvc.perform(put("/api/cliente/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(cliente))) // Convierte el objeto Cliente a JSON
                .andExpect(status().isOk()) // Verifica que el estado de la respuesta sea 200 OK
                .andExpect(jsonPath("$.id").value(1)) // Verifica que el id del objeto devuelto sea 1
                .andExpect(jsonPath("$.run").value("12345678-9")) // Verifica que el run del objeto devuelto sea "12345678-9"
                .andExpect(jsonPath("$.nombres").value("Juan Pérez")) // Verifica que el nombre del objeto devuelto sea "Juan"
                .andExpect(jsonPath("$[0].apellido").value("Pérez")) // Verifica que el apellido del objeto devuelto sea"Pérez"
                .andExpect(jsonPath("$[0].correo").value("juanperez123@gmail.com"))// Verifica que el correo del objeto devuelto sea "juanperez123@gmail.com"
                .andExpect(jsonPath("$[0].direccionEnvio").value("Carlos Matte 1059, La Pintana"));// Verifica que la direccion de envio del objeto devuelto sea "Carlos Matte 1059, La Pintana"
    }

    /**
    @Test
    public void testDeleteCliente() throws Exception {
        // Define el comportamiento del mock: cuando se llame a deleteById(), no hace nada
        doNothing().when(clienteService).deleteById(1);

        // Realiza una petición DELETE a /api/cliente/1 y verifica que la respuesta sea correcta
        mockMvc.perform(delete("/api/cliente/1"))
                .andExpect(status().isOk()); // Verifica que el estado de la respuesta sea 200 OK

        // Verifica que el método deleteById() del servicio se haya llamado exactamente una vez con el id 1
        verify(clienteService, times(1)).deleteById(1);
    } 
    */
}
