package com.ceiba.alquiler.controladores;

import com.ceiba.alquiler.ComandoRespuesta;
import com.ceiba.alquiler.comando.ComandoPersona;
import com.ceiba.alquiler.comando.manejador.ManejadorCrearPersona;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persona")
@Api(tags = { "Controlador comando persona"})
public class ComandoControladorPersona {
    private ManejadorCrearPersona crearPersona;

    public ComandoControladorPersona(ManejadorCrearPersona crearPersona) {
        this.crearPersona = crearPersona;
    }

    @PostMapping
    public ResponseEntity<ComandoRespuesta<String>> crearPersona(@RequestBody ComandoPersona persona) {
        return new ResponseEntity<>(this.crearPersona.ejecutar(persona),HttpStatus.OK);
    }
}
