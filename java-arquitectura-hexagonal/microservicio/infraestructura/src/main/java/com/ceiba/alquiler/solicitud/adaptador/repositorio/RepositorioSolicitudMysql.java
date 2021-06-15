package com.ceiba.alquiler.solicitud.adaptador.repositorio;

import com.ceiba.alquiler.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.alquiler.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.alquiler.modelo.entidad.Producto;
import com.ceiba.alquiler.modelo.entidad.Solicitud;
import com.ceiba.alquiler.puerto.repositorio.RepositorioSolicitud;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioSolicitudMysql implements RepositorioSolicitud {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="solicitud", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace= "solicitud", value="consultarSolicitudes")
    private static String sqlConsultarSolicitudes;

    public RepositorioSolicitudMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Integer crear(Solicitud solicitud) {
        return this.customNamedParameterJdbcTemplate.crearInt(solicitud, sqlCrear);
    }

    @Override
    public Solicitud buscarSolicitudPorId(Integer idSolicitud) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idSolicitud", idSolicitud);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlConsultarSolicitudes,paramSource, Solicitud.class);
    }
}
