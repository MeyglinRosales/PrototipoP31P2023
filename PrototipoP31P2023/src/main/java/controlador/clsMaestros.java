/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import java.util.List;
import modelo.daoMaestros;
/**
 *
 * @author visitante
 */
public class clsMaestros {
    private String CodMaestro;
    private String NombreMaestro;
    private String DireccionMaestro;
    private String TelMaestro;
    private String EmailMaestro;
    private String EstatusMaestro;

    public clsMaestros() {
    }

    public clsMaestros(String CodMaestro, String NombreMaestro, String DireccionMaestro, String TelMaestro, String EmailMaestro, String EstatusMaestro) {
        this.CodMaestro = CodMaestro;
        this.NombreMaestro = NombreMaestro;
        this.DireccionMaestro = DireccionMaestro;
        this.TelMaestro = TelMaestro;
        this.EmailMaestro = EmailMaestro;
        this.EstatusMaestro = EstatusMaestro;
    }

    public String getCodMaestro() {
        return CodMaestro;
    }

    public void setCodMaestro(String CodMaestro) {
        this.CodMaestro = CodMaestro;
    }

    public String getNombreMaestro() {
        return NombreMaestro;
    }

    public void setNombreMaestro(String NombreMaestro) {
        this.NombreMaestro = NombreMaestro;
    }

    public String getDireccionMaestro() {
        return DireccionMaestro;
    }

    public void setDireccionMaestro(String DireccionMaestro) {
        this.DireccionMaestro = DireccionMaestro;
    }

    public String getTelMaestro() {
        return TelMaestro;
    }

    public void setTelMaestro(String TelMaestro) {
        this.TelMaestro = TelMaestro;
    }

    public String getEmailMaestro() {
        return EmailMaestro;
    }

    public void setEmailMaestro(String EmailMaestro) {
        this.EmailMaestro = EmailMaestro;
    }

    public String getEstatusMaestro() {
        return EstatusMaestro;
    }

    public void setEstatusMaestro(String EstatusMaestro) {
        this.EstatusMaestro = EstatusMaestro;
    }

    
    
    @Override
    public String toString() {
        return "clsMaestros{" + "CodMaestro=" + CodMaestro + ", NombreMaestro=" + NombreMaestro + ", DireccionMaestro=" + DireccionMaestro + ", TelMaestro=" + 
                TelMaestro + ", EmailMaestro=" + EmailMaestro + ", EstatusMaestro=" + EstatusMaestro + '}';
    }
    //Metodos de acceso a la capa controlador
    public clsMaestros getBuscarInformacionMaestroPorNombre(clsMaestros maestro)
    {
        daoMaestros daomaestros  = new daoMaestros();
        return daomaestros.consultaMaestrosPorNombre(maestro);
    }
     public clsMaestros getBuscarInformacionMaestroPorId(clsMaestros maestro)
    {
        daoMaestros  daomaestros  = new daoMaestros ();
        return daomaestros.consultaMaestrosPorId(maestro);
    }    
    public List<clsMaestros> getListadoMaestros()
    {
        daoMaestros  daomaestros  = new daoMaestros();
        List<clsMaestros> listadoMaestros = daomaestros.consultaMaestros();
        return listadoMaestros;
    }
    public int setBorrarMaestro(clsMaestros maestro)
    {
        daoMaestros  daomaestros  = new daoMaestros ();
        return daomaestros.borrarMaestros(maestro);
    }          
    public int setIngresarMaestro(clsMaestros maestro)
    {
        daoMaestros daomaestros = new daoMaestros ();
        return  daomaestros.ingresaMaestros(maestro);
    }              
    public int setModificarMaestro(clsMaestros maestro)
    {
        daoMaestros  daomaestros  = new daoMaestros ();
        return  daomaestros.actualizaMaestros(maestro);
    }        
}
