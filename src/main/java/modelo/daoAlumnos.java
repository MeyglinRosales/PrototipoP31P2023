/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.clsAlumnos;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoAlumnos {

    private static final String SQL_SELECT = "SELECT carnet_alumno, nombre_alumno, direccion_alumno, telefono_alumno, email_alumno, estatus_alumno FROM alumnos";
    private static final String SQL_INSERT = "INSERT INTO alumnos (carnet_alumno, nombre_alumno, direccion_alumno, telefono_alumno, email_alumno, estatus_alumno) VALUES(?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE alumnos SET nombre_alumno=?, direccion_alumno=?, telefono_alumno=?, email_alumno=?, estatus_alumno=? WHERE carnet_alumno = ?";
    private static final String SQL_DELETE = "DELETE FROM alumnos WHERE carnet_alumno=?";
    private static final String SQL_SELECT_NOMBRE = "SELECT carnet_alumno, nombre_alumno, direccion_alumno, telefono_alumno, email_alumno, estatus_alumno FROM alumnos WHERE nombre_alumno = ?";
    private static final String SQL_SELECT_CODIGO = "SELECT carnet_alumno, nombre_alumno, direccion_alumno, telefono_alumno, email_alumno, estatus_alumno FROM alumnos WHERE carnet_alumno = ?";    

    public List<clsAlumnos> consultaAlum() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<clsAlumnos> alumnoss = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String codigo = rs.getString("carnet_alumno");
                String nombre = rs.getString("nombre_alumno");
                String direccion = rs.getString("direccion_alumno");
                String telefono = rs.getString("telefono_alumno");
                String email = rs.getString("email_alumno");
                String estatus = rs.getString("estatus_alumno");
                clsAlumnos alumnos = new clsAlumnos();
                alumnos.setCarnetAlumnos(codigo);
                alumnos.setNombreAlumnos(nombre);
                alumnos.setDireccionAlumnos(direccion);
                alumnos.setTelefonoAlumnos(telefono);
                alumnos.setEmailAlumnos(email);
                alumnos.setEstatusAlumnos(estatus);
                alumnoss.add(alumnos);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return alumnoss;
    }

    public int ingresaAlum(clsAlumnos alumnos) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, alumnos.getCarnetAlumnos());
            stmt.setString(2, alumnos.getNombreAlumnos());
            stmt.setString(3, alumnos.getDireccionAlumnos());
            stmt.setString(4, alumnos.getTelefonoAlumnos());
            stmt.setString(5, alumnos.getEmailAlumnos());
            stmt.setString(6, alumnos.getEstatusAlumnos());

            
            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int actualizaAlum(clsAlumnos alumnos) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, alumnos.getNombreAlumnos());
            stmt.setString(2, alumnos.getDireccionAlumnos());
            stmt.setString(3, alumnos.getTelefonoAlumnos());
            stmt.setString(4, alumnos.getEmailAlumnos());
            stmt.setString(5, alumnos.getEstatusAlumnos());
            stmt.setString(6, alumnos.getCarnetAlumnos());

            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado:" + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int borrarAlum(clsAlumnos alumnos) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, alumnos.getCarnetAlumnos());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public clsAlumnos consultaAlumPorNombre(clsAlumnos alumnos) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + alumnos);
            stmt = conn.prepareStatement(SQL_SELECT_NOMBRE);
            //stmt.setInt(1, usuario.getIdUsuario());            
            stmt.setString(1, alumnos.getNombreAlumnos());
            rs = stmt.executeQuery();
            while (rs.next()) {
                String codigo = rs.getString("carnet_alumno");
                String nombre = rs.getString("nombre_alumno");
                String direccion = rs.getString("direccion_alumno");
                String  telefono = rs.getString("telefono_alumno");
                String email = rs.getString("email_alumno");
                String estatus = rs.getString("estatus_alumno");

                //usuario = new clsUsuario();
                alumnos.setCarnetAlumnos(codigo);
                alumnos.setNombreAlumnos(nombre);
                alumnos.setDireccionAlumnos(direccion);
                alumnos.setTelefonoAlumnos(telefono);
                alumnos.setEmailAlumnos(email);
                alumnos.setEstatusAlumnos(estatus);
                System.out.println(" registro consultado: " + alumnos);                
            }
            //System.out.println("Registros buscado:" + persona);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        //return personas;  // Si se utiliza un ArrayList
        return alumnos;
    }
    public clsAlumnos consultaAlumPorCodigo(clsAlumnos alumnos) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + alumnos);
            stmt = conn.prepareStatement(SQL_SELECT_CODIGO);
            stmt.setString(1, alumnos.getCarnetAlumnos());            
            //stmt.setString(1, usuario.getNombreUsuario());
            rs = stmt.executeQuery();
            while (rs.next()) {
                String codigo = rs.getString("carnet_alumno");
                String nombre = rs.getString("nombre_alumno");
                String direccion = rs.getString("direccion_alumno");
                String telefono = rs.getString("telefono_alumno");
                String email = rs.getString("email_alumno");
                String estatus = rs.getString("estatus_alumno");

                //usuario = new clsUsuario();
                alumnos.setCarnetAlumnos(codigo);
                alumnos.setNombreAlumnos(nombre);
                alumnos.setDireccionAlumnos(direccion);
                alumnos.setTelefonoAlumnos(telefono);
                alumnos.setEmailAlumnos(email);
                alumnos.setEstatusAlumnos(estatus);
                System.out.println(" registro consultado: " + alumnos);                 
            }
            //System.out.println("Registros buscado:" + persona);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        //return personas;  // Si se utiliza un ArrayList
        return alumnos;
    }    
}
