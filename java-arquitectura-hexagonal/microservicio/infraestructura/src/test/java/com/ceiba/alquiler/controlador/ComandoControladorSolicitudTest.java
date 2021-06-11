package com.ceiba.alquiler.controlador;

import com.ceiba.alquiler.ApplicationMock;
import com.ceiba.alquiler.comando.ComandoSolicitud;
import com.ceiba.alquiler.controladores.ComandoControladorSolicitud;
import com.ceiba.alquiler.testdatabuilder.ComandoSolicitudTestDataBuilder;
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
@WebMvcTest(ComandoControladorSolicitud.class)
public class ComandoControladorSolicitudTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Test
    public void crearSolicitudCorrectamente() throws Exception {
        // arrange
        ComandoSolicitud solicitud = new ComandoSolicitudTestDataBuilder().build();

        // act - assert
        mocMvc.perform(post("/solicitud")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(solicitud))
                .characterEncoding("utf-8")
        ).andExpect(status().isOk()).andExpect(content().json("{'respuesta': 'Se ha creado la solicitud correctamente - fecha devolucion: 2021-06-21, valor de la solicitud: 175000.0, valor del deposito: 35000.0'}"));
    }

    @Test
    public void crearSolicitudProductoNoExisteONoCuentaConCantidades() throws Exception {
        // arrange
        ComandoSolicitud solicitud = new ComandoSolicitudTestDataBuilder().build();

        // act - assert new crearSolicitudTest(1000, 1, fechaSolicitudParseada,7
        mocMvc.perform(post("/solicitud")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(solicitud))
                .characterEncoding("utf-8")
        ).andExpect(status().isOk()).andExpect(content().json("{'respuesta': 'El producto no cuenta con cantidades disponible'}"));
    }

    @Test
    public void crearSolicitudConRangoDeSolicitudPorFueraDelDefinido() throws Exception {
        // arrange
        ComandoSolicitud solicitud = new ComandoSolicitudTestDataBuilder().build();

        // act - assert new crearSolicitudTest(1, 1, fechaSolicitudParseada,7)
        mocMvc.perform(post("/solicitud")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(solicitud))
                .characterEncoding("utf-8")
        ).andExpect(status().isOk()).andExpect(content().json("{'respuesta': 'La solicitud se debe hacer con minímo uno  y maximo tres días de anticipación'}"));
    }

    @Test
    public void crearSolicitudConDiasDeAlquilerEnUnRangoPorFueraDelPermitido() throws Exception {
        // arrange
        ComandoSolicitud solicitud = new ComandoSolicitudTestDataBuilder().build();

        // act - assert new crearSolicitudTest(1, 1, fechaSolicitudParseada,10)
        mocMvc.perform(post("/solicitud")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(solicitud))
                .characterEncoding("utf-8")
        ).andExpect(status().isOk()).andExpect(content().json("{'respuesta': 'Los días de alquiler es de 3 a 7'}"));
    }

}
