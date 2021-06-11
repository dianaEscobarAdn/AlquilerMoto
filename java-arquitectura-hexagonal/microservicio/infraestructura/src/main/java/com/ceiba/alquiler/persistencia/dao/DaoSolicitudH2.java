package com.ceiba.alquiler.persistencia.dao;

import com.ceiba.alquiler.persistencia.entidades.EntidadSolicitud;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DaoSolicitudH2 extends JpaRepository<EntidadSolicitud, Integer> {
}
