package com.ceiba.alquiler.producto.adaptador.dao;

import com.ceiba.alquiler.infraestructura.jdbc.MapperResult;
import com.ceiba.alquiler.modelo.dto.DtoProducto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoProducto implements RowMapper<DtoProducto>, MapperResult {

    @Override
    public DtoProducto mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Integer idProducto = resultSet.getInt("idProducto");
        String codigoProducto = resultSet.getString("codigoProducto");
        String descripcionProducto = resultSet.getString("descripcionProducto");
        Integer unidadesDisponibles = resultSet.getInt("unidadesDisponibles");
        Integer unidadesComprometidas = resultSet.getInt("unidadesComprometidas");

        return new DtoProducto(idProducto,codigoProducto,descripcionProducto,unidadesDisponibles,unidadesComprometidas);
    }

}
