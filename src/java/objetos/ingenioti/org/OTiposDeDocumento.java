/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package objetos.ingenioti.org;
import interfaces.ingenioti.org.IObjetoHci;

/**
 *
 * @author Alexys
 */
public class OTiposDeDocumento implements IObjetoHci {

    private Short idtipodedocumento;
    private String abreviatura;
    private String tipodedocumento;
    private boolean activo;

    public OTiposDeDocumento(){
        this.idtipodedocumento = 0;
        this.abreviatura = "";
        this.tipodedocumento = "";
        this.activo = true;        
    }
    
    public OTiposDeDocumento(Short idtipodedocumento, String abreviatura, String tipodedocumento, boolean activo) {
        this.idtipodedocumento = idtipodedocumento;
        this.abreviatura = abreviatura;
        this.tipodedocumento = tipodedocumento;
        this.activo = activo;
    }

    public Short getIdtipodedocumento() {
        return idtipodedocumento;
    }

    public void setIdtipodedocumento(Short idtipodedocumento) {
        this.idtipodedocumento = idtipodedocumento;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public String getTipodedocumento() {
        return tipodedocumento;
    }

    public void setTipodedocumento(String tipodedocumento) {
        this.tipodedocumento = tipodedocumento;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    
    @Override
    public String getDescripcion() {
        return "Objeto de tipo de documentos";
    }

    @Override
    public String getXML() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
