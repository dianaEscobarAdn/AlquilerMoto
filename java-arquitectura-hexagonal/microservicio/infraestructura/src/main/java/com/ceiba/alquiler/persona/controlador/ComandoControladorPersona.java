package com.ceiba.alquiler.persona.controlador;

import com.ceiba.alquiler.ComandoRespuesta;
import com.ceiba.alquiler.comando.ComandoPersona;
import com.ceiba.alquiler.comando.manejador.ManejadorCrearPersona;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/persona")
@Api(tags = { "Controlador comando persona"})
public class ComandoControladorPersona {

    private final ManejadorCrearPersona manejadorCrearPersona;

    @Autowired
    public ComandoControladorPersona(ManejadorCrearPersona manejadorCrearPersona) {
        this.manejadorCrearPersona = manejadorCrearPersona;
    }

    @PostMapping
    @ApiOperation("Crear Persona")
    public ComandoRespuesta<Integer> crear(@RequestBody ComandoPersona comandoPersona) {
        return manejadorCrearPersona.ejecutar(comandoPersona);
    }
}
