package com.ceiba.alquiler.comando.fabrica;

import com.ceiba.alquiler.comando.ComandoProducto;
import com.ceiba.alquiler.modelo.entidad.Producto;
import org.springframework.stereotype.Component;

@Component
public class FabricaProducto {

    public Producto crear(ComandoProducto comandoProducto) {
        return new Producto(
                comandoProducto.getIdProducto(),
                comandoProducto.getCodigoProducto(),
                comandoProducto.getDescripcionProducto(),
                comandoProducto.getUnidadesDisponibles(),
                comandoProducto.getUnidadesComprometidas()
        );
    }
}