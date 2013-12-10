package objetos.ingenioti.org;

import java.util.Date;
import interfaces.ingenioti.org.IObjetoHci;

/**
 * OCredencial.java
 * 
 * Este objeto permite controlar la credencial del usuario para su autenticación.
 * Creado 2013/02/25
 * 
 * @author Alexys
 * @version 1.0
 */
public class OCredencial implements IObjetoHci {
    private int id;
    private OUsuario usuario;
    private String hostip;
    private String hostnombre;
    private Date creacion;
    private Date ultimaaccion;

    public OCredencial(){}
    
    public OCredencial(int id, OUsuario usuario, String hostip, String hostnombre, Date creacion, Date ultimaaccion) {
        this.id = id;
        this.usuario = usuario;
        this.hostip = hostip;
        this.hostnombre = hostnombre;
        this.creacion = creacion;
        this.ultimaaccion = ultimaaccion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public OUsuario getUsuario() {
        return usuario;
    }

    public void setUsuario(OUsuario usuario) {
        this.usuario = usuario;
    }

    public String getHostip() {
        return hostip;
    }

    public void setHostip(String hostip) {
        this.hostip = hostip;
    }

    public String getHostnombre() {
        return hostnombre;
    }

    public void setHostnombre(String hostnombre) {
        this.hostnombre = hostnombre;
    }

    public Date getCreacion() {
        return creacion;
    }

    public void setCreacion(Date creacion) {
        this.creacion = creacion;
    }

    public Date getUltimaaccion() {
        return ultimaaccion;
    }

    public void setUltimaaccion(Date ultimaaccion) {
        this.ultimaaccion = ultimaaccion;
    }
    
    @Override
    public String getDescripcion(){
        return "Credencial para control de autenticación del usuario";
    }
    
    @Override
    public String getXML(){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
