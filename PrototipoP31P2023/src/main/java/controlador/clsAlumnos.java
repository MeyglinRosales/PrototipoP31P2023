/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import java.util.List;
import modelo.daoAlumnos;
/**
 *
 * @author visitante
 */
public class clsAlumnos {
    private String CarnetAlumnos;
    private String NombreAlumnos;
    private String DireccionAlumnos;
    private String TelefonoAlumnos;
    private String EmailAlumnos;
    private String EstatusAlumnos;

       public clsAlumnos() {
    }
    
    public clsAlumnos(String CarnetAlumnos) {
        this.CarnetAlumnos = CarnetAlumnos;
    }    
    
    public clsAlumnos(String NombreAlumnos, String DireccionAlumnos) {
        this.NombreAlumnos = NombreAlumnos;
        this.DireccionAlumnos = DireccionAlumnos;
    }
    
    public clsAlumnos(String CarnetAlumnos, String NombreAlumnos, String DireccionAlumnos, String TelefonoAlumnos, String EmailAlumnos, String EstatusAlumnos) {
        this.CarnetAlumnos = CarnetAlumnos;
        this.NombreAlumnos = NombreAlumnos;
        this.DireccionAlumnos = DireccionAlumnos;
        this.TelefonoAlumnos = TelefonoAlumnos;
        this.EmailAlumnos = EmailAlumnos;
        this.EstatusAlumnos = EstatusAlumnos;
    }    

    public String getCarnetAlumnos() {
        return CarnetAlumnos;
    }
  
    public void setCarnetAlumnos(String CarnetAlumnos) {
        this.CarnetAlumnos = CarnetAlumnos;
    }

    public String getNombreAlumnos() {
        return NombreAlumnos;
    }

    public void setNombreAlumnos(String NombreAlumnos) {
        this.NombreAlumnos = NombreAlumnos;
    }

    public String getDireccionAlumnos() {
        return DireccionAlumnos;
    }

    public void setDireccionAlumnos(String DireccionAlumnos) {
        this.DireccionAlumnos = DireccionAlumnos;
    }
    public String getTelefonoAlumnos() {
        return TelefonoAlumnos;
    }

    public void setTelefonoAlumnos(String TelefonoAlumnos) {
        this.TelefonoAlumnos = TelefonoAlumnos;
    }
    public String getEmailAlumnos() {
        return EmailAlumnos;
    }

    public void setEmailAlumnos(String EmailAlumnos) {
        this.EmailAlumnos = EmailAlumnos;
    }
    public String getEstatusAlumnos() {
        return EstatusAlumnos;
    }

    public void setEstatusAlumnos(String EstatusAlumnos) {
        this.EstatusAlumnos = EstatusAlumnos;
    }

    @Override
   public String toString() {
        return "clsAlumos" + "CarnetAlumnos=" + CarnetAlumnos + ", NombreAlumnos=" + NombreAlumnos + ", DireccionAlumnos=" + DireccionAlumnos + ", TelefonoAlumnos=" + TelefonoAlumnos + ", EmailAlumnos=" + EmailAlumnos + ", EstatusAlumnos=" + EstatusAlumnos +'}';
    }
    //Metodos de acceso a la capa controlador
    public clsAlumnos getBuscarInformacionAlumnosPorNombre(clsAlumnos alumnos)
    {
        daoAlumnos daoalumnos = new daoAlumnos();
        return daoalumnos.consultaAlumPorNombre(alumnos);
    }
    public clsAlumnos getBuscarInformacionAlumnosPorCodigo(clsAlumnos alumnos)
    {
        daoAlumnos daoalumnos = new daoAlumnos();
        return daoalumnos.consultaAlumPorCodigo(alumnos);
    }    
    public List<clsAlumnos> getListadoAlum()
    {
        daoAlumnos daoalumnos = new daoAlumnos();
        List<clsAlumnos> listadoAlum = daoalumnos.consultaAlum();
        return listadoAlum;
    }
    public int setBorrarAlumnos(clsAlumnos alumnos)
    {
        daoAlumnos daoalumnos = new daoAlumnos();
        return daoalumnos.borrarAlum(alumnos);
    }          
    public int setIngresarAlumnos(clsAlumnos alumnos)
    {
        daoAlumnos daoalumnos = new daoAlumnos();
        return daoalumnos.ingresaAlum(alumnos);
    }              
    public int setModificarAlumnos(clsAlumnos alumnos)
    {
        daoAlumnos daoalumnos = new daoAlumnos();
        return daoalumnos.actualizaAlum(alumnos);
    }              
}
