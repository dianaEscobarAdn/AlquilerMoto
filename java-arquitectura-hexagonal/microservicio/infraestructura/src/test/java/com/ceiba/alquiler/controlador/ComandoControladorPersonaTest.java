package com.ceiba.alquiler.controlador;

import com.ceiba.alquiler.ApplicationMock;
import com.ceiba.alquiler.comando.ComandoPersona;
import com.ceiba.alquiler.controladores.ComandoControladorPersona;
import com.ceiba.alquiler.testdatabuilder.ComandoPersonaTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
    public void crearPersonaCorrectamente() throws Exception {
        // arrange
        ComandoPersona persona = new ComandoPersonaTestDataBuilder().build();

        // act - assert new crearPersonaTest(123, "Diana", "Escobar",2222222,"Calle 10")
        mocMvc.perform(post("/persona")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(persona))
                .characterEncoding("utf-8")
        ).andExpect(status().isOk()).andExpect(content().json("{'respuesta': 'Se ha creado la persona con cedula: 123'}"));
    }
}
