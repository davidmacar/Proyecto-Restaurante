create table personal (
	dni varchar(9) primary key,
	salario numeric not null check (salario > 0),
	numero_tlf integer,
	fecha_entrada time,
	fecha_salida time,
	nombre varchar(30) not null,
	apellido_1 varchar(30) not null,
	apellido_2 varchar(30) not null,
	e_mail varchar(50)
);

create table gerente (
	codigo_trabajador varchar(9) primary key,
	foreign key (codigo_trabajador) references personal(dni)
		on delete cascade on update cascade
);

create table cocinero (
	codigo_trabajador varchar(9) primary key,
	foreign key (codigo_trabajador) references personal(dni)
		on delete cascade on update cascade
);

create table camarero (
	codigo_trabajador varchar(9) primary key,
	foreign key (codigo_trabajador) references personal(dni)
		on delete cascade on update cascade
);

create table cajero (
	codigo_trabajador varchar(9) primary key,
	foreign key (codigo_trabajador) references personal(dni)
		on delete cascade on update cascade
);

create table mesas (
	num_mesa integer unique,
	cajero varchar(9),
	camarero varchar(9),
	id_venta integer unique,
	precio numeric,
	fecha_venta timestamp,
	primary key (num_mesa, id_venta),
	foreign key (cajero) references cajero(codigo_trabajador)
		on delete cascade on update cascade,
	foreign key (camarero) references camarero(codigo_trabajador)
		on delete cascade on update cascade
);

create table materias_primas (
	nombre varchar(40) primary key,
	cantidad integer check (cantidad >= 0),
	precio numeric not null check (precio >= 0),
	gerente varchar(9),
	foreign key (gerente) references gerente(codigo_trabajador)
		on delete cascade on update cascade
);

create table bebidas (
	nombre varchar(40) primary key,
	mesa integer,
	id_venta integer,
	foreign key (nombre) references materias_primas(nombre)
		on delete cascade on update cascade,
	foreign key (mesa) references mesas(num_mesa)
		on delete cascade on update cascade,
	foreign key (id_venta) references mesas(id_venta)
		on delete cascade on update cascade
);

create table ingredientes (
	nombre varchar(40) primary key,
	foreign key (nombre) references materias_primas(nombre)
		on delete cascade on update cascade
);

create table platos (
	id_plato integer primary key,
	apto_veganos boolean not null,
	apto_celiacos boolean not null,
	tipo varchar(40),
	descripcion varchar(100),
	mesa integer,
	id_venta integer,
	foreign key (mesa) references mesas(num_mesa)
		on delete cascade on update cascade,
	foreign key (id_venta) references mesas(id_venta)
		on delete cascade on update cascade
);

create table ingrediente_forma_plato (
	plato integer,
	ingrediente varchar(40),
	primary key (plato, ingrediente),
	foreign key (plato) references platos(id_plato)
		on delete cascade on update cascade,
	foreign key (ingrediente) references materias_primas(nombre)
		on delete cascade on update cascade
);

create table cocinar_plato (
	plato integer,
	cocinero varchar(9),
	primary key (plato, cocinero),
	foreign key (plato) references platos(id_plato)
		on delete cascade on update cascade,
	foreign key (cocinero) references cocinero(codigo_trabajador)
		on delete cascade on update cascade
);

create table empresa_marketing (
	nombre varchar(50) unique,
	gerente varchar(9),
	precio numeric,
	primary key (nombre, gerente),
	foreign key (gerente) references gerente(codigo_trabajador)
		on delete cascade on update cascade
);

create table campaña_publicitaria(
	empresa varchar(50),
	fecha_inicio timestamp,
	fecha_fin timestamp,
	primary key (empresa, fecha_inicio, fecha_fin),
	foreign key (empresa) references empresa_marketing(nombre)
		on delete cascade on update cascade

);