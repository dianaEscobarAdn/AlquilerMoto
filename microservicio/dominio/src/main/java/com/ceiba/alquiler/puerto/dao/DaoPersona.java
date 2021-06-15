package com.ceiba.alquiler.puerto.dao;

import com.ceiba.alquiler.modelo.dto.DtoPersona;
import java.util.List;

public interface DaoPersona {

    List<DtoPersona> consultarPersonas();
}
