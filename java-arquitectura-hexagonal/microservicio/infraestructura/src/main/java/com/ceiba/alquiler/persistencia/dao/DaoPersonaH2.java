package com.ceiba.alquiler.persistencia.dao;

import com.ceiba.alquiler.persistencia.entidades.EntidadPersona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DaoPersonaH2 extends JpaRepository<EntidadPersona, Integer> {
}
