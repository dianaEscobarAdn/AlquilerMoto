package com.ceiba.alquiler.controladores;

import com.ceiba.alquiler.ComandoRespuesta;
import com.ceiba.alquiler.comando.ComandoSolicitud;
import com.ceiba.alquiler.comando.manejador.ManejadorCrearSolicitud;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/solicitud")
@Api(tags = { "Controlador comando solicitud"})
public class ComandoControladorSolicitud {
    private ManejadorCrearSolicitud crearSolicitud;

    public ComandoControladorSolicitud(ManejadorCrearSolicitud crearSolicitud) {
        this.crearSolicitud = crearSolicitud;
    }

    @PostMapping
    public ResponseEntity<ComandoRespuesta<String>> crearSolicitud(@RequestBody ComandoSolicitud solicitud) {
        return new ResponseEntity<>(this.crearSolicitud.ejecutar(solicitud),HttpStatus.OK);
    }
}
