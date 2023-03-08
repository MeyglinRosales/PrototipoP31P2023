/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import java.util.List;
import modelo.daoPuesto;
/**
 *
 * @author visitante
 */
public class clsPuesto {
    
    private String CodigoPuesto;
    private String NombrePuesto;
    private String EstatusPuesto;

        public clsPuesto() {
    }
    
    public clsPuesto(String CodigoPuesto) {
        this.CodigoPuesto = CodigoPuesto;
    }    
    
    public clsPuesto(String NombrePuesto, String EstatusPuesto) {
        this.NombrePuesto = NombrePuesto;
        this.EstatusPuesto = EstatusPuesto;
    }
    
    public clsPuesto(String CodigoPuesto, String NombrePuesto, String EstatusPuesto) {
        this.CodigoPuesto = CodigoPuesto;
        this.NombrePuesto = NombrePuesto;
        this.EstatusPuesto= EstatusPuesto;
    }    

    public String getCodigoPuesto() {
        return CodigoPuesto;
    }
  
    public void setCodigoPuesto(String CodigoPuesto) {
        this.CodigoPuesto = CodigoPuesto;
    }

    public String getNombrePuesto() {
        return NombrePuesto;
    }

    public void setNombrePuesto(String NombrePuesto) {
        this.NombrePuesto = NombrePuesto;
    }

    public String getEstatusPuesto() {
        return EstatusPuesto;
    }

    public void setEstatusPuesto(String EstatusPuesto) {
        this.EstatusPuesto = EstatusPuesto;
    }
    @Override
   public String toString() {
        return "clsPuesto" + "CodigoPuesto=" + CodigoPuesto + ", NombrePuesto=" + NombrePuesto + ", EstatusPuesto=" + EstatusPuesto+ '}';
    }
    //Metodos de acceso a la capa controlador
    public clsPuesto getBuscarInformacionPuestoPorNombre(clsPuesto puestos)
    {
        daoPuesto daopuesto = new daoPuesto();
        return daopuesto.consultaPuePorNombre(puestos);
    }
    public clsPuesto getBuscarInformacionPuestoPorCodigo(clsPuesto puestos)
    {
        daoPuesto daopuesto = new daoPuesto();
        return daopuesto.consultaPuePorCodigo(puestos);
    }    
    public List<clsPuesto> getListadoPue()
    {
        daoPuesto daopuesto = new daoPuesto();
        List<clsPuesto> listadoPue = daopuesto.consultaPue();
        return listadoPue;
    }
    public int setBorrarPuesto(clsPuesto puestos)
    {
        daoPuesto daopuesto = new daoPuesto();
        return daopuesto.borrarPue(puestos);
    }          
    public int setIngresarPuesto(clsPuesto puestos)
    {
        daoPuesto daopuesto = new daoPuesto();
        return daopuesto.ingresaPue(puestos);
    }              
    public int setModificarPuesto(clsPuesto puestos)
    {
        daoPuesto daopuesto = new daoPuesto();
        return daopuesto.actualizaPue(puestos);
    }              
}
