package negocio.ingenioti.org;

import org.postgresql.ds.PGPoolingDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.ServletContext;

/**
 * NUtilidades.java
 * Contiene las utilidades generales de la aplicacion
 * Create 2013/02/25
 * 
 * @author Alexys
 * @version 1.0
 */
public final class NUtilidades {
    private static PGPoolingDataSource piscina = null;
    private static ServletContext contextoApp;
    private static boolean creado = false;
    public static final byte MENSAJE_ERROR = 0;
    public static final byte MENSAJE_INFO  = 1;
    public static final byte MENSAJE_CORRECTO = 2;
    
    public static boolean contextoCreado(){
        return creado;
    }
    public static void creaPiscina(ServletContext contexto){
        contextoApp = contexto;
        setPiscina();
    }
    
    private static void setPiscina(){
        String servidor = contextoApp.getInitParameter("servidor");
        int puertobd = Integer.parseInt(contextoApp.getInitParameter("puertobd"));
        String basededa = contextoApp.getInitParameter("basededatos");
        String usuariob = contextoApp.getInitParameter("usuariobd");
        String clavebda = contextoApp.getInitParameter("clavebd");
        int conexionesiniciales = Integer.parseInt(contextoApp.getInitParameter("conexionesiniciales"));
        int conexionesmaximas = Integer.parseInt(contextoApp.getInitParameter("conexionesmaximas"));
        piscina = new PGPoolingDataSource();
        piscina.setDataSourceName("Conexion a la Base Ingenio T.I.");
        piscina.setServerName(servidor);
        piscina.setPortNumber(puertobd);
        piscina.setDatabaseName(basededa);
        piscina.setUser(usuariob);
        piscina.setPassword(clavebda);
        piscina.setInitialConnections(conexionesiniciales);
        piscina.setMaxConnections(conexionesmaximas);
        creado = true;
    }
    
    public static Connection getConexion() throws SQLException{
        Connection conexion = null;
        if(piscina==null){
            setPiscina();
            if(piscina==null){
                System.err.println("Error en NUtilidades.java No fue posible cargar la piscina de conexiones");
            }
        } else {
            //try{
                conexion = piscina.getConnection();
            //} catch (SQLException sqle){
                //System.err.println("Error en NUtiliades.java Error de sql: "+sqle.getMessage());
            //}
        }
        return conexion;
    }
}