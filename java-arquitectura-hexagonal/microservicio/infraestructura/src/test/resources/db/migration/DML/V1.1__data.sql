insert into persona(cedula,nombre,apellido,telefono,direccion)
    values(1036,'Registro','Prueba',2222222,'calle 55');

insert into producto(codigoProducto,descripcionProducto,unidadesDisponibles,unidadesComprometidas)
   values(12345,'Moto',20,5);

insert into solicitud(idProducto,idPersona,fechaSolicitud,diasAlquiler,fechaDevolucion,valorSolicitud,valorDeposito)
   values(1,1,'2021-06-16',5,'2021-06-22',125000.0,25000.0);
