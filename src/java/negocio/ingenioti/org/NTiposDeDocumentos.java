/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.ingenioti.org;

import java.sql.SQLException;
import objetos.ingenioti.org.OTiposDeDocumento;
import java.util.ArrayList;

/**
 *
 * @author Alexys
 */
public class NTiposDeDocumentos extends NGeneralidades {

    public NTiposDeDocumentos() {
    }

    public Short insertar(OTiposDeDocumento td) {
        Short respuesta = 0;
        try {
            conectar("select * from fn_tiposdedocumento_ins(?,?,?)");
            sentenciaProcedimiento.setString(1, td.getAbreviatura());
            sentenciaProcedimiento.setString(2, td.getTipodedocumento());
            sentenciaProcedimiento.setBoolean(3, td.isActivo());
            getResultadosProcedimiento();
            if (resultados.next()) {
                respuesta = resultados.getShort(1);
            }
        } catch (SQLException sql) {
            System.err.println("Error en NTiposDeDocumentos insertar: " + sql.getMessage());
        } finally {
            try{
                cerrarConexion();
            } catch (SQLException sqle){}
        }
        return respuesta;
    }

    public Short borrar(OTiposDeDocumento td) {
        Short respuesta = 0;
        try {
            conectar("select * from fn_tiposdedocumento_del(?)");
            sentenciaProcedimiento.setShort(1, td.getIdtipodedocumento());
            getResultadosProcedimiento();
            if (resultados.next()) {
                respuesta = resultados.getShort(1);
            }
        } catch (SQLException sqle) {
            System.err.println("Error en NTiposDeDocumentos borrar: " + sqle.getMessage());
        } finally {
            try{
                cerrarConexion();
            } catch (SQLException sqle){}
        }
        return respuesta;
    }

    public Short actualizar(OTiposDeDocumento td) {
        Short respuesta = 0;
        try {
            conectar("select * from fn_tiposdedocumento_upd(?,?,?,?)");
            sentenciaProcedimiento.setShort(1, td.getIdtipodedocumento());
            sentenciaProcedimiento.setString(2, td.getAbreviatura());
            sentenciaProcedimiento.setString(3, td.getTipodedocumento());
            sentenciaProcedimiento.setBoolean(3, td.isActivo());
            getResultadosProcedimiento();
            if(resultados.next()){
                respuesta = resultados.getShort(1);
            }
        } catch (SQLException sqle){
            System.err.println("Error en NTiposDeDocumentos actualizar: "+sqle.getMessage());
        } finally {
            try{
                cerrarConexion();
            } catch (SQLException sqle){}
        }
        return respuesta;
    }
    
    public ArrayList<OTiposDeDocumento> consultar(Short tc, OTiposDeDocumento td){
        ArrayList<OTiposDeDocumento> lista = new ArrayList<OTiposDeDocumento>();
        try{
            conectar("select * from fn_tiposdedocumento_sel(?,?,?,?,?)");
            sentenciaProcedimiento.setShort(1, tc);
            sentenciaProcedimiento.setShort(2, td.getIdtipodedocumento());
            sentenciaProcedimiento.setString(3,td.getAbreviatura());
            sentenciaProcedimiento.setString(4, td.getTipodedocumento());
            sentenciaProcedimiento.setBoolean(5, td.isActivo());
            getResultadosProcedimiento();
            while(resultados.next()){
                OTiposDeDocumento temp = new OTiposDeDocumento();
                temp.setIdtipodedocumento(resultados.getShort(1));
                temp.setAbreviatura(resultados.getString(2));
                temp.setTipodedocumento(resultados.getString(3));
                temp.setActivo(resultados.getBoolean(4));
                lista.add(temp);
            }
        } catch (SQLException sqle){
            System.err.println("Error de NTiposDeDocumentos consultar: "+sqle.getMessage());
        } finally {
            try{
                cerrarConexion();
            } catch (SQLException sqle){}
        }
        return lista;
    }
}