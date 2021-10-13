DROP schema if exists Reto4;
CREATE SCHEMA Reto4;
USE Reto4; 

CREATE TABLE usuario(
	usr_id int NOT NULL,
    usr_username char(20),
    usr_nombre char(20),
    usr_apellido char(20),
    usr_email char(30) default "correo@correo.com",
    usr_celular bigint default "1234567890",
    usr_clave char(20) default "1234",
    usr_fecha_nto date default 0,
    primary key (usr_id)
);
CREATE TABLE creador(
	cre_id INT NOT NULL,
    cre_nombre CHAR(20),
    cre_apellido CHAR(20),
    cre_nacionalidad CHAR(40),
    primary key (cre_id)
);
CREATE TABLE bicicleta(
	bic_id INT NOT NULL,
    bic_marco CHAR(50),
    primary key (bic_id)
);
CREATE TABLE mtb(
	mtb_id INT NOT NULL,
    mtb_descripcion CHAR(250),
    mtb_anio INT,
    mtb_creador INT,
    primary key (mtb_id),
    foreign key (mtb_creador) references creador(cre_id),
    FOREIGN KEY (mtb_id) REFERENCES bicicleta (bic_id)
);
CREATE TABLE ruta(
	rut_id INT NOT NULL,
    rut_velocidades INT,
    rut_peso INT,
    primary key (rut_id),
    FOREIGN KEY (rut_id) REFERENCES bicicleta (bic_id)
);
CREATE TABLE venta(
	ven_id int NOT NULL,
    ven_usr_id int,
    ven_bic_id int,
    ven_fecha DATETIME NULL DEFAULT CURRENT_TIMESTAMP() ON UPDATE CURRENT_TIMESTAMP,
    primary key (ven_id),
    foreign key (ven_usr_id) references usuario(usr_id),
    foreign key (ven_bic_id) references bicicleta(bic_id)
);


insert into usuario (usr_id, usr_username,usr_nombre,usr_apellido) values (1,"lucky", "Pedro", "Perez");
insert into usuario (usr_id, usr_username,usr_nombre,usr_apellido) values (2,"malopez", "Maria", "Lopez");
insert into usuario (usr_id, usr_username,usr_nombre,usr_apellido) values (3,"diva", "Ana", "Diaz");
insert into usuario (usr_id, usr_username,usr_nombre,usr_apellido) values (4,"dreamer", "Luis", "Rojas");
insert into usuario (usr_id, usr_username,usr_nombre,usr_apellido) values (5,"ninja", "Andres", "Cruz");
insert into usuario (usr_id, usr_username,usr_nombre,usr_apellido) values (6,"neon", "Nelson", "Ruiz");
insert into usuario (usr_id, usr_username,usr_nombre,usr_apellido) values (7,"rose", "Claudia", "Mendez");
insert into usuario (usr_id, usr_username,usr_nombre,usr_apellido) values (8,"green", "Jorge", "Rodriguez");


insert into creador values (101, "Carlos","Perez", "japones");
insert into creador values (102, "Joss", "Mora", "estadounidense");
insert into creador values (103, "Christopher", "Salazar", "estadounidense");
insert into creador values (104, "James", "Carvajal", "coreano");
insert into creador values (105, "Vincent", "Chung", "neozelandes");


insert into bicicleta values (1234,"M-1234"); 
insert into bicicleta values (4321,"M-4321"); 
insert into bicicleta values (1999,"M-1999"); 
insert into bicicleta values (1722,"M-1722"); 
insert into bicicleta values (1425,"M-1425"); 

insert into bicicleta values (2727,"RT-2727");
insert into bicicleta values (1421,"RT-1421");
insert into bicicleta values (1811,"RT-1811");
insert into bicicleta values (1514,"RT-1514");
insert into bicicleta values (1111,"RT-1111");
insert into bicicleta values (1121,"RT-1121");
insert into bicicleta values (1014,"RT-1014");
insert into bicicleta values (2711,"RT-2711");


insert into mtb values (1234, "Bicicleta de montaña con alto nivel competitivo, con marco en fibra de carbono, grupo de cambios Shimano Alivio.",2014, 102);
insert into mtb values (4321, "Bicicleta de montaña con medio nivel competitivo, con marco en aluminio, grupo de cambios Shimano Turney.",2016, 103);
insert into mtb values (1999, "Bicicleta de montaña con excelente nivel competitivo, con marco en fibra de carbono, grupo de cambios Shimano Deore.",2017, 101);
insert into mtb values (1722, "Bicicleta de montaña para uso casual, con marco en hierro y aluminio, grupo de cambios Shimano básico.",2017, 104);
insert into mtb values (1425, "Bicicleta de montaña con máximo nivel competitivo, con marco en fibra de carbono, grupo de cambios Shimano Slx.",2015, 105);


insert into ruta values (2727, 33, 11);
insert into ruta values (1421, 21, 3);
insert into ruta values (1811, 30, 3);
insert into ruta values (1514, 27, 4);
insert into ruta values (1111, 24, 10);
insert into ruta values (1121, 14, 8);
insert into ruta values (1014, 16, 12);
insert into ruta values (2711, 22, 6);


insert into venta (ven_id,ven_usr_id, ven_bic_id, ven_fecha) values (1, 1, 1234, '2017-10-25 20:00:00');
insert into venta (ven_id,ven_usr_id, ven_bic_id, ven_fecha) values (2, 1, 1722, '2019-03-15 18:30:00');
insert into venta (ven_id,ven_usr_id, ven_bic_id, ven_fecha) values (3, 1, 1514, '2019-05-20 20:30:00');
insert into venta (ven_id,ven_usr_id, ven_bic_id, ven_fecha) values (4, 2, 1234, '2018-05-20 20:30:00');
insert into venta (ven_id,ven_usr_id, ven_bic_id, ven_fecha) values (5, 2, 1514, '2020-01-20 20:30:00');
insert into venta (ven_id,ven_usr_id, ven_bic_id, ven_fecha) values (6, 3, 4321, '2019-05-20 20:30:00');
insert into venta (ven_id,ven_usr_id, ven_bic_id, ven_fecha) values (7, 3, 1999, '2018-06-22 21:30:00');
insert into venta (ven_id,ven_usr_id, ven_bic_id, ven_fecha) values (8, 3, 2727, '2020-03-17 15:30:20');
insert into venta (ven_id,ven_usr_id, ven_bic_id, ven_fecha) values (9, 4, 2727, '2020-03-17 15:30:20');
insert into venta (ven_id,ven_usr_id, ven_bic_id, ven_fecha) values (10, 4, 1421, '2020-04-10 18:30:20');
insert into venta (ven_id,ven_usr_id, ven_bic_id, ven_fecha) values (11, 5, 1811, '2020-02-17 20:30:20');
insert into venta (ven_id,ven_usr_id, ven_bic_id, ven_fecha) values (12, 5, 1514, '2020-02-20 16:30:20');
insert into venta (ven_id,ven_usr_id, ven_bic_id, ven_fecha) values (13, 5, 1121, '2020-03-27 18:30:20');
insert into venta (ven_id,ven_usr_id, ven_bic_id, ven_fecha) values (14, 7, 1111, '2020-03-20 21:30:20');
insert into venta (ven_id,ven_usr_id, ven_bic_id, ven_fecha) values (15, 8, 4321, '2020-01-10 17:30:20');
insert into venta (ven_id,ven_usr_id, ven_bic_id, ven_fecha) values (16, 8, 1722, '2020-02-15 20:30:20');
insert into venta (ven_id,ven_usr_id, ven_bic_id, ven_fecha) values (17, 8, 1425, '2020-03-17 18:30:20');

-- UPDATES.sql
update mtb set mtb_anio = 2012 where mtb_id = 1234;
update usuario set usr_celular = 3115678432 where usr_id = 5;
delete from venta where ven_usr_id = 5 and ven_bic_id = 1722;

-- CONSULTAS.sql
select 'Consulta 1';
select bic_marco from bicicleta order by bic_marco asc;
select 'Consulta 2';
select bic_marco, mtb_descripcion, mtb_anio from mtb join bicicleta on (mtb_id = bic_id) where mtb_anio >= 2014 order by mtb_id;
select 'Consulta 3';
select bic_marco from mtb join creador on (mtb_creador = cre_id) join bicicleta on (mtb_id = bic_id) where cre_nombre = "Vincent" and cre_apellido = "Chung" ;
select 'Consulta 4';
select bic_marco from venta join usuario on (ven_usr_id = usr_id) join bicicleta on (ven_bic_id = bic_id) where usr_username = "lucky" order by bic_marco;
select 'Consulta 5';
select usr_username, usr_nombre, usr_apellido from venta join bicicleta on (ven_bic_id=bic_id) join usuario  on (ven_usr_id=usr_id) where bic_marco = "M-4321";
select 'Consulta 6';
select count(mtb_anio) from mtb where mtb_anio > 2015;