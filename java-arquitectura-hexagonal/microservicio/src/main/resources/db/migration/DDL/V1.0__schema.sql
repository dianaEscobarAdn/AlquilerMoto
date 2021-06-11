create table persona (
 idPersona int(11) not null auto_increment,
 cedula int(100) not null,
 nombre varchar(255) not null,
 apellido varchar(255) not null,
 telefono int(100) not null,
 direccion varchar(255) not null,
 primary key (idPersona)
);

create table producto (
 idProducto int(11) not null auto_increment,
 codigoProducto varchar(100) not null,
 descripcionProducto varchar(255) not null,
 unidadesDisponibles int(11) not null,
 unidadesComprometidas int(11) not null,
 primary key (idProducto)
);

create table solicitud (
 idSolicitud int(11) not null auto_increment,
 idProducto int(11) not null,
 idPersona int(11) not null,
 fechaSolicitud DATETIME DEFAULT NOW(),
 diasAlquiler int(11) not null,
 fechaDevolucion DATETIME DEFAULT NOW(),
 valorSolicitud  DECIMAL(10,2),
 valorDeposito  DECIMAL(10,2),
 primary key (idSolicitud)
);