package com.ceiba.alquiler.configuracion;

import com.ceiba.alquiler.servicio.persona.ServicioCrearPersona;
import com.ceiba.alquiler.servicio.persona.ServicioEliminarPersona;
import com.ceiba.alquiler.servicio.producto.ServicioCrearProducto;
import com.ceiba.alquiler.servicio.producto.ServicioEliminarProducto;
import com.ceiba.alquiler.servicio.solicitud.ServicioCrearSolicitud;
import com.ceiba.alquiler.puerto.repositorio.*;
import com.ceiba.alquiler.servicio.solicitud.ServicioEliminarSolicitud;
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

    @Bean
    public ServicioEliminarPersona servicioEliminarPersona(RepositorioPersona repositorioPersona) {
        return new ServicioEliminarPersona(repositorioPersona);
    }

    @Bean
    public ServicioEliminarProducto servicioEliminarProducto(RepositorioProducto repositorioProducto) {
        return new ServicioEliminarProducto(repositorioProducto);
    }

    @Bean
    public ServicioEliminarSolicitud servicioEliminarSolicitud(RepositorioSolicitud repositorioSolicitud) {
        return new ServicioEliminarSolicitud(repositorioSolicitud);
    }

}
