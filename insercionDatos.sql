insert into personal values('39489651P', '2000.5', '692024537', '9:00:00', '17:00:00', 'Macías', 'Carbajo', 'David', 'davidmacar@gmail.com', 'david00');
insert into personal values('33333333C', '2500.3', '665895231', '9:00:00', '11:00:00', 'Alvarez', 'Pérez', 'Lara', 'lara@gmail.com', 'lara00');
insert into personal values('11111111A', '3000', '654654654', '9:00:00', '14:00:00', 'Asecas', 'Pardo', 'Marcos', 'marcos@gmail.com', 'marcos00');
insert into personal values('44444444D', '3500', '684158416', '9:00:00', '20:00:00', 'Salgado', 'Larrea', 'Brais', 'brais@gmail.com', 'brais00');
insert into personal values('36585156L', '5682.4', '658456389', '9:00:00', '16:00:00', 'Pardo', 'Mendoza', 'Lizzete', 'brais@gmail.com', 'lizzete00');
-- Gerente
insert into gerente values ('39489651P');

-- Cocinero
insert into cocinero values ('33333333C');

-- Camarero
insert into camarero values ('11111111A');
insert into camarero values ('44444444D');
insert into camarero values ('36585156L');

-- Mesas
insert into mesas values(nextval('controla_secuencia_mesas'));
insert into mesas values(nextval('controla_secuencia_mesas'));
insert into mesas values(nextval('controla_secuencia_mesas'));

--  Atender

-- Materias primas
insert into materias_primas values ('Tomate', '5', '1.5', '39489651P');
insert into materias_primas values ('Lechuga', '10', '1', '39489651P');
insert into materias_primas values ('Aceite', '50', '4', '39489651P');
insert into materias_primas values ('Fontvella', '100', '0.5', '39489651P');
insert into materias_primas values ('Estrella Galicia', '100', '0.5', '39489651P');
insert into materias_primas values ('Ribeiro', '100', '0.5', '39489651P');
insert into materias_primas values ('Mojito', '100', '0.5', '39489651P');
insert into materias_primas values ('Coca-Cola', '100', '0.5', '39489651P');
insert into materias_primas values ('Aceituna', '100', '0.5', '39489651P');
insert into materias_primas values ('Pechuga de pollo', '100', '0.5', '39489651P');
insert into materias_primas values ('Arroz', '100', '0.5', '39489651P');
insert into materias_primas values ('Calamar', '100', '0.5', '39489651P');
insert into materias_primas values ('Semillas de sesamo', '100', '0.5', '39489651P');
insert into materias_primas values ('Alcaparras', '100', '0.5', '39489651P');

--Bebidas
insert into bebidas values('Fontvella', 'refresco', null);
insert into bebidas values('Estrella Galicia', 'cerveza', 4.8);
insert into bebidas values('Ribeiro', 'vino', 7.2);
insert into bebidas values('Mojito', 'coctel', 12.1);
insert into bebidas values('Coca-Cola', 'refresco', null);

--Ingredientes
insert into ingredientes values('Tomate');
insert into ingredientes values('Lechuga');
insert into ingredientes values('Aceite');
insert into ingredientes values('Aceituna');
insert into ingredientes values('Pechuga de pollo');
insert into ingredientes values('Arroz');
insert into ingredientes values('Calamar');
insert into ingredientes values('Semillas de sesamo');
insert into ingredientes values('Alcaparras');

--Platos
insert into platos values
('Ensalada simple', 'TRUE', 'FALSE', 'primero', 'Ensalada simple: tomate, lechuga y aceite'),
('Jamon', 'FALSE', 'FALSE', 'entrante', 'Jamon Serrano'),
('Ensalada vegana', 'TRUE', 'FALSE', 'primero', 'Ensalada vegana: atun, lechuga y tomates'),
('Ensalada carnivora','FALSE', 'FALSE', 'primero', 'Ensalada carnivora:  aceitunas, lechuga, aceite de oliva'),
('Albondigas','FALSE', 'FALSE', 'segundo', 'Albondigas: carne, tomate frito, ajo'),
('Queso','FALSE', 'FALSE', 'segundo', 'Tabla quesos: manchego, curado, tetilla'),
('Salmon','FALSE', 'FALSE', 'segundo', 'Salmon ahumado: salmon, sal, aceite'),
('Yougurt','FALSE', 'FALSE', 'postre', 'Yougurt'),
('Pina','FALSE', 'FALSE', 'postre', 'Piña'),
('Ananas','FALSE', 'FALSE', 'postre', 'Buñuelo'),
('Natillas','FALSE', 'FALSE', 'postre', 'Natillas: vainilla, leche, azucar');

--Ingrediente_forma_plato
insert into ingrediente_forma_plato values('Ensalada simple', 'Tomate');
insert into ingrediente_forma_plato values('Ensalada simple', 'Lechuga');
insert into ingrediente_forma_plato values('Jamon', 'Aceite');

--Tener plato
insert into tenerPlato values
(1, 'Ensalada simple', nextval('controla_secuencia_tenerPlato')),
(2, 'Jamon', nextval('controla_secuencia_tenerPlato')),
(2, 'Salmon', nextval('controla_secuencia_tenerPlato')),
(3, 'Pina', nextval('controla_secuencia_tenerPlato')),
(2, 'Natillas',nextval('controla_secuencia_tenerPlato'));

--Tener Bebida
insert into tenerBebida values
(1, 'Ribeiro', nextval('controla_secuencia_tenerBebida')),
(2, 'Mojito', nextval('controla_secuencia_tenerBebida')),
(2, 'Fontvella', nextval('controla_secuencia_tenerBebida')),
(3, 'Coca-Cola', nextval('controla_secuencia_tenerBebida')),
(2, 'Estrella Galicia',nextval('controla_secuencia_tenerBebida'));

--Cocinar plato

--Empresa marketing

--Campaña publicitaria




