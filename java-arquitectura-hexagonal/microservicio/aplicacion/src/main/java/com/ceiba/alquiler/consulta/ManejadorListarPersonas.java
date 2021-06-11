package com.ceiba.alquiler.consulta;

import com.ceiba.alquiler.ComandoRespuesta;
import com.ceiba.alquiler.comando.ComandoPersona;
import com.ceiba.alquiler.modelo.dto.DtoPersona;
import com.ceiba.alquiler.puerto.dao.DaoPersona;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ManejadorListarPersonas {

    private final DaoPersona daoPersona;

    public ManejadorListarPersonas(DaoPersona daoPersona) {
        this.daoPersona = daoPersona;
    }

    public ComandoRespuesta<List<ComandoPersona>> ejecutar() {
        List<ComandoPersona> comandoPersonaList = new ArrayList<>();

        this.daoPersona.consultarPersonas().stream().forEach(persona -> {
            comandoPersonaList.add(new ComandoPersona(
                    persona.getIdPersona(),
                    persona.getCedula(),
                    persona.getNombre(),
                    persona.getApellido(),
                    persona.getTelefono(),
                    persona.getDireccion()
            ));
        });
        return new ComandoRespuesta<>(comandoPersonaList);
    }
}
