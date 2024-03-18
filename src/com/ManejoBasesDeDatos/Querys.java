package com.ManejoBasesDeDatos;

import com.roles.Rol;
import com.roles.Usuario;
import java.sql.*;

/**
 *
 * @author lenovo
 */
public class Querys {

    String url = "jdbc:sqlserver://localhost;databaseName=PruebaDeCafe;integratedSecurity=true;trustServerCertificate=true";
    Connection connection;

    public Querys() {

        try (Connection connection = DriverManager.getConnection(url)) {

            System.out.println("Connected to the database.");
        } catch (SQLException e) {
            // Connection failed
            System.err.println("Failed to connect to the database: " + e.getMessage());
        }

    }

    public Usuario validarCredenciales(String cuenta, String password) {
        Usuario user = null;

        try {
            Connection connection = DriverManager.getConnection(url);
            
            String sql = "SELECT * FROM Credenciales WHERE NoCuenta = ? AND password = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, cuenta);
            pstmt.setString(2, password);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                // Buscar el rol que tiene;
                String name = getCoordinadorUser(connection, cuenta);
                if (name != null) {
                    user = new Usuario(cuenta, name, cuenta, new Rol(Rol.Tipo.COORDINADOR), null);
                } else {
                    name = getEstudianteUser(connection, cuenta);

                    if (name != null) {
                        user = new Usuario(cuenta, name, cuenta, new Rol(Rol.Tipo.ESTUDIANTE), null);
                    } else {
                        name = getMaestroUser(connection, cuenta);

                        if (name != null) {
                            user = new Usuario(cuenta, name, cuenta, new Rol(Rol.Tipo.DOCENTE), null);
                        }
                    }
                }

                pstmt.close();
                return user;
            } else {
                pstmt.close();
                System.out.println("Credeciales invalidas.");
                return user;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }

    private String getCoordinadorUser(Connection connection, String cuenta) {

        try {
            Statement stmt = connection.createStatement();
            String sql = "select Coor_Nombre from Coordinador where NoCuenta=" + cuenta;
            ResultSet rs = stmt.executeQuery(sql);

            String name = null;
            if (rs.next()) {

                name = rs.getString("Coor_Nombre");
            } else {
                return null;
            }

            rs.close();
            return name;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    private String getEstudianteUser(Connection connection, String cuenta) {
        try {
            Statement stmt = connection.createStatement();
            String sql = "select Nombre from Estudiante where NoCuenta=" + cuenta;
            ResultSet rs = stmt.executeQuery(sql);

            String name = null;
            if (rs.next()) {
                name = rs.getString("Nombre");
            }

            stmt.close();
            return name;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private String getMaestroUser(Connection connection, String cuenta) {
        try {
            Statement stmt = connection.createStatement();
            String sql = "select Nombre from Maestro where NoCuenta=" + cuenta;
            ResultSet rs = stmt.executeQuery(sql);

            String name = null;

            if (rs.next()) {
                name = rs.getString("Nombre");
            }

            stmt.close();

            return name;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void InsertEstudiante(Connection connection, String Nombre, String Nocuenta, String Carrera) {

        try {
            String sql = "INSERT INTO Estudiante (NoCuenta, Nombre, Carrera) VALUES (?, ?, ?)";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, Nocuenta);
            pstmt.setString(2, Nombre);
            pstmt.setString(3, Carrera);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Inserción exitosa.");
            } else {
                System.out.println("No se realizó ninguna inserción.");
            }

            pstmt.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void InsertMaestro(Connection connection, String Nombre, String Nocuenta, String Departamento) {

        try {
            String sql = "INSERT INTO Maestro (NoCuenta, Nombre, Departamento) VALUES (?, ?, ?)";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, Nocuenta);
            pstmt.setString(2, Nombre);
            pstmt.setString(3, Departamento);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Inserción exitosa.");
            } else {
                System.out.println("No se realizó ninguna inserción.");
            }

            pstmt.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void InsertCoordinador(Connection connection, String Nombre, String Nocuenta, String Departamento) {

        try {
            String sql = "INSERT INTO Coordinador (NoCuenta, Coor_Nombre, Departamento) VALUES (?, ?, ?)";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, Nocuenta);
            pstmt.setString(2, Nombre);
            pstmt.setString(3, Departamento);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Inserción exitosa.");
            } else {
                System.out.println("No se realizó ninguna inserción.");
            }

            pstmt.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void InsertSeccion(Connection connection, String NombreMaestro, String Noseccion, String Programa, String Cantidad, String Hora, String creditos) {

        try {
            String sql = "INSERT INTO Seccion (NoSeccion, Maestro, Creditos, Programa, CantidadMax, Hora) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, Noseccion);
            pstmt.setString(2, NombreMaestro);
            pstmt.setString(3, creditos);
            pstmt.setString(3, creditos);
            pstmt.setString(4, Programa);
            pstmt.setString(5, Cantidad);
            pstmt.setString(6, Hora);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Inserción exitosa.");
            } else {
                System.out.println("No se realizó ninguna inserción.");
            }

            pstmt.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void InsertCursando(Connection connection, String NoSeccion, String Nocuenta, int NotadeClase) {

        try {
            String sql = "INSERT INTO Cursando (NoCuentaEstudiante ,NoSeccion ,NotaDeClase) VALUES (?, ?, ?)";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, Nocuenta);
            pstmt.setString(2, NoSeccion);
            pstmt.setInt(3, NotadeClase);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Inserción exitosa.");
            } else {
                System.out.println("No se realizó ninguna inserción.");
            }

            pstmt.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void InsertCatedra(Connection connection, String NoSeccion, String Nocuenta) {

        try {
            String sql = "INSERT INTO Cursando (NoCuentaMaestro ,NoSeccion) VALUES (?, ?)";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, Nocuenta);
            pstmt.setString(2, NoSeccion);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Inserción exitosa.");
            } else {
                System.out.println("No se realizó ninguna inserción.");
            }

            pstmt.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void InsertAsignacion(Connection connection, String NoSeccion, String Nocuenta, String Nota, String Asignacion) {

        try {
            String sql = "INSERT INTO Asignacion (NoSeccion,NocuentaEstudiante,Nota,Asignacion) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, NoSeccion);
            pstmt.setString(2, Nocuenta);
            pstmt.setString(3, Nota);
            pstmt.setString(4, Asignacion);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Inserción exitosa.");
            } else {
                System.out.println("No se realizó ninguna inserción.");
            }

            pstmt.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void DeleteEstudiante(Connection connection, String Nocuenta) {

        try {
            String sql = "DELETE FROM Estudiante WHERE NoCuenta = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, Nocuenta);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Eliminacion exitosa.");
            } else {
                System.out.println("No se realizó ninguna eliminacion.");
            }

            pstmt.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void DeleteMaestro(Connection connection, String Nocuenta) {

        try {
            String sql = "DELETE FROM Maestro WHERE NoCuenta = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, Nocuenta);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Eliminacion exitosa.");
            } else {
                System.out.println("No se realizó ninguna eliminacion.");
            }

            pstmt.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void DeleteCoordinador(Connection connection, String Nocuenta) {

        try {
            String sql = "DELETE FROM Coordinador WHERE NoCuenta = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, Nocuenta);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Eliminacion exitosa.");
            } else {
                System.out.println("No se realizó ninguna eliminacion.");
            }

            pstmt.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void DeleteSeccion(Connection connection, String Noseccion) {

        try {
            String sql = "DELETE FROM Seccion WHERE NoSeccion = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, Noseccion);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Eliminacion exitosa.");
            } else {
                System.out.println("No se realizó ninguna eliminacion.");
            }

            pstmt.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void DeleteAsignacion(Connection connection, String Asignacion) {

        try {
            String sql = "DELETE FROM Estudiante WHERE Asignacion = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, Asignacion);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Eliminacion exitosa.");
            } else {
                System.out.println("No se realizó ninguna eliminacion.");
            }

            pstmt.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void DeleteEstudianteCursando(Connection connection, String Nocuenta, String NoSeccion) {

        try {
            String sql = "DELETE FROM Estudiante WHERE NoCuenta = ? and NoSeccion = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, Nocuenta);
            pstmt.setString(2, NoSeccion);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Eliminacion exitosa.");
            } else {
                System.out.println("No se realizó ninguna eliminacion.");
            }

            pstmt.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void DeleteSeccionCursando(Connection connection, String NoSeccion) {

        try {
            String sql = "DELETE FROM Estudiante WHERE  NoSeccion = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, NoSeccion);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Eliminacion exitosa.");
            } else {
                System.out.println("No se realizó ninguna eliminacion.");
            }

            pstmt.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void DeleteSeccionCatedra(Connection connection, String NoSeccion) {

        try {
            String sql = "DELETE FROM Catedra WHERE NoSeccion = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, NoSeccion);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Eliminacion exitosa.");
            } else {
                System.out.println("No se realizó ninguna eliminacion.");
            }

            pstmt.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void DeleteMaestroCatedra(Connection connection, String Nocuenta, String Noseccion) {

        try {
            String sql = "DELETE FROM Catedra WHERE NoCuentaMaestra = ? and NoSeccion = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, Nocuenta);
            pstmt.setString(2, Noseccion);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Eliminacion exitosa.");
            } else {
                System.out.println("No se realizó ninguna eliminacion.");
            }

            pstmt.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ResultSet MostrarListadoEstudiantesEnUnaClase(Connection connection, String Nocuenta, String Noseccion) {

        try {
            Statement stmt = connection.createStatement();
            String sql = "select NoCuenta,Nombre from PruebaDeCafe.Estudiante,Pruebadecafe.Cursando where table.NoSeccion=" + Noseccion;
            ResultSet rs = stmt.executeQuery(sql);
            stmt.close();
            return rs;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ResultSet VerSeccionesCoordinadores(Connection connection) {

        try {
            Statement stmt = connection.createStatement();
            String sql = "select NoSeccion,Maestro,Creditos,Programa,Hora from PruebaDeCafe.Seccion";
            ResultSet rs = stmt.executeQuery(sql);
            stmt.close();
            return rs;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ResultSet VerSeccionesMaestro(Connection connection, String NoMaestro) {

        try {
            Statement stmt = connection.createStatement();
            String sql = "select NoSeccion, Creditos,Programa, CantidadMax from PruebaDeCafe.Seccion where Maestro=" + NoMaestro;
            ResultSet rs = stmt.executeQuery(sql);
            stmt.close();
            return rs;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ResultSet VerNotasEstudiantes(Connection connection, String NoCuenta, String NoSeccion) {

        try {
            Statement stmt = connection.createStatement();
            String sql = "select Asignacion,Nota from PruebaDeCafe.Asignacion,PruebaDeCafe.Seccion where NoCuenta=" + NoCuenta + " and NoSeccion=" + NoSeccion;
            ResultSet rs = stmt.executeQuery(sql);
            stmt.close();
            return rs;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
