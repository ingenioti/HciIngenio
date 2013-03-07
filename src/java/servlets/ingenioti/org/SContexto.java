package servlets.ingenioti.org;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import negocio.ingenioti.org.NUtilidades;

/**
 * SContexto.java
 * Este servlet es un auxiliar que permitirá cargar la información del archivo web.xml
 * Creado 2013/02/26
 * 
 * @author Alexys
 * @version 1.0
 */
@WebServlet(name = "SContexto", urlPatterns = {"/SContexto"})
public class SContexto extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/xml;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String mensaje = "";
        byte tipoMensaje = NUtilidades.MENSAJE_ERROR;
        
        try { // Try que permite enviar el mensaje por medio del objeto out
            if(!NUtilidades.contextoCreado()){ // Si entra al sistema por primera vez se envía el contexto
                NUtilidades.creaPiscina(getServletContext());
            }
            Connection conexion = null;
            Statement sentencia = null;
            ResultSet resultados = null;
            try{
                conexion = NUtilidades.getConexion();
                sentencia = conexion.createStatement();
                resultados = sentencia.executeQuery("select now()");
                if(resultados.next()){
                    tipoMensaje = NUtilidades.MENSAJE_CORRECTO;
                    mensaje = "Conexión correcta a la BD el: "+resultados.getString(1);
                } else {
                    tipoMensaje = NUtilidades.MENSAJE_INFO;
                    mensaje = "No hubo resultados al traer la fecha del servidor de BD";
                }
            } catch (SQLException sqle){
                System.out.println("Error al obtener la conexion en SContexto.java: "+sqle.getMessage());
                tipoMensaje = NUtilidades.MENSAJE_ERROR;
                mensaje = "Error al obtener la conexion en SContexto.java: "+sqle.getMessage();
            } finally {
                if(resultados!=null){
                    try{
                        resultados.close();
                    } catch (SQLException sqle){}
                }
                if(sentencia!=null){
                    try{
                        sentencia.close();
                    } catch (SQLException sqle){}
                }
                if(conexion!=null){
                    try{
                        conexion.close();
                    } catch (SQLException sqle){}
                }
            }
            out.println("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>");
            out.println("<mensaje>");
            out.println("<tipo>"+tipoMensaje+"</tipo>");
            out.println("<info>"+mensaje+"</info>");
            out.println("</mensaje>");
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    /*@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }*/

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
