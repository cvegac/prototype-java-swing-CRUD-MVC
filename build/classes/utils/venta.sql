CREATE TABLE venta(
    ven_id int NOT NULL AUTO_INCREMENT,
    ven_usr_id int,
    ven_bic_id int,
    ven_fecha DATETIME NULL DEFAULT CURRENT_TIMESTAMP() ON UPDATE CURRENT_TIMESTAMP,
    primary key (ven_id),
    foreign key (ven_usr_id) references usuario(usr_id),
    foreign key (ven_bic_id) references bicicleta(bic_id)
);
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