if not exists(Select * from sys.databases where name = 'PruebaDeCafe' )
begin
create database PruebaDeCafe
end

GO
  USE [PruebaDeCafe]
GO

IF NOT EXISTS (SELECT * FROM sysobjects WHERE name='Coordinador' and xtype='U')
BEGIN
    CREATE TABLE Coordinador (
        NoCuenta varchar(30) not null primary key,
		Coor_Nombre varchar(30),
		Departamento varchar(30)
    )
END

IF NOT EXISTS (SELECT * FROM sysobjects WHERE name='Estudiante' and xtype='U')
BEGIN
    CREATE TABLE Estudiante (
        NoCuenta varchar(30) not null primary key,
		Nombre varchar(30),
		Carrera varchar(30),
		Clases varchar(30),
		NotaDeClase varchar(10)
    )
END

IF NOT EXISTS (SELECT * FROM sysobjects WHERE name='Maestro' AND xtype='U')
BEGIN
  CREATE TABLE Maestro (
    NoCuenta varchar(30) NOT NULL PRIMARY KEY,
    Nombre varchar(30),
    Departamento varchar(30)
  );
END;

IF NOT EXISTS (SELECT * FROM sysobjects WHERE name='Credenciales' AND xtype='U')
BEGIN
  CREATE TABLE Credenciales (
    NoCuenta varchar(30) NOT NULL PRIMARY KEY,
    Password varchar(50) NOT NULL
  );
END;

IF NOT EXISTS (SELECT * FROM sysobjects WHERE name='Clase' AND xtype='U')
BEGIN
  CREATE TABLE Clase (
    CodClase varchar(30) PRIMARY KEY NOT NULL,
	NomClase varchar(50) NOT NULL,
	UnidadesV int NOT NULL,
	Programa varchar(30),
    
  );
END;

IF NOT EXISTS (SELECT * FROM sysobjects WHERE name='Seccion' AND xtype='U')
BEGIN
  CREATE TABLE Seccion (
	CodClase varchar(30) NOT NULL,
    NoSeccion varchar(30) NOT NULL,
    Maestro varchar(30),
    CantidadMax varchar(30),
    Hora varchar(30),
	CONSTRAINT PK_Seccion PRIMARY KEY (CodClase, NoSeccion)
  );
END;

IF NOT EXISTS (SELECT * FROM sysobjects WHERE name='Asignacion' AND xtype='U')
BEGIN
  CREATE TABLE Asignacion (
    NoSeccion varchar(30) ,
    NoCuentaEstudiante varchar(30),
    Nota varchar(3),  
    Asignacion varchar(30)
  );
END;

IF NOT EXISTS (SELECT * FROM sysobjects WHERE name='Cursando' AND xtype='U')
BEGIN
  CREATE TABLE Cursando (
	CodClase varchar(30) NOT NULL,
    NoSeccion varchar(30) NOT NULL,
    NoCuentaEstudiante varchar(30) NOT NULL,
    Nota varchar(3),
	CONSTRAINT PK_Cursando PRIMARY KEY (CodClase, NoSeccion, NoCuentaEstudiante)
  );
END;

IF NOT EXISTS (SELECT * FROM sysobjects WHERE name='NotaClase' AND xtype='U')
BEGIN
  CREATE TABLE NotaClase (
	CodClase varchar(30),
    NoCuentaEstudiante varchar(30),
    Nota varchar(3),
	CONSTRAINT PK_NotaClase PRIMARY KEY (CodClase, NoCuentaEstudiante)
  );
END;

IF NOT EXISTS (SELECT * FROM sysobjects WHERE name='Catedra' AND xtype='U')
BEGIN
  CREATE TABLE Catedra (
    NoSeccion varchar(30) ,
    NoCuentaMaestro varchar(30),
  );
END;

ALTER TABLE Cursando ALTER COLUMN Nota float(8)

ALTER TABLE Asignacion ALTER COLUMN Nota float(8)

ALTER TABLE NotaClase ALTER COLUMN Nota float(8)

INSERT INTO Coordinador VALUES ('123','Julio Ramirez', 'Ciencias Matematicas')

INSERT INTO Credenciales VALUES ('123', 'elote200')