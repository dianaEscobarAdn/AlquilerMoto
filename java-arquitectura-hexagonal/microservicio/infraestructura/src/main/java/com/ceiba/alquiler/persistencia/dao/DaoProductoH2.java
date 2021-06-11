package com.ceiba.alquiler.persistencia.dao;

import com.ceiba.alquiler.persistencia.entidades.EntidadProducto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DaoProductoH2 extends JpaRepository<EntidadProducto, Integer> {
}
