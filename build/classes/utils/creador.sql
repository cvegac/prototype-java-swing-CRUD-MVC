CREATE TABLE creador(
    cre_id INT NOT NULL,
    cre_nombre CHAR(20),
    cre_apellido CHAR(20),
    cre_nacionalidad CHAR(40),
    primary key (cre_id)
);
insert into creador values (101, "Carlos","Perez", "japones");
insert into creador values (102, "Joss", "Mora", "estadounidense");
insert into creador values (103, "Christopher", "Salazar", "estadounidense");
insert into creador values (104, "James", "Carvajal", "coreano");
insert into creador values (105, "Vincent", "Chung", "neozelandes");