package objetos.ingenioti.org;

import interfaces.ingenioti.org.IObjetoHci;

/**
 * OObjetosXPerfil.java
 * 
 * Controla a que objetos tiene acceso el perfil seleccionado.
 * Creado 2013/02/25
 * 
 * @author Alexys
 * @version 1.0
 */
public class OObjetosXPerfil implements IObjetoHci{
    private OPerfil perfil;
    private OObjeto objeto;
    private boolean insertar;
    private boolean modificar;
    private boolean borrar;
    private boolean consultar;
    private boolean listar;

    public OObjetosXPerfil(OPerfil perfil, OObjeto objeto, boolean insertar, boolean modificar, boolean borrar, boolean consultar, boolean listar) {
        this.perfil = perfil;
        this.objeto = objeto;
        this.insertar = insertar;
        this.modificar = modificar;
        this.borrar = borrar;
        this.consultar = consultar;
        this.listar = listar;
    }

    public OPerfil getPerfil() {
        return perfil;
    }

    public void setPerfil(OPerfil perfil) {
        this.perfil = perfil;
    }

    public OObjeto getObjeto() {
        return objeto;
    }

    public void setObjeto(OObjeto objeto) {
        this.objeto = objeto;
    }

    public boolean isInsertar() {
        return insertar;
    }

    public void setInsertar(boolean insertar) {
        this.insertar = insertar;
    }

    public boolean isModificar() {
        return modificar;
    }

    public void setModificar(boolean modificar) {
        this.modificar = modificar;
    }

    public boolean isBorrar() {
        return borrar;
    }

    public void setBorrar(boolean borrar) {
        this.borrar = borrar;
    }

    public boolean isConsultar() {
        return consultar;
    }

    public void setConsultar(boolean consultar) {
        this.consultar = consultar;
    }

    public boolean isListar() {
        return listar;
    }

    public void setListar(boolean listar) {
        this.listar = listar;
    }
    
    @Override
    public String getDescripcion(){
        return "Controla a que objetos tiene acceso el perfil";
    }
    
    @Override
    public String getXML(){
        return null;
    }
}
