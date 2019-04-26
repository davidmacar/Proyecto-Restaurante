create table personal (
	dni varchar(9) primary key,
	salario numeric not null check (salario > 0),
	numero_tlf integer,
	fecha_entrada time,
	fecha_salida time,
	nombre varchar(30) not null,
	apellido_1 varchar(30) not null,
	apellido_2 varchar(30) not null,
	e_mail varchar(50),
	contrasena varchar(50)
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


create sequence controla_secuencia_mesas;
create table mesas (
	num_mesa integer unique DEFAULT nextval('controla_secuencia_mesas'),
	primary key (num_mesa)
	/*
	cajero varchar(9),
	camarero varchar(9),
	id_venta integer unique,
	precio numeric,
	fecha_venta timestamp,
	primary key (num_mesa, id_venta),
	foreign key (cajero) references cajero(codigo_trabajador)
		on delete cascade on update cascade,
	foreign key (camarero) references camarero(codigo_trabajador)
		on delete cascade on update cascade*/
);

create table atender(
	mesa integer,
	camarero varchar(9),
	id_venta integer,
	fecha_venta timestamp,
	precio numeric,
	primary key (mesa, camarero, id_venta),
	foreign key(camarero) references camarero(codigo_trabajador)
		on delete cascade on update cascade,
	foreign key(mesa) references mesas(num_mesa)
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
    tipo varchar(40) not null,
	porcentaje_alcohol numeric check (porcentaje_alcohol >= 0), 
	foreign key (nombre) references materias_primas(nombre)
		on delete cascade on update cascade
);

create table ingredientes (
	nombre varchar(40) primary key,
	foreign key (nombre) references materias_primas(nombre)
		on delete cascade on update cascade
);

create table platos (
	nombre varchar(40) primary key,
	apto_veganos boolean not null,
	apto_celiacos boolean not null,
	tipo varchar(40),
	descripcion varchar(100)
);

create sequence controla_secuencia_tenerPlato;
create table tenerPlato(
	mesa integer,
	plato varchar(40),
	servicio_plato integer unique DEFAULT nextval('controla_secuencia_tenerPlato'),
	primary key(mesa, plato, servicio_plato),
	foreign key (mesa) references mesas(num_mesa)
		on delete cascade on update cascade,
	foreign key (plato) references platos(nombre)
		on delete cascade on update cascade
);

create sequence controla_secuencia_tenerBebida;
create table tenerBebida(
	mesa integer,
	bebida varchar(40),
	servicio_bebida integer unique DEFAULT nextval('controla_secuencia_tenerBebida'),
	primary key(mesa, bebida, servicio_bebida),
	foreign key (mesa) references mesas(num_mesa)
		on delete cascade on update cascade,
	foreign key (bebida) references bebidas(nombre)
		on delete cascade on update cascade
);

create table ingrediente_forma_plato (
	plato varchar(40),
	ingrediente varchar(40),
	primary key (plato, ingrediente),
	foreign key (plato) references platos(nombre)
		on delete cascade on update cascade,
	foreign key (ingrediente) references materias_primas(nombre)
		on delete cascade on update cascade
);

create table cocinar_plato (
	plato varchar(40),
	cocinero varchar(9),
	primary key (plato, cocinero),
	foreign key (plato) references platos(nombre)
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


/*TRIGGERS*/

/*
create or replace function tipos_plato()
returns trigger LANGUAGE plpgsql as $tipos$
BEGIN 
if new.tipo = 'entrante' then ;
elsif new.tipo ='primero';
elsif new.tipo ='segundo';
elsif new.tipo = 'postre';
else raise  exception 'Error en la insercion del tipo plato'; end if;
RETURN NEW;
END;
$tipos$;


create trigger control_tipos_plato 
before insert 
on platos
for each row
execute procedure tipos_plato();
*/
