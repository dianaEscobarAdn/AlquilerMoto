package com.ceiba.alquiler.persona.adaptador.repositorio;

import com.ceiba.alquiler.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.alquiler.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.alquiler.modelo.entidad.Persona;
import com.ceiba.alquiler.puerto.repositorio.RepositorioPersona;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioPersonaMysql implements RepositorioPersona {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace= "persona", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace= "persona", value="consultarPersonas")
    private static String sqlConsultarPersonas;

    public RepositorioPersonaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Integer crear(Persona persona) {
        return this.customNamedParameterJdbcTemplate.crearInt(persona, sqlCrear);
    }

    @Override
    public Persona buscarPersonaPorId(Integer idPersona) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idPersona", idPersona);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlConsultarPersonas,paramSource, Persona.class);
    }
}
