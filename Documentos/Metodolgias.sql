create database metodologias_2;
use metodologias_2;
drop database metodologias_2;

drop table paciente;
create table paciente(
id integer primary key,
nombre varchar(30)not null,
fecha_nacimiento varchar(40) not null,
estado_civil varchar(30),
nivel_estudios varchar(30),
ocupacion varchar(30) not null,
papaelria integer not null
);

drop table usuarios;
create table usuarios(
nombre_usuario varchar(30) primary key,
rol varchar(30) not null,
nombre_completo  varchar(30),
contrasena_usuario varchar(30) not null,
cedula integer null
);

drop table adminni;
create table adminni(
nombre_usuario varchar(30) primary key,
contrasena_usuario varchar(30) not null
);

#Vistas
CREATE 
    ALGORITHM = UNDEFINED 
    DEFINER = `root`@`localhost` 
    SQL SECURITY DEFINER
VIEW `metodologias_2`.`vpacientes` AS
    SELECT 
        `metodologias_2`.`paciente`.`Id` AS `Id`,
        `metodologias_2`.`paciente`.`Nombre` AS `Nombre`,
        `metodologias_2`.`paciente`.`Fecha_Nacimiento` AS `Fecha_De_Nacimiento`,
        `metodologias_2`.`paciente`.`Estado_Civil` AS `Estado_civil`,
        `metodologias_2`.`paciente`.`Nivel_Estudios` AS `Nivel_De_Estudios`,
        `metodologias_2`.`paciente`.`Ocupacion` AS `Ocupacion`
    FROM
        `metodologias_2`.`paciente`
    WHERE
        (`metodologias_2`.`paciente`.`papeleria` = 0);

CREATE 
    ALGORITHM = UNDEFINED 
    DEFINER = `root`@`localhost` 
    SQL SECURITY DEFINER
VIEW `metodologias_2`.`vpacientes` AS
    SELECT 
        `metodologias_2`.`paciente`.`Id` AS `Id`,
        `metodologias_2`.`paciente`.`Nombre` AS `Nombre`,
        `metodologias_2`.`paciente`.`Fecha_Nacimiento` AS `Fecha_De_Nacimiento`,
        `metodologias_2`.`paciente`.`Estado_Civil` AS `Estado_civil`,
        `metodologias_2`.`paciente`.`Nivel_Estudios` AS `Nivel_De_Estudios`,
        `metodologias_2`.`paciente`.`Ocupacion` AS `Ocupacion`
    FROM
        `metodologias_2`.`paciente`
    WHERE
        (`metodologias_2`.`paciente`.`papeleria` = 0);
        
insert into admini values("admin","qwerty");

insert into usuarios values("soka","Psicologo","Juan Pablo Lazaro Ruiz","Perrotonto",12345);
insert into usuarios values("frantata","Asistente","Francisco Angel Reyes Jacome","1234",null);
insert into usuarios values("Manu","Psicologo","Jose Manuel Iñiguez Lopez","Gatolisto",6789);
insert into usuarios values("Dangj","Asistente","Daniel Garcia Jacome","Pokemon",null);

