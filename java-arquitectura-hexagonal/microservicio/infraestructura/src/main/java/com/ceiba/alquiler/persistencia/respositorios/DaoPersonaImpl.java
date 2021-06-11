package com.ceiba.alquiler.persistencia.respositorios;

import com.ceiba.alquiler.modelo.entidad.Persona;
import com.ceiba.alquiler.persistencia.dao.DaoPersonaH2;
import com.ceiba.alquiler.persistencia.entidades.EntidadPersona;
import com.ceiba.alquiler.puerto.dao.DaoPersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DaoPersonaImpl implements DaoPersona {
    @Autowired
    private DaoPersonaH2 daoPersonaH2;

    private List<Persona> listPersona;

    @Override
    public List<Persona> consultarPersonas() {
        listPersona = new ArrayList<>();
        this.daoPersonaH2.findAll().forEach(persona -> {
            this.listPersona.add(
                    new Persona(
                            persona.getIdPersona(),
                            persona.getCedula(),
                            persona.getNombre(),
                            persona.getApellido(),
                            persona.getTelefono(),
                            persona.getDireccion()
                    )
            );
        });
        return this.listPersona;
    }

    @Override
    public Persona consultarPersona(Integer id) {
        Persona persona = null;
        EntidadPersona PersonaBuscada = this.daoPersonaH2.findById(id).orElse(null);
        if (PersonaBuscada != null) {
            persona = new Persona(
                    PersonaBuscada.getIdPersona(),
                    PersonaBuscada.getCedula(),
                    PersonaBuscada.getNombre(),
                    PersonaBuscada.getApellido(),
                    PersonaBuscada.getTelefono(),
                    PersonaBuscada.getDireccion()
            );
        }
        return persona;
    }

}
