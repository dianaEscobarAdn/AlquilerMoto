package com.ceiba.alquiler.consulta;

import com.ceiba.alquiler.modelo.dto.DtoPersona;
import com.ceiba.alquiler.puerto.dao.DaoPersona;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarPersonas {

    private final DaoPersona daoPersona;

    public ManejadorListarPersonas(DaoPersona daoPersona) {
        this.daoPersona = daoPersona;
    }

    public List<DtoPersona> ejecutar(){return this.daoPersona.consultarPersonas();}
}