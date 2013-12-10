package negocio.ingenioti.org;

import java.sql.SQLException;
import objetos.ingenioti.org.OUsuario;
import objetos.ingenioti.org.OPerfil;
/**
 *
 * @author Alexys
 */
public class NUsuarios extends NGeneralidades{
    //private OUsuario usuario = null;
    //private OPerfil perfil = null;
    
    public NUsuarios(){}
    
    public Short cambiarClave(int idUsuario, String anterior, String nueva){
        Short resultado = 0;
        try{
            conectar("select * from fn_usuarios_cla(?,md5(?),md5(?))");
            sentenciaProcedimiento.setInt(1, idUsuario);
            sentenciaProcedimiento.setString(2, anterior);
            sentenciaProcedimiento.setString(3, nueva);
            getResultadosProcedimiento();
            if(resultados.next()){
                resultado = resultados.getShort(1);
            }
        } catch(SQLException sqle){
            System.err.println("Error de sql en NUsuarios.java: "+sqle.getMessage());
        }
        return resultado;
    }
}
