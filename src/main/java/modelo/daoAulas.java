/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.clsAulas;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoAulas {

    private static final String SQL_SELECT = "SELECT codigo_aula, nombre_aula, estatus_aula FROM aulas";
    private static final String SQL_INSERT = "INSERT INTO aulas (codigo_aula, nombre_aula, estatus_aula) VALUES(?,?, ?)";
    private static final String SQL_UPDATE = "UPDATE aulas SET nombre_aula=?, estatus_aula=? WHERE codigo_aula = ?";
    private static final String SQL_DELETE = "DELETE FROM aulas WHERE codigo_aula=?";
    private static final String SQL_SELECT_NOMBRE = "SELECT codigo_aula, nombre_aula, estatus_aula FROM aulas WHERE nombre_aula = ?";
    private static final String SQL_SELECT_CODIGO = "SELECT codigo_aula, nombre_aula, estatus_aula FROM aulas WHERE codigo_aula = ?";    

    public List<clsAulas> consultaAul() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<clsAulas> aulass = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String codigo = rs.getString("codigo_aula");
                String nombre = rs.getString("nombre_aula");
                String estatus = rs.getString("estatus_aula");
                clsAulas aulas = new clsAulas();
                aulas.setCodigoAulas(codigo);
                aulas.setNombreAulas(nombre);
                aulas.setEstatusAulas(estatus);
                aulass.add(aulas);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return aulass;
    }

    public int ingresaAul(clsAulas aulas) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, aulas.getCodigoAulas());
            stmt.setString(2, aulas.getNombreAulas());
            stmt.setString(3, aulas.getEstatusAulas());

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

    public int actualizaAul(clsAulas aulas) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, aulas.getNombreAulas());
            stmt.setString(2, aulas.getEstatusAulas());
            stmt.setString(3, aulas.getCodigoAulas());

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

    public int borrarAul(clsAulas aulas) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, aulas.getCodigoAulas());
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

    public clsAulas consultaAulPorNombre(clsAulas aulas) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + aulas);
            stmt = conn.prepareStatement(SQL_SELECT_NOMBRE);
            //stmt.setInt(1, usuario.getIdUsuario());            
            stmt.setString(1, aulas.getNombreAulas());
            rs = stmt.executeQuery();
            while (rs.next()) {
                String codigo = rs.getString("codigo_aula");
                String nombre = rs.getString("nombre_aula");
                String estatus = rs.getString("estatus_aula");

                //usuario = new clsUsuario();
                aulas.setCodigoAulas(codigo);
                aulas.setNombreAulas(nombre);
                aulas.setEstatusAulas(estatus);
                System.out.println(" registro consultado: " + aulas);                
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
        return aulas;
    }
    public clsAulas consultaAulPorCodigo(clsAulas aulas) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + aulas);
            stmt = conn.prepareStatement(SQL_SELECT_CODIGO);
            stmt.setString(1, aulas.getCodigoAulas());            
            //stmt.setString(1, usuario.getNombreUsuario());
            rs = stmt.executeQuery();
            while (rs.next()) {
                String codigo = rs.getString("codigo_aula");
                String nombre = rs.getString("nombre_aula");
                String estatus = rs.getString("estatus_aula");

                //usuario = new clsUsuario();
                aulas.setCodigoAulas(codigo);
                aulas.setNombreAulas(nombre);
                aulas.setEstatusAulas(estatus);
                System.out.println(" registro consultado: " + aulas);                 
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
        return aulas;
    }    
}
