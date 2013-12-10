package objetos.ingenioti.org;

import interfaces.ingenioti.org.IObjetoHci;
/**
 * OPerfil.java
 * 
 * Este objeto identifica el perfil de la aplicacion
 * Creado: 24/02/2013
 * 
 * @author Alexys
 * @version 1.0
 */
public class OPerfil implements IObjetoHci {
    private Short idperfil;
    private String nombre;
    private boolean activo;

    public OPerfil() {
    }

    public OPerfil(short idperfil, String nombre, boolean activo) {
        this.idperfil = idperfil;
        this.nombre = nombre;
        this.activo = activo;
    }

    public Short getIdperfil() {
        return idperfil;
    }

    public void setIdperfil(short idperfil) {
        this.idperfil = idperfil;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    @Override
    public String getDescripcion(){
        return "Perfiles de la aplicacion";
    }
    
    @Override
    public String getXML(){
        return null;
    }
}
