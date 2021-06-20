package com.ceiba.alquiler.servicio.persona;

import com.ceiba.alquiler.dominio.ValidadorArgumento;
import com.ceiba.alquiler.modelo.dto.DtoRespuestaPersona;
import com.ceiba.alquiler.modelo.entidad.Persona;
import com.ceiba.alquiler.puerto.repositorio.RepositorioPersona;

public class ServicioRegistrarPersona {

    private final RepositorioPersona repositorioPersona;

    public ServicioRegistrarPersona(RepositorioPersona repositorioPersona) {
        this.repositorioPersona = repositorioPersona;
    }

    public DtoRespuestaPersona ejecutar(Persona persona) {
        Integer idPersona = this.repositorioPersona.crear(persona);
        Persona personaCreada = this.repositorioPersona.buscarPersonaPorId(idPersona);
        return convertirADtoRespuesta(personaCreada);
    }

    public DtoRespuestaPersona convertirADtoRespuesta(Persona personaCreada) {
        return new DtoRespuestaPersona(
                personaCreada.getIdPersona(),
                personaCreada.getCedula(),
                personaCreada.getNombre(),
                personaCreada.getApellido(),
                personaCreada.getTelefono(),
                personaCreada.getDireccion()
        );
    }
}