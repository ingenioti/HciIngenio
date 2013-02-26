package objetos.ingenioti.org;

import interfaces.ingenioti.org.IObjetoHci;

/**
 * OObjeto.java
 * 
 * Este objeto controla la información de los objetos de la aplicacion
 * Creado 2013/02/25
 * 
 * @author Alexys
 * @version 1.0
 */
public class OObjeto implements IObjetoHci {
    private String codigo;
    private String nombre;
    private String descripcion;
    private boolean activo;

    public OObjeto(String codigo, String nombre, String descripcion, boolean activo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.activo = activo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcionObjeto() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    @Override
    public String getDescripcion(){
        return "Controla los objetos de la aplicacion";
    }
 
    @Override
    public String getXML(){
        return null;
    }
}
