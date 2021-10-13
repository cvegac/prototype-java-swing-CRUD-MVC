CREATE TABLE ruta(
    rut_id INT NOT NULL,
    rut_velocidades INT,
    rut_peso INT,
    primary key (rut_id),
    FOREIGN KEY (rut_id) REFERENCES bicicleta (bic_id)
);
insert into ruta values (2727, 33, 11);
insert into ruta values (1421, 21, 3);
insert into ruta values (1811, 30, 3);
insert into ruta values (1514, 27, 4);
insert into ruta values (1111, 24, 10);
insert into ruta values (1121, 14, 8);
insert into ruta values (1014, 16, 12);
insert into ruta values (2711, 22, 6);