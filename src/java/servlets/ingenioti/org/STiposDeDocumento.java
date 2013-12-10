/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets.ingenioti.org;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import objetos.ingenioti.org.OCredencial;
import negocio.ingenioti.org.NTiposDeDocumentos;
import objetos.ingenioti.org.OTiposDeDocumento;

/**
 *
 * @author Alexys
 */
@WebServlet(name = "STiposDeDocumento", urlPatterns = {"/STiposDeDocumento"})
public class STiposDeDocumento extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //response.setContentType("text/html;charset=UTF-8");
        HttpSession sesion = request.getSession();
        if (SUtilidades.autenticado(sesion)) {
            String mensaje = "";
            String tipoMensaje = "";
            OCredencial credencial = (OCredencial) sesion.getAttribute("credencial");
            String accion = request.getParameter("accion");
            String tipoConsulta = request.getParameter("tipoConsulta");
            Short sAccion;
            Short sTipoConsulta;
            try {
                sAccion = Short.parseShort(accion);
            } catch (NumberFormatException nfe) {
                sAccion = 0;
            }
            try {
                sTipoConsulta = Short.parseShort(tipoConsulta);
            } catch (NumberFormatException nfe) {
                sTipoConsulta = 0;
            }
            String abreviatura = request.getParameter("abreviatura");
            String tipoDeDocumento = request.getParameter("tipoDeDocumento");
            String activo = request.getParameter("activo");
            boolean bActivo = activo != null;
            ArrayList<OTiposDeDocumento> lista = new ArrayList<OTiposDeDocumento>();

            // Para realizar cualquier accion de insertar, modificar o borrar
            if (sAccion > 0) {
                if (SUtilidades.tienePermiso(sAccion, credencial.getUsuario().getPerfil().getIdperfil(), "PARTDO")) {
                    NTiposDeDocumentos nTiposDeDocumento = new NTiposDeDocumentos();
                    OTiposDeDocumento oTiposDeDocumento = new OTiposDeDocumento(sAccion, abreviatura, tipoDeDocumento, bActivo);
                    Short respuesta = 0;
                    switch (sAccion) {
                        case 1:
                            respuesta = nTiposDeDocumento.insertar(oTiposDeDocumento);
                            break;
                        case 2:
                            respuesta = nTiposDeDocumento.actualizar(oTiposDeDocumento);
                            break;
                        case 3:
                            respuesta = nTiposDeDocumento.borrar(oTiposDeDocumento);
                            break;
                    }
                    tipoMensaje = "alert-danger";
                    switch (respuesta) {
                        case 0:
                            if (sAccion != 4) {
                                mensaje = "No se realizó ninguna acción";
                            } else {
                                mensaje = "";
                            }
                            break;
                        case 1:
                            tipoMensaje = "alert-success";
                            mensaje = "Proceso realizado correctamente";
                            break;
                        case 2:
                            mensaje = "No existe el objeto a procesar";
                            break;
                        case 3:
                            mensaje = "Violación de clave única";
                            break;
                        case 4:
                            mensaje = "No se puede procesar porque tiene dependencias";
                            break;
                    }
                } else {
                    tipoMensaje = "alert-warning";
                    mensaje = "No está autorizado para realizar esta acción";
                }
            }
            // Para siempre consultar la lista de tipos de documento
            if (SUtilidades.tienePermiso(Short.parseShort("4"), credencial.getUsuario().getPerfil().getIdperfil(), "PARTDO")) {
                NTiposDeDocumentos nTiposDeDocumento = new NTiposDeDocumentos();
                OTiposDeDocumento oTiposDeDocumento = new OTiposDeDocumento(sAccion, abreviatura, tipoDeDocumento, bActivo);
                lista = nTiposDeDocumento.consultar(sTipoConsulta, oTiposDeDocumento);
            } else {
                tipoMensaje = "alert-warning";
                mensaje = "No está autorizado para consultar la lista de tipos de documento";
            }

            request.setAttribute("tipoMensaje", tipoMensaje);
            request.setAttribute("mensaje", mensaje);
            request.setAttribute("lista", lista);
            SUtilidades.irAPagina("/tiposdedocumentos.jsp", request, response, getServletContext());
        } else {
            SUtilidades.irAPagina("/index.jsp", request, response, getServletContext());
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
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
     * Handles the HTTP <code>POST</code> method.
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
