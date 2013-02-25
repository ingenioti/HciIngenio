package objetos.ingenioti.org;

import java.util.Date;
import interfaces.ingenioti.org.IObjetoHci;

/**
 * OUsuario
 * 
 * Este objeto es el usuario de la aplicacion
 * Creado 24/02/2013
 * 
 * @author Alexys
 * @version 1.0
 */
public class OUsuario implements IObjetoHci{
    private int id;
    private String codigo;
    private String nombre;
    private String apellido;
    private String clave;
    private OPerfil perfil;
    private Date ultimoingreso;
    private boolean bloqueado;
    private String correo;

    public OUsuario() {
    }

    public OUsuario(int id, String codigo, String nombre, String apellido, String clave, OPerfil perfil, Date ultimoingreso, boolean bloqueado, String correo) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.clave = clave;
        this.perfil = perfil;
        this.ultimoingreso = ultimoingreso;
        this.bloqueado = bloqueado;
        this.correo = correo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public OPerfil getPerfil() {
        return perfil;
    }

    public void setPerfil(OPerfil perfil) {
        this.perfil = perfil;
    }

    public Date getUltimoingreso() {
        return ultimoingreso;
    }

    public void setUltimoingreso(Date ultimoingreso) {
        this.ultimoingreso = ultimoingreso;
    }

    public boolean isBloqueado() {
        return bloqueado;
    }

    public void setBloqueado(boolean bloqueado) {
        this.bloqueado = bloqueado;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String getDescripcion(){
        return "Usuario del sistema";
    }
    
    @Override
    public String getXML(){
        return null;
    }
}
