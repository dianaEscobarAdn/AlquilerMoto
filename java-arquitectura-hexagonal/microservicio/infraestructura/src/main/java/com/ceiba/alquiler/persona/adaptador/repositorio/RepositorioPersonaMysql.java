package com.ceiba.alquiler.persona.adaptador.repositorio;

import com.ceiba.alquiler.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.alquiler.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.alquiler.modelo.entidad.Persona;
import com.ceiba.alquiler.puerto.repositorio.RepositorioPersona;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class RepositorioPersonaMysql implements RepositorioPersona {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace= "persona", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace= "persona", value="consultarPersona")
    private static String sqlConsultarPersona;

    @SqlStatement(namespace="persona", value="eliminar")
    private static String sqlEliminar;

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

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlConsultarPersona,paramSource,new RowMapper<Persona>() {
            @Override
            public Persona mapRow(ResultSet rs, int rownumber) throws SQLException {
                Persona persona = new Persona(
                        rs.getInt("idPersona"),
                        rs.getInt("cedula"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getInt("telefono"),
                        rs.getString("direccion")
                );
                return persona;
            }
        });
    }
}