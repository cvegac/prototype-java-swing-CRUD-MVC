CREATE TABLE mtb(
    mtb_id INT NOT NULL,
    mtb_descripcion CHAR(250),
    mtb_anio INT,
    mtb_creador INT,
    primary key (mtb_id),
    foreign key (mtb_creador) references creador(cre_id),
    FOREIGN KEY (mtb_id) REFERENCES bicicleta (bic_id)
);
insert into mtb values (1234, "Bicicleta de montaña con alto nivel competitivo, con marco en fibra de carbono, grupo de cambios Shimano Alivio.",2014, 102);
insert into mtb values (4321, "Bicicleta de montaña con medio nivel competitivo, con marco en aluminio, grupo de cambios Shimano Turney.",2016, 103);
insert into mtb values (1999, "Bicicleta de montaña con excelente nivel competitivo, con marco en fibra de carbono, grupo de cambios Shimano Deore.",2017, 101);
insert into mtb values (1722, "Bicicleta de montaña para uso casual, con marco en hierro y aluminio, grupo de cambios Shimano básico.",2017, 104);
insert into mtb values (1425, "Bicicleta de montaña con máximo nivel competitivo, con marco en fibra de carbono, grupo de cambios Shimano Slx.",2015, 105);