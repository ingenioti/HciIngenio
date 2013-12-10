package negocio.ingenioti.org;

import java.sql.SQLException;
import objetos.ingenioti.org.OCredencial;
import objetos.ingenioti.org.OUsuario;
import objetos.ingenioti.org.OPerfil;

/**
 *
 * @author Alexys
 * @version 1.0
 * Creado el 13/04/2013
 */
public class NAutenticacion extends NGeneralidades{
    private OCredencial credencial = null;
    private OPerfil perfil = null;
    private OUsuario usuario = null;
    private String codigo = null;
    private String clave  = null;
    private String ipCliente = null;
    private String hostCliente = null;
    
    public NAutenticacion(){}
    
    public NAutenticacion(String cod, String cla, String ipc, String hos){
        this.codigo = cod;
        this.clave  = cla;
        this.ipCliente = ipc;
        this.hostCliente = hos;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
    public void setIpCliente(String ipc){
        this.ipCliente = ipc;
    }
    
    public void setHostCliente(String hos){
        this.hostCliente = hos;
    }
    
    public OCredencial autenticar(){
        try{
            conectar("select * from fn_usuarios_sel(?, null, ?, null, null, null, null, null, null, null, null, null, null, null, md5(?))");
            sentenciaProcedimiento.setShort(1, Short.parseShort(String.valueOf(23)));
            sentenciaProcedimiento.setString(2, this.codigo);
            sentenciaProcedimiento.setString(3, this.clave);
            getResultadosProcedimiento();
            if(resultados.next()){ // Si encuentra registros
                perfil = new OPerfil();
                usuario = new OUsuario();
                credencial = new OCredencial();
                perfil.setIdperfil(resultados.getShort("idperfil"));
                perfil.setNombre(resultados.getString("perfil"));
                perfil.setActivo(resultados.getBoolean("perfilactivo"));
                usuario.setId(resultados.getInt("idusuario"));
                usuario.setCodigo(resultados.getString("codigo"));
                usuario.setNombre(resultados.getString("nombres"));
                usuario.setApellido(resultados.getString("apellidos"));
                usuario.setCorreo(resultados.getString("correo"));
                usuario.setIdentificacion(resultados.getString("identificacion"));
                usuario.setPerfil(perfil);
                usuario.setCambiarclave(resultados.getBoolean("cambiarclave"));
                usuario.setFechacreacion(resultados.getDate("fechacreacion"));
                usuario.setUltimoingreso(resultados.getDate("ultimoingreso"));
                usuario.setBloqueado(resultados.getBoolean("bloqueado"));
                usuario.setFechabloqueado(resultados.getDate("fechabloqueado"));
                usuario.setFechadesbloqueado(resultados.getDate("fechadesbloqueado"));
                // Se inserta en la base de credenciales
                conectar("select * from fn_credenciales_ins(?, ?, ?, ?)");
                sentenciaProcedimiento.setInt(1, usuario.getId());
                sentenciaProcedimiento.setString(2, usuario.getNombre()+' '+usuario.getApellido());
                sentenciaProcedimiento.setString(3, this.ipCliente);
                sentenciaProcedimiento.setString(4, this.hostCliente);
                getResultadosProcedimiento();
                if(resultados.next()){ // Si se ingresó
                    if(resultados.getInt(1)!=0){ // Si se ingresó correctamente
                        credencial.setId(resultados.getInt(1));
                        credencial.setUsuario(usuario);
                        credencial.setHostip(this.ipCliente);
                        credencial.setHostnombre(this.hostCliente);
                        credencial.setCreacion(new java.util.Date());
                    } else {
                        System.err.println("No se logro insertar la credencial desde NAutenticacion.java");
                    }
                }
            }
        } catch (SQLException sqle){
            System.err.println("Error de sql en NAutenticacion.java: "+sqle.getMessage());
        } finally {
            try{
                cerrarConexion();
            } catch (SQLException sqle){}
        }
        return credencial;
    }
    
    public boolean cerrarSesion(OUsuario usuario){
        try{
            conectar("select * from fn_credenciales_del(?)");
            sentenciaProcedimiento.setInt(1, usuario.getId());
            getResultadosProcedimiento();
            if(resultados.next()){
                if(resultados.getInt(1)==1){
                    return true;
                }
            }
        } catch (SQLException sqle){
            System.err.println("Error de sql en NAutenticacion.java: "+sqle.getMessage());
        } finally {
            try{
                cerrarConexion();
            } catch (SQLException sqle){}
        }
        return false;
    }
    
    public boolean tienePermiso(Short tipoDeAccion, Short perfil, String objeto){
        boolean tiene = false;
        try{
            conectar("select * from fn_objetosxperfil_val(?,?,?)");
            sentenciaProcedimiento.setShort(1,tipoDeAccion);
            sentenciaProcedimiento.setShort(2,perfil);
            sentenciaProcedimiento.setString(3, objeto);
            getResultadosProcedimiento();
            if(resultados.next()){
                if(resultados.getShort(1)>0){
                    tiene = true;
                }
            }
        } catch (SQLException sqle){
            System.err.println("Error NAutenticacion tienePermiso: "+sqle.getMessage());
        } finally {
            try{
                cerrarConexion();
            } catch (SQLException sqle){}
        }
        return tiene;
    }

}
