package com.ceiba.alquiler.consulta;

import com.ceiba.alquiler.modelo.dto.DtoProducto;
import com.ceiba.alquiler.puerto.dao.DaoProducto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarProducto {

    private final DaoProducto daoProducto;

    public ManejadorListarProducto(DaoProducto daoProducto) {
        this.daoProducto = daoProducto;
    }

    public List<DtoProducto> ejecutar(){ return this.daoProducto.consultarProductos(); }
}