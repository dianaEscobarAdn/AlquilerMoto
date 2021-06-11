package com.ceiba.alquiler.persistencia.respositorios;

import com.ceiba.alquiler.modelo.entidad.Producto;
import com.ceiba.alquiler.persistencia.dao.DaoProductoH2;
import com.ceiba.alquiler.persistencia.entidades.EntidadProducto;
import com.ceiba.alquiler.puerto.dao.DaoProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DaoProductoImpl implements DaoProducto {
    @Autowired
    private DaoProductoH2 daoProductoH2;

    private List<Producto> listProducto;

    @Override
    public List<Producto> consultarProductos() {
        listProducto = new ArrayList<>();
        this.daoProductoH2.findAll().forEach(producto -> {
            this.listProducto.add(
                    new Producto(
                            producto.getIdProducto(),
                            producto.getCodigoProducto(),
                            producto.getDescripcionProducto(),
                            producto.getUnidadesDisponibles(),
                            producto.getUnidadesComprometidas()
                    )
            );
        });
        return this.listProducto;
    }

    @Override
    public Producto consultarProducto(Integer id) {
        Producto producto = null;
        EntidadProducto ProductoBuscado = this.daoProductoH2.findById(id).orElse(null);
        if (ProductoBuscado != null) {
            producto = new Producto(
                    ProductoBuscado.getIdProducto(),
                    ProductoBuscado.getCodigoProducto(),
                    ProductoBuscado.getDescripcionProducto(),
                    ProductoBuscado.getUnidadesDisponibles(),
                    ProductoBuscado.getUnidadesComprometidas()
            );
        }
        return producto;
    }

}
