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
        System.err.println("He entrado a la piscina");
    }
    
    public static Connection getConexion(ServletContext contexto){
        Connection conexion = null;
        contextoApp = contexto;
        if(piscina==null){
            setPiscina();
            if(piscina==null){
                System.err.println("No fue posible cargar la piscina de conexiones");
            }
        } else {
            try{
                conexion = piscina.getConnection();
            } catch (SQLException sqle){
                System.err.println("Error de sql: "+sqle.getMessage());
            }
        }
        return conexion;
    }
}