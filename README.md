# ProyectoMetodo 
## Actualizacion del Proyecto se implemento el avance de los pacientes con las funciones del CRUD
## lo que se hizo en la base de Datos es que se crearon dos vistas las cuales puedes crearlas 
vista 1:
CREATE VIEW `vpacientes` AS select  id,
nombre,
fecha_nacimiento,
estado_civil,
nivel_estudios,
ocupacion from paciente
where papeleria =0;

vista 2:

CREATE VIEW `vpacientesenb` AS select  id,
nombre,
fecha_nacimiento,
estado_civil,
nivel_estudios,
ocupacion from paciente
where papeleria =1;

esto con el fin de la papeleria de reciclaje 

## a su ves se actualizo la tabla paciente quedando de la siguinete forma:

create table paciente(
id integer(10)primary key,
nombre varchar(30)not null,
fecha_nacimiento varchar(40) not null,
estado_civil varchar(30),
nivel_estudios varchar(30),
ocupacion varchar(30) not null,
papeleria integer
);
## valores agregados:
insert into paciente values(1,'Juan Pérez', '15/05/1990', 'Casado', 'Licenciatura', 'Ingeniero',0);
insert into paciente values (2,'María González', '20/03/1985', 'Soltero', 'Bachillerato', 'Estudiante',1);
insert into paciente values (3,'Ana Sánchez', '10/07/1995', 'Casado', 'Bachillerato', 'Abogado',0);
insert into paciente values (4,'Luis García', '25/11/1982', 'Soltero', 'Doctorado', 'Profesor',0);
insert into paciente values (5,'Laura Rodríguez', '30/09/1998', 'Casado', 'Licenciatura', 'Arquitecto',0);
insert into paciente values(6,'Carlos López', '12/04/1987', 'Soltero', 'Maestría', 'Contador',0);
insert into paciente values (7,'Sofía Martínez', '08/02/1993', 'Casado', 'Bachillerato', 'Enfermero',0);
insert into paciente values(8,'Diego Torres', '18/06/1997', 'Soltero', 'Licenciatura', 'Programador',0);
insert into paciente values(9,'Valentina Fernández', '22/08/1991', 'Casado', 'Doctorado', 'Dentista',1);
insert into paciente values(10,'Miguel Ramírez', '05/12/1989', 'Soltero', 'Maestría', 'Psicólogo',0);
insert into paciente values(11,'Miguel ez', '05/12/1989', 'Soltero', 'Maestría', 'Psicólogo',0);

