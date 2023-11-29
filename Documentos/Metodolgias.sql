create database metodologias_2;
use metodologias_2;
drop database metodologias_2;

drop table paciente;
create table paciente(
id integer primary key AUTO_INCREMENT,
nombre varchar(30)not null,
fecha_nacimiento varchar(40) not null,
estado_civil varchar(30),
nivel_estudios varchar(30),
ocupacion varchar(30) not null
);

drop table usuarios;
create table usuarios(
nombre_usuario varchar(30) primary key,
rol varchar(30) not null,
nombre_completo  varchar(30),
contrasena_usuario varchar(30) not null,
cedula integer null
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
        
        
drop table cita;
create table cita(
nombre_usuario varchar(30),
id integer,
fechaC varchar(40) not null,
hora varchar(10) not null,
descripcion varchar(100) null,
primary key(nombre_usuario, id),
foreign key(nombre_usuario) references usuarios(nombre_usuario),
foreign key(id) references paciente(id)
);  
        
drop table registro;        
create table registro(
id integer primary key AUTO_INCREMENT,
informacion varchar(50)
);
#Vista de Citas
CREATE 
    ALGORITHM = UNDEFINED 
    DEFINER = `root`@`localhost` 
    SQL SECURITY DEFINER
VIEW `metodologias_2`.`citasvista` AS
    SELECT 
        `p`.`Nombre` AS `Paciente`,
        `u`.`nombre_completo` AS `Psicologo`,
        `t`.`fechaC` AS `Fecha`,
        `t`.`hora` AS `Hora`
    FROM
        ((`metodologias_2`.`cita` `t`
        JOIN `metodologias_2`.`paciente` `p`)
        JOIN `metodologias_2`.`usuarios` `u`)
    WHERE
        ((`u`.`nombre_usuario` = `t`.`nombre_usuario`)
            AND (`p`.`Id` = `t`.`id`));
        
insert into usuarios values("admin","Administrador","JJ","qwerty",1234572);
insert into usuarios values("soka","Psicologo","Juan Pablo Lazaro Ruiz","Perrotonto",12345);
insert into usuarios values("frantata","Asistente","Francisco Angel Reyes Jacome","1234",null);
insert into usuarios values("Manu","Psicologo","Jose Manuel Iñiguez Lopez","Gatolisto",6789);
insert into usuarios values("Dangj","Asistente","Daniel Garcia Jacome","Pokemon",null);





