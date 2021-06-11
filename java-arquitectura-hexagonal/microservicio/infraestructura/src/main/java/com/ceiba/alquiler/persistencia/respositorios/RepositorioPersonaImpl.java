package com.ceiba.alquiler.persistencia.respositorios;

import com.ceiba.alquiler.modelo.entidad.Persona;
import com.ceiba.alquiler.persistencia.dao.DaoPersonaH2;
import com.ceiba.alquiler.persistencia.entidades.EntidadPersona;
import com.ceiba.alquiler.puerto.repositorio.RepositorioPersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositorioPersonaImpl implements RepositorioPersona {

    @Autowired
    private DaoPersonaH2 daoPersonaH2;

    private List<Persona> listPersona;

    @Override
    public Integer crear(Persona persona) {
        return this.daoPersonaH2.save(new EntidadPersona(
                persona.getCedula(),
                persona.getNombre(),
                persona.getApellido(),
                persona.getTelefono(),
                persona.getDireccion()
        )).getCedula();
    }
}
