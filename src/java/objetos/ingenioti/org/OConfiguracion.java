package objetos.ingenioti.org;

import interfaces.ingenioti.org.IObjetoHci;

/**
 * OConfiguracion.java
 * 
 * Este objeto contiene la informacion de la configuracion y los parametros del programa.
 * Creado 24/02/2013
 * 
 * @author Alexys
 * @version 1.0
 */
public class OConfiguracion implements IObjetoHci{
    private short idconfiguracion;
    private String parametro;
    private String valorparametro;
    private boolean activo;

    public OConfiguracion() {
    }

    public OConfiguracion(short idconfiguracion, String parametro, String valorparametro, boolean activo) {
        this.idconfiguracion = idconfiguracion;
        this.parametro = parametro;
        this.valorparametro = valorparametro;
        this.activo = activo;
    }

    public short getIdconfiguracion() {
        return idconfiguracion;
    }

    public void setIdconfiguracion(short idconfiguracion) {
        this.idconfiguracion = idconfiguracion;
    }

    public String getParametro() {
        return parametro;
    }

    public void setParametro(String parametro) {
        this.parametro = parametro;
    }

    public String getValorparametro() {
        return valorparametro;
    }

    public void setValorparametro(String valorparametro) {
        this.valorparametro = valorparametro;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    @Override
    public String getDescripcion(){
        return "Configuracion del programa";
    }
    
    @Override
    public String getXML(){
        return null;
    }
}
