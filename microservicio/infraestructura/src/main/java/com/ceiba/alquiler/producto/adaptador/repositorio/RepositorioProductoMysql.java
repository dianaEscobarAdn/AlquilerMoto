package com.ceiba.alquiler.producto.adaptador.repositorio;

import com.ceiba.alquiler.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.alquiler.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.alquiler.modelo.entidad.Producto;
import com.ceiba.alquiler.puerto.repositorio.RepositorioProducto;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class RepositorioProductoMysql implements RepositorioProducto {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "producto", value = "crear")
    private static String sqlCrear;

    @SqlStatement(namespace = "producto", value = "consultarProducto")
    private static String sqlConsultarProducto;

    @SqlStatement(namespace = "producto", value = "actualizar")
    private static String sqlActualizar;

    public RepositorioProductoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Integer crear(Producto producto) {
        return this.customNamedParameterJdbcTemplate.crearInt(producto, sqlCrear);
    }

    @Override
    public Producto buscarProductoPorId(Integer idProducto) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idProducto", idProducto);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlConsultarProducto, paramSource, new RowMapper<Producto>() {
            @Override
            public Producto mapRow(ResultSet rs, int rownumber) throws SQLException {
                Producto producto = new Producto(
                        rs.getInt("idProducto"),
                        rs.getString("codigoProducto"),
                        rs.getString("descripcionProducto"),
                        rs.getInt("unidadesDisponibles"),
                        rs.getInt("unidadesComprometidas")
                );
                return producto;
            }
        });
    }

    @Override
    public void actualizar(Producto producto) {
        this.customNamedParameterJdbcTemplate.actualizar(producto, sqlActualizar);
    }
}