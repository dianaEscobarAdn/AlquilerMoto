package com.ceiba.alquiler.solicitud.adaptador.dao;

import com.ceiba.alquiler.infraestructura.jdbc.MapperResult;
import com.ceiba.alquiler.modelo.dto.DtoSolicitud;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class MapeoSolicitud implements RowMapper<DtoSolicitud>, MapperResult {

    @Override
    public DtoSolicitud mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Integer idSolicitud = resultSet.getInt("idSolicitud");
        Integer idProducto = resultSet.getInt("idProducto");
        Integer idPersona = resultSet.getInt("idPersona");
        LocalDate fechaSolicitud = extraerLocalDate(resultSet, "fechaSolicitud");
        Integer diasAlquiler = resultSet.getInt("diasAlquiler");
        LocalDate fechaDevolucion = extraerLocalDate(resultSet, "fechaDevolucion");
        Double valorSolicitud = resultSet.getDouble("valorSolicitud");
        Double valorDeposito = resultSet.getDouble("valorDeposito");

        return new DtoSolicitud(idSolicitud,idProducto,idPersona,fechaSolicitud,diasAlquiler,fechaDevolucion,valorSolicitud,valorDeposito);
    }
}