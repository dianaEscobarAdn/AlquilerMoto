package com.ceiba.alquiler.persona.controlador;

import com.ceiba.alquiler.ComandoRespuesta;
import com.ceiba.alquiler.comando.ComandoPersona;
import com.ceiba.alquiler.comando.manejador.ManejadorCrearPersona;
import com.ceiba.alquiler.comando.manejador.ManejadorEliminarPersona;
import com.ceiba.alquiler.modelo.dto.DtoRespuestaPersona;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/persona")
@Api(tags = { "Controlador comando persona"})
@CrossOrigin(origins = {"http://localhost:4200"} ,maxAge = 600)
public class ComandoControladorPersona {

    private final ManejadorCrearPersona manejadorCrearPersona;
    private final ManejadorEliminarPersona manejadorEliminarPersona;

    @Autowired
    public ComandoControladorPersona(ManejadorCrearPersona manejadorCrearPersona,ManejadorEliminarPersona manejadorEliminarPersona) {
        this.manejadorCrearPersona = manejadorCrearPersona;
        this.manejadorEliminarPersona = manejadorEliminarPersona;
    }

    @PostMapping
    @ApiOperation("Crear Persona")
    public ComandoRespuesta<DtoRespuestaPersona> crear(@RequestBody ComandoPersona comandoPersona) {
        return manejadorCrearPersona.ejecutar(comandoPersona);
    }

    @DeleteMapping(value="/{id}")
    @ApiOperation("Eliminar Persona")
    public void eliminar(@PathVariable Integer id) {manejadorEliminarPersona.ejecutar(id);}
}