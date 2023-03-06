/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.clsPuesto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoPuesto {

    private static final String SQL_SELECT = "SELECT codigo_puesto, nombre_puesto, estatus_puesto FROM puesto";
    private static final String SQL_INSERT = "INSERT INTO puesto(codigo_puesto, nombre_puesto, estatus_puesto) VALUES(?,?, ?)";
    private static final String SQL_UPDATE = "UPDATE puesto SET nombre_puesto=?, estatus_puesto=? WHERE codigo_puesto = ?";
    private static final String SQL_DELETE = "DELETE FROM puesto WHERE codigo_puesto=?";
    private static final String SQL_SELECT_NOMBRE = "SELECT codigo_puesto, nombre_puesto, estatus_puesto FROM puesto WHERE nombre_puesto = ?";
    private static final String SQL_SELECT_CODIGO = "SELECT codigo_puesto, nombre_puesto, estatus_puesto FROM puesto WHERE codigo_puesto = ?";    

    public List<clsPuesto> consultaPue() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<clsPuesto> puestoss = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String codigo = rs.getString("codigo_aula");
                String nombre = rs.getString("nombre_aula");
                String estatus = rs.getString("estatus_aula");
                clsPuesto puestos = new clsPuesto();
                puestos.setCodigoPuesto (codigo);
                puestos.setNombrePuesto (nombre);
                puestos.setEstatusPuesto (estatus);
                puestoss.add(puestos);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return puestoss;
    }

    public int ingresaPue(clsPuesto puestos) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, puestos.getCodigoPuesto ());
            stmt.setString(2, puestos.getNombrePuesto ());
            stmt.setString(3, puestos.getEstatusPuesto ());

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

    public int actualizaPue(clsPuesto puestos) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, puestos.getNombrePuesto ());
            stmt.setString(2, puestos.getEstatusPuesto ());
            stmt.setString(3, puestos.getCodigoPuesto ());

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

    public int borrarPue(clsPuesto puestos) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, puestos.getCodigoPuesto ());
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

    public clsPuesto consultaPuePorNombre(clsPuesto puestos) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + puestos);
            stmt = conn.prepareStatement(SQL_SELECT_NOMBRE);
            //stmt.setInt(1, usuario.getIdUsuario());            
            stmt.setString(1, puestos.getNombrePuesto ());
            rs = stmt.executeQuery();
            while (rs.next()) {
                String codigo = rs.getString("codigo_aula");
                String nombre = rs.getString("nombre_aula");
                String estatus = rs.getString("estatus_aula");

                //usuario = new clsUsuario();
                puestos.setCodigoPuesto (codigo);
                puestos.setNombrePuesto (nombre);
                puestos.setEstatusPuesto (estatus);
                System.out.println(" registro consultado: " + puestos);                
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
        return puestos;
    }
    public clsPuesto consultaPuePorCodigo(clsPuesto puestos) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + puestos);
            stmt = conn.prepareStatement(SQL_SELECT_CODIGO);
            stmt.setString(1, puestos.getCodigoPuesto ());            
            //stmt.setString(1, usuario.getNombreUsuario());
            rs = stmt.executeQuery();
            while (rs.next()) {
                String codigo = rs.getString("codigo_aula");
                String nombre = rs.getString("nombre_aula");
                String estatus = rs.getString("estatus_aula");

                //usuario = new clsUsuario();
                puestos.setCodigoPuesto (codigo);
                puestos.setNombrePuesto (nombre);
                puestos.setEstatusPuesto (estatus);
                System.out.println(" registro consultado: " + puestos);                 
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
        return puestos;
    }    
}
