package com.ceiba.alquiler.solicitud.adaptador.dao;

import com.ceiba.alquiler.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.alquiler.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.alquiler.modelo.dto.DtoSolicitud;
import com.ceiba.alquiler.puerto.dao.DaoSolicitud;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoSolicitudMysql implements DaoSolicitud {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "solicitud", value = "consultarSolicitudes")
    private static String sqlListar;

    @SqlStatement(namespace = "solicitud", value = "consultarSolicitud")
    private static String sqlListarPorId;

    public DaoSolicitudMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoSolicitud> consultarSolicitudes() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoSolicitud());
    }

    @Override
    public DtoSolicitud consultarSolicitud(Integer idSolicitud) {
        return null;
    }
}