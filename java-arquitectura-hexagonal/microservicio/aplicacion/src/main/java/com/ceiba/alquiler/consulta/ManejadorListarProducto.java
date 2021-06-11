package com.ceiba.alquiler.consulta;

import com.ceiba.alquiler.ComandoRespuesta;
import com.ceiba.alquiler.comando.ComandoProducto;
import com.ceiba.alquiler.modelo.dto.DtoProducto;
import com.ceiba.alquiler.puerto.dao.DaoProducto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ManejadorListarProducto {

    private final DaoProducto daoProducto;

    public ManejadorListarProducto(DaoProducto daoProducto) {
        this.daoProducto = daoProducto;
    }

    public ComandoRespuesta<List<ComandoProducto>> ejecutar() {
        List<ComandoProducto> comandoProductoList = new ArrayList<>();

        this.daoProducto.consultarProductos().stream().forEach(producto -> {
            comandoProductoList.add(new ComandoProducto(
                    producto.getIdProducto(),
                    producto.getCodigoProducto(),
                    producto.getDescripcionProducto(),
                    producto.getUnidadesDisponibles(),
                    producto.getUnidadesComprometidas()
            ));
        });
        return new ComandoRespuesta<>(comandoProductoList);
    }
}
