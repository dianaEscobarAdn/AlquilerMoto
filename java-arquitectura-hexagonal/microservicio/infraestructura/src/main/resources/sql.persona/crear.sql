insert into persona (cedula, nombre,apellido,telefono,direccion)
    values (:cedula, :nombre, :apellido, :telefono, : direccion )

insert into producto (codigoProducto, descripcionProducto,unidadesDisponibles,unidadesComprometidas)
    values (:codigoProducto, :descripcionProducto, :unidadesDisponibles, :unidadesComprometidas)

insert into producto (idProducto, idPersona,fechaSolicitud,diasAlquiler,fechaDevolucion,valorSolicitud, valorDeposito)
    values (:idProducto, :idPersona, :fechaSolicitud, :diasAlquiler, :fechaDevolucion, :valorSolicitud , : valorDeposito )