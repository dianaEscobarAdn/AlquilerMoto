package com.ceiba.alquiler.persona.adaptador.dao;

import com.ceiba.alquiler.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.alquiler.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.alquiler.modelo.dto.DtoPersona;
import com.ceiba.alquiler.modelo.entidad.Persona;
import com.ceiba.alquiler.puerto.dao.DaoPersona;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoPersonaMysql implements DaoPersona {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace= "persona", value="consultarPersonas")
    private static String sqlListar;

    @SqlStatement(namespace= "persona", value="consultarPersona")
    private static String sqlListarPorId;

    public DaoPersonaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoPersona> consultarPersonas() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoPersona());
    }

    @Override
    public DtoPersona consultarPersona(Integer idPersona) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idPersona", idPersona);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlListarPorId, paramSource, DtoPersona.class);
    }
}