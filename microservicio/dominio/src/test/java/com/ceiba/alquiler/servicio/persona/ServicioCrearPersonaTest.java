package com.ceiba.alquiler.servicio.persona;

import com.ceiba.alquiler.BasePrueba;
import com.ceiba.alquiler.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.alquiler.modelo.dto.DtoPersona;
import com.ceiba.alquiler.modelo.dto.DtoRespuestaPersona;
import com.ceiba.alquiler.modelo.entidad.Persona;
import com.ceiba.alquiler.modelo.entidad.Producto;
import com.ceiba.alquiler.puerto.repositorio.RepositorioPersona;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServicioCrearPersonaTest {

    Persona persona;

    public ServicioCrearPersonaTest() {
        this.persona = new Persona(null,123, "Diana", "Escobar", 123, "Calle 10");
    }

    @Test
    public void crearPersonaCorrectamenteTest() {
        //Configuracion para el Test
        RepositorioPersona repositorioPersona = Mockito.mock(RepositorioPersona.class);
        Mockito.when(repositorioPersona.crear(this.persona)).thenReturn(1);

        Mockito.when(repositorioPersona.buscarPersonaPorId(1)).thenReturn(new Persona(
                1,
                123,
                "Diana",
                "Escobar",
                123,
                "Calle 10"
        ));

        //Ejecuccion del Test
        DtoRespuestaPersona respuesta = new ServicioCrearPersona(repositorioPersona).ejecutar(this.persona);
        //Validacion del Test
        assertEquals(1, respuesta.getIdPersona().intValue());
    }

   @Test
    public void crearDtoPersona() {
        DtoPersona persona = new DtoPersona (
                1,
                123,
                "Prueba",
                "DTO",
                22222,
                "calle 10"
        );
        assertEquals(1, persona.getIdPersona().intValue());
        assertEquals(123, persona.getCedula());
        assertEquals("Prueba", persona.getNombre());
        assertEquals("DTO", persona.getApellido());
        assertEquals(22222, persona.getTelefono());
        assertEquals("calle 10", persona.getDireccion());
    }

    @Test
    public void crearDtoRespuestaPersona() {
        DtoRespuestaPersona persona = new DtoRespuestaPersona (
                1,
                123,
                "Prueba",
                "DTO",
                22222,
                "calle 10"
        );
        assertEquals(1, persona.getIdPersona().intValue());
        assertEquals(123, persona.getCedula());
        assertEquals("Prueba", persona.getNombre());
        assertEquals("DTO", persona.getApellido());
        assertEquals(22222, persona.getTelefono());
        assertEquals("calle 10", persona.getDireccion());
    }

    @Test
    public void CampoObligatorioTest() {

        BasePrueba.assertThrows(() -> new Persona(
                1,
                123,
                null,
                "DTO",
                22222,
                "calle 10"
        ), ExcepcionValorObligatorio.class,"Se debe ingresar el nombre de creación");
    }

}