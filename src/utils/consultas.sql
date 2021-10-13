select 'Consulta 1';
select bic_marco from bicicleta order by bic_marco asc;
select 'Consulta 2';
select mtb_id, mtb_descripcion, mtb_anio from mtb where mtb_anio >= 2014 order by mtb_id;
select 'Consulta 3';
select mtb_id from mtb join creador on (mtb_creador = cre_id) where cre_nombre = "Vincent" and cre_apellido = "Chung" ;
select 'Consulta 4';
select bic_id from venta join usuario on (ven_usr_id = usr_id) join bicicleta on (ven_bic_id = bic_id) where usr_username = "lucky" order by bic_id;
select 'Consulta 5';
select usr_username, usr_nombre, usr_apellido from venta join bicicleta on (ven_bic_id=bic_id) join usuario  on (ven_usr_id=usr_id) where bic_marco = "M-4321";
select 'Consulta 6';
select count(mtb_id) from mtb where mtb_anio >= 2015;