package com.ceiba.alquiler.persona.adaptador.dao;

import com.ceiba.alquiler.infraestructura.jdbc.MapperResult;
import com.ceiba.alquiler.modelo.dto.DtoPersona;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class MapeoPersona implements RowMapper<DtoPersona>, MapperResult {

    @Override
    public DtoPersona mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Integer idPersona = resultSet.getInt("idPersona");
        Integer cedula = resultSet.getInt("cedula");
        String nombre = resultSet.getString("nombre");
        String apellido = resultSet.getString("apellido");
        Integer telefono = resultSet.getInt("telefono");
        String direccion = resultSet.getString("direccion");

        return new DtoPersona(idPersona,cedula,nombre,apellido,telefono,direccion);
    }

}
