/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import java.util.List;
import modelo.daoAulas;
/**
 *
 * @author visitante
 */
public class clsAulas {
    
    private String CodigoAulas;
    private String NombreAulas;
    private String EstatusAulas;

        public clsAulas() {
    }
    
    public clsAulas(String CodigoAulas) {
        this.CodigoAulas = CodigoAulas;
    }    
    
    public clsAulas(String NombreAulas, String EstatusAulas) {
        this.NombreAulas = NombreAulas;
        this.EstatusAulas = EstatusAulas;
    }
    
    public clsAulas(String CodigoAulas, String NombreAulas, String EstatusAulas) {
        this.CodigoAulas = CodigoAulas;
        this.NombreAulas = NombreAulas;
        this.EstatusAulas = EstatusAulas;
    }    

    public String getCodigoAulas() {
        return CodigoAulas;
    }
  
    public void setCodigoAulas(String CodigoAulas) {
        this.CodigoAulas = CodigoAulas;
    }

    public String getNombreAulas() {
        return NombreAulas;
    }

    public void setNombreAulas(String NombreAulas) {
        this.NombreAulas = NombreAulas;
    }

    public String getEstatusAulas() {
        return EstatusAulas;
    }

    public void setEstatusAulas(String EstatusAulas) {
        this.EstatusAulas = EstatusAulas;
    }
    @Override
   public String toString() {
        return "clsAulas" + "CodigoAulas=" + CodigoAulas + ", NombreAulas=" + NombreAulas + ", EstatusAulas=" + EstatusAulas + '}';
    }
    //Metodos de acceso a la capa controlador
    public clsAulas getBuscarInformacionAulasPorNombre(clsAulas aulas)
    {
        daoAulas daoaulas = new daoAulas();
        return daoaulas.consultaAulPorNombre(aulas);
    }
    public clsAulas getBuscarInformacionAulasPorCodigo(clsAulas aulas)
    {
        daoAulas daoaulas = new daoAulas();
        return daoaulas.consultaAulPorCodigo(aulas);
    }    
    public List<clsAulas> getListadoAul()
    {
        daoAulas daoaulas = new daoAulas();
        List<clsAulas> listadoAul = daoaulas.consultaAul();
        return listadoAul;
    }
    public int setBorrarAulas(clsAulas aulas)
    {
        daoAulas daoaulas = new daoAulas();
        return daoaulas.borrarAul(aulas);
    }          
    public int setIngresarAulas(clsAulas aulas)
    {
        daoAulas daoaulas = new daoAulas();
        return daoaulas.ingresaAul(aulas);
    }              
    public int setModificarAulas(clsAulas aulas)
    {
        daoAulas daoaulas = new daoAulas();
        return daoaulas.actualizaAul(aulas);
    }              
}
