package com.ceiba.alquiler.persona.controlador;

import com.ceiba.alquiler.ApplicationMock;
import com.ceiba.alquiler.comando.ComandoPersona;
import com.ceiba.alquiler.persona.servicio.testdatabuilder.ComandoPersonaTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.jupiter.api.Order;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= ApplicationMock.class)
@WebMvcTest(ComandoControladorPersona.class)
public class ComandoControladorPersonaTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Test
    public void crear() throws Exception{
        // arrange
        ComandoPersona persona = new ComandoPersonaTestDataBuilder().build();

        // act - assert
        mocMvc.perform(post("/persona")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(persona)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'respuesta':{'idPersona':2,'cedula':103666253,'nombre':'Prueba','apellido':'Integracion','telefono':2222222,'direccion':'calle 10'}}"));
    }
}