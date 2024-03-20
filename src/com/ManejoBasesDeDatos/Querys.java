package com.ManejoBasesDeDatos;

import com.model.ModelClass;
import com.model.ModelDocente;
import com.model.ModelSeccion;
import com.model.ModelStudent;
import com.model.ModelStudentGrade;
import com.roles.Rol;
import com.roles.Usuario;
import com.swing.table.ModelProfile;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lenovo
 */
public class Querys {

    String url = "jdbc:sqlserver://localhost;databaseName=PruebaDeCafe;integratedSecurity=true;trustServerCertificate=true";
    Connection connection;

    public Querys() {

        try (Connection connection = DriverManager.getConnection(url)) {

        } catch (SQLException e) {
            // Connection failed
            System.err.println("Failed to connect to the database: " + e.getMessage());
        }

    }

    public ModelDocente getDocenteByCuenta(String cuenta) {
        ModelDocente dc = null;
        try {
            connection = DriverManager.getConnection(url);

            String sql = "SELECT * FROM Maestro WHERE NoCuenta = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, cuenta);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {

                String noCuenta, nombre;

                noCuenta = rs.getString("NoCuenta");
                nombre = rs.getString("Nombre");

                dc = new ModelDocente(noCuenta, nombre, "I", 0);
            }

            pstmt.close();
            return dc;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // TODO LO RELACIONADO A LA TABLA 'CLASE'
    public ModelClass getClaseByCodigo(String codigo) {
        ModelClass cl = null;
        try {
            connection = DriverManager.getConnection(url);

            String sql = "SELECT * FROM Clase WHERE CodClase = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, codigo);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {

                String cod, nombre, programa;
                int creditos;

                cod = rs.getString("CodClase");
                System.out.println(cod);
                nombre = rs.getString("NomClase");
                programa = rs.getString("Programa");
                creditos = rs.getInt("UnidadesV");

                cl = new ModelClass(cod, nombre, programa, creditos);
            }

            pstmt.close();
            return cl;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean insertClase(String codigo, String nombre, String programa, String creditos) {
        boolean v = false;
        try {
            connection = DriverManager.getConnection(url);

            if (getClaseByCodigo(codigo) == null) {
                String sql = "INSERT INTO Clase VALUES(?, ?, ?, ?)";
                PreparedStatement pstmt = connection.prepareStatement(sql);
                pstmt.setString(1, codigo);
                pstmt.setString(2, nombre);
                pstmt.setString(3, creditos);
                pstmt.setString(4, programa);

                int rs = pstmt.executeUpdate();

                v = (rs > 0);

                pstmt.close();
                return v;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return v;
    }
    
    public boolean DeleteClase(String codigo) {
        boolean v = false;
        try {
            connection = DriverManager.getConnection(url);

            if (getClaseByCodigo(codigo) != null) {
                String sql = "DELETE FROM Clase WHERE CodClase = ?;";
                PreparedStatement pstmt = connection.prepareStatement(sql);
                pstmt.setString(1, codigo);
                
                int rs = pstmt.executeUpdate();

                v = (rs > 0);

                pstmt.close();
                return v;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return v;
    }

    public List<ModelClass> selectTodasClases() {
        List<ModelClass> cls = null;
        try {
            connection = DriverManager.getConnection(url);
            Statement stmt = connection.createStatement();
            String sql = "SELECT * FROM Clase ";
            ResultSet rs = stmt.executeQuery(sql);

            String cod, nombre, programa;
            int creditos;

            cls = new ArrayList<>();

            while (rs.next()) {

                cod = rs.getString("CodClase");
                nombre = rs.getString("NomClase");
                creditos = rs.getInt("UnidadesV");

                programa = rs.getString("Programa");

                cls.add(new ModelClass(cod, nombre, programa, creditos));
            }

            stmt.close();
            return cls;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<ModelClass> selectTodasClasesByMaestro(String maestro) {
        List<ModelClass> cls = null;
        try {
            connection = DriverManager.getConnection(url);

            String sql = "SELECT * FROM Clase, Seccion WHERE Clase.CodClase = "
                    + "Seccion.CodClase AND Maestro = ?";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, maestro);

            ResultSet rs = pstmt.executeQuery();

            String cod, nombre, programa;
            int creditos;

            cls = new ArrayList<>();

            while (rs.next()) {

                cod = rs.getString("CodClase");
                nombre = rs.getString("NomClase");
                creditos = rs.getInt("UnidadesV");

                programa = rs.getString("Programa");

                cls.add(new ModelClass(cod, nombre, programa, creditos));
            }

            pstmt.close();
            return cls;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public int getCountEstudiantesInSeccion(String codClase, String noSeccion) {
        int n = 0;
        try {
            connection = DriverManager.getConnection(url);
            String sql = """
                         SELECT COUNT(Cursando.NoCuentaEstudiante) as Estudiantes FROM Cursando
                         WHERE CodClase = ? AND NoSeccion = ?""";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, codClase);
            pstmt.setString(2, noSeccion);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                n = rs.getInt("Estudiantes");
            }

            pstmt.close();
            return n;

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    // ************************************************************************************************************
    // TODO LO RELACIONADO A LA TABLA SECCION
    public ModelSeccion getSeccionByNoSeccion(String codClase, String noSeccion) {
        ModelSeccion sc = null;
        try {
            connection = DriverManager.getConnection(url);

            String sql = "SELECT * FROM Seccion WHERE CodClase = ? AND NoSeccion = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, codClase);
            pstmt.setString(2, noSeccion);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {

                String maestro;
                int max;

                max = rs.getInt("CantidadMax");
                maestro = rs.getString("Maestro");

                sc = new ModelSeccion(noSeccion, getClaseByCodigo(codClase), 0, max, getDocenteByCuenta(maestro));
            }

            pstmt.close();
            return sc;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public List<ModelSeccion> selectTodasSeccionesDisponibles() {
        List<ModelSeccion> scs = null;
        try {
            connection = DriverManager.getConnection(url);
            String sql = """
                         SELECT Seccion.CodClase, Seccion.NoSeccion, COUNT(Cursando.NoCuentaEstudiante) as Estudiantes, MAX(Seccion.CantidadMax) as MaxEst
                         FROM Cursando, Seccion
                         WHERE Cursando.CodClase = Seccion.CodClase AND Cursando.NoSeccion = Seccion.NoSeccion
                         GROUP BY Seccion.CodClase, Seccion.NoSeccion 
                         HAVING COUNT(DISTINCT Cursando.NoCuentaEstudiante) < MAX(Seccion.CantidadMax)
                         
                         UNION
                         
                         (SELECT CodClase, NoSeccion, 0 as Estudiantes, 0 as MaxEst
                         FROM Seccion
                         
                         EXCEPT
                         
                         SELECT Seccion.CodClase, Seccion.NoSeccion, 0 as Estudiantes, 0 as MaxEst
                         From Seccion, Cursando
                         WHERE Cursando.CodClase = Seccion.CodClase AND Cursando.NoSeccion = Seccion.NoSeccion
                         )""";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            

            ResultSet rs = pstmt.executeQuery();

            String noSeccion,codClase;

            scs = new ArrayList<>();
            
            ModelSeccion sc;
            while (rs.next()) {
                
                codClase = rs.getString("CodClase");
                noSeccion = rs.getString("NoSeccion");
                
                sc = getSeccionByNoSeccion(codClase, noSeccion);
                
                scs.add(sc);
                
            }

            pstmt.close();
            return scs;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<ModelSeccion> selectTodasSeccionesbyClase(String codClase) {
        List<ModelSeccion> scs = null;
        try {
            connection = DriverManager.getConnection(url);
            String sql = "SELECT * FROM Seccion WHERE CodClase = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, codClase);

            ResultSet rs = pstmt.executeQuery();

            String noSeccion, maestro;
            int max, n;

            scs = new ArrayList<>();

            while (rs.next()) {

                noSeccion = rs.getString("NoSeccion");
                maestro = rs.getString("Maestro");
                max = rs.getInt("CantidadMax");
                n = getCountEstudiantesInSeccion(codClase, noSeccion);

                scs.add(new ModelSeccion(noSeccion, getClaseByCodigo(codClase),
                        n, max, getDocenteByCuenta(maestro)));
            }

            pstmt.close();
            return scs;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public List<ModelSeccion> selectSeccionesbyClaseDocente(String codClase, String maestro) {
        List<ModelSeccion> scs = null;
        try {
            connection = DriverManager.getConnection(url);
            String sql = "SELECT * FROM Seccion WHERE CodClase = ?"
                    + " AND Maestro = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, codClase);
            pstmt.setString(2, maestro);

            ResultSet rs = pstmt.executeQuery();

            String noSeccion;
            int max, n;

            scs = new ArrayList<>();

            while (rs.next()) {

                noSeccion = rs.getString("NoSeccion");
                max = rs.getInt("CantidadMax");
                n = getCountEstudiantesInSeccion(codClase, noSeccion);

                scs.add(new ModelSeccion(noSeccion, getClaseByCodigo(codClase),
                        n, max, getDocenteByCuenta(maestro)));
            }

            pstmt.close();
            return scs;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean insertSeccion(String codClase, String noSeccion, String Maestro, String max) {
        boolean v = false;
        try {
            connection = DriverManager.getConnection(url);

            String sql = "INSERT INTO Seccion VALUES(?, ?, ?, ?, ?)";

            if (getDocenteByCuenta(Maestro) != null) {
                PreparedStatement pstmt = connection.prepareStatement(sql);
                pstmt.setString(1, codClase);
                pstmt.setString(2, noSeccion);
                pstmt.setString(3, Maestro);
                pstmt.setString(4, max);
                pstmt.setString(5, "");

                int rs = pstmt.executeUpdate();

                v = (rs > 0);

                pstmt.close();
                return v;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return v;
    }

    // ************************************************************************************************************
    // TODO LO RELACIONADO A LA TABLA CURSANDO
    public List<ModelStudentGrade> selectSeccionTodosEstudiantes(String codClase, String noSeccion) {
        List<ModelStudentGrade> sts = null;
        try {
            connection = DriverManager.getConnection(url);
            String sql = "SELECT * FROM Cursando WHERE CodClase = ? AND NoSeccion = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, codClase);
            pstmt.setString(2, noSeccion);

            ResultSet rs = pstmt.executeQuery();

            String cuenta;
            float nota;

            sts = new ArrayList<>();

            while (rs.next()) {

                cuenta = rs.getString("NoCuentaEstudiante");
                nota = rs.getFloat("Nota");

                sts.add(new ModelStudentGrade(getEstudianteByCuenta(cuenta), nota));
            }

            pstmt.close();
            return sts;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean insertEstudianteSeccion(String codClase, String noSeccion, String cuenta) {
        boolean v = false;
        try {
            connection = DriverManager.getConnection(url);

            String sql = "INSERT INTO Cursando VALUES(?, ?, ?, ?)";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, codClase);
            pstmt.setString(2, noSeccion);
            pstmt.setString(3, cuenta);
            pstmt.setFloat(4, 0.0f);

            int rs = pstmt.executeUpdate();

            v = (rs > 0);

            pstmt.close();
            return v;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public ModelStudentGrade selectEstudianteSeccionByCuenta(String codClase, String noSeccion, String cuenta) {
        ModelStudentGrade st = null;
        try {
            connection = DriverManager.getConnection(url);
            String sql = "SELECT * FROM Cursando WHERE CodClase = ? AND NoSeccion = ? AND NoCuentaEstudiante = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, codClase);
            pstmt.setString(2, noSeccion);
            pstmt.setString(3, cuenta);

            ResultSet rs = pstmt.executeQuery();
            float nota;

            if (rs.next()) {
                nota = rs.getFloat("Nota");

                st = new ModelStudentGrade(getEstudianteByCuenta(cuenta), nota);
            }

            pstmt.close();
            return st;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean updateNotaEstudianteSeccion(String codClase, String noSeccion, String cuenta, float nota) {
        boolean v = false;
        try {
            connection = DriverManager.getConnection(url);

            String sql = "UPDATE Cursando SET Nota = ? WHERE CodClase = ? AND "
                    + "NoSeccion = ? AND NoCuentaEstudiante = ?";

            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setFloat(1, nota);
            pstmt.setString(2, codClase);
            pstmt.setString(3, noSeccion);
            pstmt.setString(4, cuenta);

            int rs = pstmt.executeUpdate();

            v = (rs > 0);

            pstmt.close();
            return v;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Object[]> selectCursandoByEstudiante(String cuenta) {
        List<Object[]> sts = null;
        try {
            connection = DriverManager.getConnection(url);
            String sql = """
                         SELECT Clase.CodClase, NomClase, NoSeccion, Nota
                         FROM Cursando, Clase 
                         WHERE Clase.CodClase = Cursando.CodClase
                         AND NoCuentaEstudiante = ?""";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, cuenta);

            ResultSet rs = pstmt.executeQuery();

            String codClase, noSeccion, nomClase;
            float nota;

            sts = new ArrayList<>();

            while (rs.next()) {

                codClase = rs.getString("CodClase");
                noSeccion = rs.getString("NoSeccion");
                nomClase = rs.getString("NomClase");
                nota = rs.getFloat("Nota");

                sts.add(new Object[]{
                    new ModelProfile(ModelClass.generarIcon(), codClase),
                    nomClase, noSeccion, nota});
            }

            pstmt.close();
            return sts;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // ************************************************************************************************************
    // TODO LO RELACIONADO A LA TABLA ESTUDIANTE
    public ModelStudent getEstudianteByCuenta(String cuenta) {
        ModelStudent dc = null;
        try {
            connection = DriverManager.getConnection(url);

            String sql = "SELECT * FROM Estudiante WHERE NoCuenta = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, cuenta);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {

                String nombre, carrera;
                nombre = rs.getString("Nombre");
                carrera = rs.getString("Carrera");

                dc = new ModelStudent(null, nombre, "I", carrera, cuenta);
            }

            pstmt.close();
            return dc;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Usuario validarCredenciales(String cuenta, String password) {
        Usuario user = null;

        try {

            connection = DriverManager.getConnection(url);

            String sql = "SELECT * FROM Credenciales WHERE NoCuenta = ? AND Password = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, cuenta);
            pstmt.setString(2, password);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                // Buscar el rol que tiene;
                String name = getCoordinadorNamebyCuenta(connection, cuenta);
                if (name != null) {
                    user = new Usuario(cuenta, name, "", new Rol(Rol.Tipo.COORDINADOR), null);
                } else {
                    name = getEstudianteNamebyCuenta(connection, cuenta);

                    if (name != null) {
                        user = new Usuario(cuenta, name, cuenta, new Rol(Rol.Tipo.ESTUDIANTE), null);
                    } else {
                        name = getMaestroNamebyCuenta(connection, cuenta);

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

    private String getCoordinadorNamebyCuenta(Connection connection, String cuenta) {

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

    private String getEstudianteNamebyCuenta(Connection connection, String cuenta) {
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

    private String getMaestroNamebyCuenta(Connection connection, String cuenta) {
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

    public void InsertEstudiante(String Nombre, String Nocuenta, String Carrera) {

        try {
            connection = DriverManager.getConnection(url);

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

    public void InsertMaestro(String Nombre, String Nocuenta, String Departamento) {

        try {
            connection = DriverManager.getConnection(url);
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

    public void InsertCoordinador(String Nombre, String Nocuenta, String Departamento) {

        try {
            connection = DriverManager.getConnection(url);
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

    public void InsertSeccion(String NombreMaestro, String Noseccion, String Programa, String Cantidad, String Hora, String creditos) {

        try {
            connection = DriverManager.getConnection(url);
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

    public void InsertCursando(String NoSeccion, String Nocuenta, double NotadeClase) {

        try {
            connection = DriverManager.getConnection(url);
            String sql = "INSERT INTO Cursando (NoCuentaEstudiante ,NoSeccion ,NotaDeClase) VALUES (?, ?, ?)";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, Nocuenta);
            pstmt.setString(2, NoSeccion);
            pstmt.setDouble(3, NotadeClase);

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

    public void InsertCatedra(String NoSeccion, String Nocuenta) {

        try {
            connection = DriverManager.getConnection(url);
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

    public void InsertAsignacion(String NoSeccion, String Nocuenta, String Nota, String Asignacion) {

        try {
            connection = DriverManager.getConnection(url);
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

    public void DeleteEstudiante(String Nocuenta) {

        try {
            connection = DriverManager.getConnection(url);
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

    public void DeleteMaestro(String Nocuenta) {

        try {
            connection = DriverManager.getConnection(url);
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

    public void DeleteCoordinador(String Nocuenta) {

        try {
            connection = DriverManager.getConnection(url);
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

    public void DeleteSeccion(String Noseccion) {

        try {
            connection = DriverManager.getConnection(url);
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

    public void DeleteAsignacion(String Asignacion) {

        try {
            connection = DriverManager.getConnection(url);
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

    public void DeleteEstudianteCursando(String Nocuenta, String NoSeccion) {

        try {
            connection = DriverManager.getConnection(url);
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

    public void DeleteSeccionCursando(String NoSeccion) {

        try {
            connection = DriverManager.getConnection(url);
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

    public void DeleteSeccionCatedra(String NoSeccion) {

        try {
            connection = DriverManager.getConnection(url);
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

    public void DeleteMaestroCatedra(String Nocuenta, String Noseccion) {

        try {
            connection = DriverManager.getConnection(url);
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

    public ResultSet MostrarListadoEstudiantesEnUnaClase(String Nocuenta, String Noseccion) {

        try {
            connection = DriverManager.getConnection(url);
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

    public ResultSet VerSeccionesCoordinadores() {

        try {
            connection = DriverManager.getConnection(url);
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

    public ResultSet VerSeccionesMaestro(String NoMaestro) {

        try {
            connection = DriverManager.getConnection(url);
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

    public ResultSet VerNotasEstudiantes(String NoCuenta, String NoSeccion) {

        try {
            connection = DriverManager.getConnection(url);
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

    public void UpdateNotas(String NoCuenta, String NoCuentaMaestro, double Nota) {

        try {
            connection = DriverManager.getConnection(url);
            String sql = "UPDATE Asignaciones SET Nota = ? WHERE NoSeccion IN ( SELECT NoSeccion FROM Seccion WHERE Maestro = ? ) AND NoCuentaEstudiante = ?;";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setDouble(1, Nota);
            pstmt.setString(2, NoCuentaMaestro);
            pstmt.setString(3, NoCuenta);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Actualización exitosa.");

            } else {
                System.out.println("No se realizó ninguna actualización.");

            }

            pstmt.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

}
