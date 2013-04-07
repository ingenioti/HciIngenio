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
    private String correo;
    private String identificacion;
    private OPerfil perfil;
    private String clave;
    private boolean cambiarclave;
    private Date fechacreacion;
    private Date ultimoingreso;
    private boolean bloqueado;
    private Date fechabloqueado;
    private Date fechadesbloqueado;

    public OUsuario() {
    }

    public OUsuario(int id, String codigo, String nombre, String apellido, String correo, 
                    String identificacion, OPerfil perfil, String clave, boolean cambiarclave,
                    Date fechacreacion, Date ultimoingreso, boolean bloqueado, Date fechabloqueado, Date fechadesbloqueado) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.identificacion = identificacion;
        this.perfil = perfil;
        this.clave = clave;
        this.cambiarclave = cambiarclave;
        this.fechacreacion = fechacreacion;
        this.ultimoingreso = ultimoingreso;
        this.bloqueado = bloqueado;
        this.fechabloqueado = fechabloqueado;
        this.fechadesbloqueado = fechadesbloqueado;
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
    
    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public boolean isCambiarclave() {
        return cambiarclave;
    }

    public void setCambiarclave(boolean cambiarclave) {
        this.cambiarclave = cambiarclave;
    }

    public Date getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(Date fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    public Date getFechabloqueado() {
        return fechabloqueado;
    }

    public void setFechabloqueado(Date fechabloqueado) {
        this.fechabloqueado = fechabloqueado;
    }

    public Date getFechadesbloqueado() {
        return fechadesbloqueado;
    }

    public void setFechadesbloqueado(Date fechadesbloqueado) {
        this.fechadesbloqueado = fechadesbloqueado;
    }
}
