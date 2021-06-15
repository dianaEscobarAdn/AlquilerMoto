package com.ceiba.alquiler.comando.fabrica;

import com.ceiba.alquiler.comando.ComandoPersona;
import com.ceiba.alquiler.modelo.entidad.Persona;
import org.springframework.stereotype.Component;

@Component
public class FabricaPersona {

    public Persona crear(ComandoPersona comandoPersona) {
        return new Persona(
                comandoPersona.getIdPersona(),
                comandoPersona.getCedula(),
                comandoPersona.getNombre(),
                comandoPersona.getApellido(),
                comandoPersona.getTelefono(),
                comandoPersona.getDireccion()
        );
    }
}