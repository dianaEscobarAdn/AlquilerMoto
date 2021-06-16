package com.ceiba.alquiler.servicio.persona;

import com.ceiba.alquiler.dominio.ValidadorArgumento;
import com.ceiba.alquiler.modelo.dto.DtoRespuestaPersona;
import com.ceiba.alquiler.modelo.entidad.Persona;
import com.ceiba.alquiler.puerto.repositorio.RepositorioPersona;

public class ServicioCrearPersona {

    public static final String ERROR_NO_ENCONTRO_LA_PERSONA_CREADA = "Error: no encontro la persona creada";

    private final RepositorioPersona repositorioPersona;

    public ServicioCrearPersona(RepositorioPersona repositorioPersona) {
        this.repositorioPersona = repositorioPersona;
    }

    public DtoRespuestaPersona ejecutar(Persona persona) {
        Integer idPersona = this.repositorioPersona.crear(persona);
        Persona personaCreada = this.repositorioPersona.buscarPersonaPorId(idPersona);
        ValidadorArgumento.validarObligatorio(personaCreada, ERROR_NO_ENCONTRO_LA_PERSONA_CREADA);
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