create database metodologias_2;
use metodologias_2;
drop database metodologias_2;
CREATE USER 'UserRemoto'@'localhost' IDENTIFIED BY 'clinica16';
GRANT ALL PRIVILEGES ON * . * TO 'UserRemoto'@'localhost';
FLUSH PRIVILEGES;

drop table paciente;
create table paciente(
id integer(10)primary key,
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
cedula integer(10) null
);

insert into usuarios values("soka","Psicologo","Juan Pablo Lazaro Ruiz","Perrotonto",12345);
insert into usuarios values("frantata","Asistente","Francisco Angel Reyes Jacome","1234",null);
insert into usuarios values("Manu","Psicologo","Jose Manuel Iñiguez Lopez","Gatolisto",6789);
insert into usuarios values("Dangj","Asistente","Daniel Garcia Jacome","Pokemon",null);

select * from usuarios;
select rol from usuarios;
select contrasena_usuario from usuarios;
select nombre_usuario from usuarios;
select cedula from usuarios;
select nombre_completo from usuarios;


#insert into paciente values(´'1','Juan Pérez', '15/05/1990', 'Casado', 'Licenciatura', 'Ingeniero');
insert into paciente values ('2','María González', '20/03/1985', 'Soltero', 'Bachillerato', 'Estudiante');
insert into paciente values ('3','Ana Sánchez', '10/07/1995', 'Casado', 'Bachillerato', 'Abogado');
insert into paciente values ('4','Luis García', '25/11/1982', 'Soltero', 'Doctorado', 'Profesor');
insert into paciente values ('5','Laura Rodríguez', '30/09/1998', 'Casado', 'Licenciatura', 'Arquitecto');
insert into paciente values('6','Carlos López', '12/04/1987', 'Soltero', 'Maestría', 'Contador');
insert into paciente values ('7','Sofía Martínez', '08/02/1993', 'Casado', 'Bachillerato', 'Enfermero');
insert into paciente values('8','Diego Torres', '18/06/1997', 'Soltero', 'Licenciatura', 'Programador');
insert into paciente values('9','Valentina Fernández', '22/08/1991', 'Casado', 'Doctorado', 'Dentista');
insert into paciente values('10','Miguel Ramírez', '05/12/1989', 'Soltero', 'Maestría', 'Psicólogo');

select * from paciente;
select nombre from paciente;
select fecha_nacimiento from paciente;
select estado_civil from paciente;
select nivel_estudios from paciente;
select ocupacion from paciente;


