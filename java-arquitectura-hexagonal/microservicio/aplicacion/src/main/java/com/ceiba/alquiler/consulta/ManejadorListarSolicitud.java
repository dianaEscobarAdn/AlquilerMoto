package com.ceiba.alquiler.consulta;

import com.ceiba.alquiler.ComandoRespuesta;
import com.ceiba.alquiler.comando.ComandoSolicitud;
import com.ceiba.alquiler.modelo.dto.DtoProducto;
import com.ceiba.alquiler.modelo.dto.DtoSolicitud;
import com.ceiba.alquiler.puerto.dao.DaoSolicitud;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ManejadorListarSolicitud {

    private final DaoSolicitud daoSolicitud;

    public ManejadorListarSolicitud(DaoSolicitud daoSolicitud) {
        this.daoSolicitud = daoSolicitud;
    }

    public List<DtoSolicitud> ejecutar(){ return this.daoSolicitud.consultarSolicitudes(); }

   /* public ComandoRespuesta<List<ComandoSolicitud>> ejecutar() {
        List<ComandoSolicitud> comandoSolicitudList = new ArrayList<>();

        this.daoSolicitud.consultarSolicitudes().stream().forEach(solicitud -> {
            comandoSolicitudList.add(new ComandoSolicitud(
                    solicitud.getIdSolicitud(),
                    solicitud.getIdProducto(),
                    solicitud.getIdPersona(),
                    solicitud.getFechaSolicitud(),
                    solicitud.getDiasAlquiler(),
                    solicitud.getFechaDevolucion(),
                    solicitud.getValorSolicitud(),
                    solicitud.getValorDeposito()
            ));
        });
        return new ComandoRespuesta<>(comandoSolicitudList);
    }*/
}
