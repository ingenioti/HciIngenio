/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets.ingenioti.org;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import negocio.ingenioti.org.NUtilidades;

/**
 *
 * @author Alexys
 */
@WebServlet(name = "SPruebas", urlPatterns = {"/SPruebas"})
public class SPruebas extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SPruebas</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SPruebas at " + request.getContextPath() + "</h1>");
            out.println(getPerfiles());
            out.println("</body>");
            out.println("</html>");
        } finally {            
            out.close();
        }
    }

    public String getPerfiles(){
        //System.err.println("Entro a buscar los perfiles");
        String datos = "";
        Connection conexion = null;
        CallableStatement llamadaSentencia=null;
        ResultSet resultados=null;
        try {
            conexion = NUtilidades.getConexion();
            String consulta = "select * from fn_perfiles_sel(?,?,?,?)";
            llamadaSentencia = conexion.prepareCall(consulta);
            llamadaSentencia.setShort(1, Short.parseShort(String.valueOf(0))); // Tipo de consulta
            llamadaSentencia.setShort(2, Short.parseShort(String.valueOf(1)));
            llamadaSentencia.setString(3, "%ADMIN%");
            llamadaSentencia.setBoolean(4, true);
            resultados = llamadaSentencia.executeQuery();
            while (resultados.next()){
                datos += "<p>Id Perfil: ";
                datos += resultados.getInt(1);
                datos += "Nombre: ";
                datos += resultados.getString(2);
                datos += "Activo: ";
                datos += resultados.getBoolean(3);
            }
        } catch (SQLException sqle){
            System.err.println("Error de sql en NegPerfil (listaPerfiles): "+sqle);
        } finally {
            try {
                if (resultados!=null){
                    resultados.close();
                }
                if (llamadaSentencia!=null){
                    llamadaSentencia.close();
                }
                if (conexion!=null){
                    conexion.close();
                }
            } catch (SQLException sqle){}
        }
        return datos;
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
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

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
        return "Esta es una prueba";
    }// </editor-fold>
}
