package com.ceiba.alquiler.servicio;

import com.ceiba.alquiler.modelo.entidad.Persona;
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
        //Ejecuccion del Test
        String respuesta = new ServicioCrearPersona(repositorioPersona).ejecutar(this.persona);
        //Validacion del Test
        assertEquals("Se ha creado la persona con cedula: 1", respuesta);
    }
}