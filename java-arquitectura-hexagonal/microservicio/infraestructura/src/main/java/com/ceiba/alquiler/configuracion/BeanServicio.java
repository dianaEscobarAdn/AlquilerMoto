package com.ceiba.alquiler.configuracion;

import com.ceiba.alquiler.ServicioCrearPersona;
import com.ceiba.alquiler.ServicioCrearProducto;
import com.ceiba.alquiler.ServicioCrearSolicitud;
import com.ceiba.alquiler.puerto.repositorio.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    @Bean
    public ServicioCrearPersona servicioCrearPersona(RepositorioPersona repositorioPersona) {
        return new ServicioCrearPersona(repositorioPersona);
    }

    @Bean
    public ServicioCrearProducto servicioCrearProducto(RepositorioProducto repositorioProducto) {
        return new ServicioCrearProducto(repositorioProducto);
    }

    @Bean
    public ServicioCrearSolicitud servicioCrearSolicitud(RepositorioSolicitud repositorioSolicitud,RepositorioProducto repositorioProducto) {
        return new ServicioCrearSolicitud(repositorioSolicitud,repositorioProducto);
    }

}
