package com.ceiba.alquiler.solicitud.adaptador.repositorio;

import com.ceiba.alquiler.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.alquiler.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.alquiler.infraestructura.jdbc.MapperResult;
import com.ceiba.alquiler.modelo.entidad.Solicitud;
import com.ceiba.alquiler.puerto.repositorio.RepositorioSolicitud;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class RepositorioSolicitudMysql implements RepositorioSolicitud, MapperResult {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="solicitud", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace= "solicitud", value="consultarSolicitud")
    private static String sqlConsultarSolicitud;

    @SqlStatement(namespace="solicitud", value="eliminar")
    private static String sqlEliminar;

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

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlConsultarSolicitud,paramSource,new RowMapper<Solicitud>() {
            @Override
            public Solicitud mapRow(ResultSet rs, int rownumber) throws SQLException {
                Solicitud solicitud = new Solicitud(
                        rs.getInt("idSolicitud"),
                        rs.getInt("idProducto"),
                        rs.getInt("idPersona"),
                        extraerLocalDate(rs, "fechaSolicitud"),
                        rs.getInt("diasAlquiler"),
                        extraerLocalDate(rs, "fechaDevolucion"),
                        rs.getDouble("valorSolicitud"),
                        rs.getDouble("valorDeposito")
                );
                return solicitud;
            }
        });
    }

    @Override
    public void eliminar(Integer idSolicitud) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idSolicitud", idSolicitud);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);
    }
}