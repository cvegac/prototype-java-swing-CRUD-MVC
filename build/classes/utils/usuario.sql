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
insert into usuario (usr_id, usr_username,usr_nombre,usr_apellido) values (1,"lucky", "Pedro", "Perez");
insert into usuario (usr_id, usr_username,usr_nombre,usr_apellido) values (2,"malopez", "Maria", "Lopez");
insert into usuario (usr_id, usr_username,usr_nombre,usr_apellido) values (3,"diva", "Ana", "Diaz");
insert into usuario (usr_id, usr_username,usr_nombre,usr_apellido) values (4,"dreamer", "Luis", "Rojas");
insert into usuario (usr_id, usr_username,usr_nombre,usr_apellido) values (5,"ninja", "Andres", "Cruz");
insert into usuario (usr_id, usr_username,usr_nombre,usr_apellido) values (6,"neon", "Nelson", "Ruiz");
insert into usuario (usr_id, usr_username,usr_nombre,usr_apellido) values (7,"rose", "Claudia", "Mendez");
insert into usuario (usr_id, usr_username,usr_nombre,usr_apellido) values (8,"green", "Jorge", "Rodriguez");