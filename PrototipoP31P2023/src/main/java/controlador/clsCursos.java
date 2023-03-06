/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import java.util.List;
import modelo.daoCursos;

/**
 *
 * @author Javier
 */
public class clsCursos {
    private String CodigoCurso;
    private String NombreCurso;
    private String EstatusCurso;

    public clsCursos(String CodigoCurso, String NombreCurso, String EstatusCurso) {
        this.CodigoCurso = CodigoCurso;
        this.NombreCurso = NombreCurso;
        this.EstatusCurso = EstatusCurso;
    }

    public clsCursos(String NombreCurso, String EstatusCurso) {
        this.NombreCurso = NombreCurso;
        this.EstatusCurso = EstatusCurso;
    }

    public clsCursos(String CodigoCurso) {
        this.CodigoCurso = CodigoCurso;
    }

    public clsCursos() {
    }

   

    public String getCodigoCurso() {
        return CodigoCurso;
    }

    public void setCodigoCurso(String CodigoCurso) {
        this.CodigoCurso = CodigoCurso;
    }

    public String getNombreCurso() {
        return NombreCurso;
    }

    public void setNombreCurso(String NombreCurso) {
        this.NombreCurso = NombreCurso;
    }

    public String getEstatusCurso() {
        return EstatusCurso;
    }

    public void setEstatusCurso(String EstatusCurso) {
        this.EstatusCurso = EstatusCurso;
    }
    
    @Override
    public String toString() {
        return "clsCursos{" + "CodigoCurso=" + CodigoCurso + ", NombreCurso=" + NombreCurso + ", EstatusCurso=" + EstatusCurso + '}';
    }
    //Metodos de acceso a la capa controlador
    public clsCursos getBuscarInformacionCursoPorNombre(clsCursos curso)
    {
        daoCursos daocursos = new daoCursos();
        return daocursos.consultaCursosPorNombre(curso);
    }
    public clsCursos getBuscarInformacionCursosPorCodigo(clsCursos curso)
    {
        daoCursos daocursos = new daoCursos();
        return daocursos.consultaCursosPorCodigo(curso);
    }    
    public List<clsCursos> getListadoCursos()
    {
        daoCursos daocursos = new daoCursos();
        List<clsCursos> listadoCursos = daocursos.consultaCursos();
        return listadoCursos;
    }
    public int setBorrarCursos(clsCursos curso)
    {
        daoCursos daocursos = new daoCursos();
        return daocursos.borrarCursos(curso);
    }          
    public int setIngresarCursos(clsCursos curso)
    {
        daoCursos daocursos = new daoCursos();
        return daocursos.ingresaCursos(curso);
    }              
    public int setModificarCursos(clsCursos curso)
    {
        daoCursos daocursos = new daoCursos();
        return daocursos.actualizaCursos(curso);
    }              
}
