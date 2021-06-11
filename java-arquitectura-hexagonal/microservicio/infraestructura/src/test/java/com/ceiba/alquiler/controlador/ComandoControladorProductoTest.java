package com.ceiba.alquiler.controlador;

import com.ceiba.alquiler.ApplicationMock;
import com.ceiba.alquiler.comando.ComandoProducto;
import com.ceiba.alquiler.controladores.ComandoControladorProducto;
import com.ceiba.alquiler.testdatabuilder.ComandoProductoTestDataBuilder;
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
@WebMvcTest(ComandoControladorProducto.class)
public class ComandoControladorProductoTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Test
    public void crearProductoCorrectamente() throws Exception {
        // arrange
        ComandoProducto producto = new ComandoProductoTestDataBuilder().build();

        // act - assert
        mocMvc.perform(post("/producto")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(producto))
                .characterEncoding("utf-8")
        ).andExpect(status().isOk()).andExpect(content().json("{'respuesta': 'Se ha creado el producto correctamente, con código: 12345, Descripción: Moto, Unidades: 20'}"));
    }

    @org.junit.jupiter.api.Test
    public void crearProductoConUnidadesComprometidasMayorALasUnidadesDisponibles() throws Exception {

        ComandoProducto producto = new ComandoProductoTestDataBuilder().build();

        // act - assert new crearProductoTest("123", "Moto", 10,11)
        mocMvc.perform(post("/producto")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(producto))
                .characterEncoding("utf-8")
        ).andExpect(status().isOk()).andExpect(content().json("{'respuesta': 'Error: Las unidades comprometidas no puede ser mayor a las unidades disponibles'}"));
    }
}
