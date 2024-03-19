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

IF NOT EXISTS (SELECT * FROM sysobjects WHERE name='Credenciales' and xtype='U')
BEGIN
    CREATE TABLE Credenciales (
        NoCuenta varchar(30) not null primary key,
		password varchar(50) not null
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

IF NOT EXISTS (SELECT * FROM sysobjects WHERE name='Seccion' AND xtype='U')
BEGIN
  CREATE TABLE Seccion (
    NoSeccion varchar(30) PRIMARY KEY NOT NULL,
    Maestro varchar(30),
    Nota varchar(30),  
    Creditos varchar(30),
    Programa varchar(30),
    CantidadMax varchar(30),
    Hora varchar(30)
  );
END;


ALTER TABLE Seccion ALTER COLUMN Nota float(8)



