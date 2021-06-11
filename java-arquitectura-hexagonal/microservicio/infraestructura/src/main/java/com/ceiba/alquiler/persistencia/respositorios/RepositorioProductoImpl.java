package com.ceiba.alquiler.persistencia.respositorios;

import com.ceiba.alquiler.modelo.entidad.Producto;
import com.ceiba.alquiler.persistencia.dao.DaoProductoH2;
import com.ceiba.alquiler.persistencia.entidades.EntidadProducto;
import com.ceiba.alquiler.puerto.repositorio.RepositorioProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositorioProductoImpl implements RepositorioProducto {

    @Autowired
    private DaoProductoH2 daoProductoH2;

    private List<Producto> listProducto;

    @Override
    public Integer crear(Producto producto) {
        return this.daoProductoH2.save(new EntidadProducto(
                producto.getCodigoProducto(),
                producto.getDescripcionProducto(),
                producto.getUnidadesDisponibles(),
                producto.getUnidadesComprometidas()
        )).getIdProducto();
    }

    @Override
    public Producto buscarProductoPorId(Integer idProducto) {
        EntidadProducto ProductoBuscado = this.daoProductoH2.findById(idProducto).orElse(null);
        if (ProductoBuscado != null) {
            return new Producto(
                    ProductoBuscado.getIdProducto(),
                    ProductoBuscado.getCodigoProducto(),
                    ProductoBuscado.getDescripcionProducto(),
                    ProductoBuscado.getUnidadesDisponibles(),
                    ProductoBuscado.getUnidadesComprometidas()
            );
        }
        return null;
    }
}
