/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets.ingenioti.org;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import objetos.ingenioti.org.OCredencial;
import negocio.ingenioti.org.NAutenticacion;

/**
 *
 * @author Alexys
 */
@WebServlet(name = "SAutenticar", urlPatterns = {"/SAutenticar"})
public class SAutenticar extends HttpServlet {

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
        HttpSession sesion = request.getSession(true);
        
        String mensaje = "";
        String codigo = request.getParameter("txtUsr");
        String clave  = request.getParameter("txtPwd");
        String ipCliente = request.getRemoteAddr();
        String hostCliente = request.getRemoteHost();
        
        NAutenticacion autenticar = new NAutenticacion(codigo, clave, ipCliente, hostCliente);
        OCredencial credencial = autenticar.autenticar();
        if(credencial==null || credencial.getId()<=0){
            mensaje = "Usuario o contraseña Inválidos!!!";
            request.setAttribute("mensaje", mensaje);
            SUtilidades.irAPagina("/index.jsp", request, response, request.getServletContext());
        } else { // Autenticado correctamente
            sesion.setAttribute("credencial", credencial);
            mensaje = "Bienvenido: "+credencial.getUsuario().getNombre();
            request.setAttribute("mensaje", mensaje);
            SUtilidades.irAPagina("/inicio.jsp", request, response, request.getServletContext());
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
        return "Short description";
    }// </editor-fold>
}
