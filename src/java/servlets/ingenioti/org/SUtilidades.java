/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets.ingenioti.org;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import negocio.ingenioti.org.NAutenticacion;
/**
 *
 * @author Alexys
 */
@WebServlet(name = "SUtilidades", urlPatterns = {"/SUtilidades"})
public final class SUtilidades extends HttpServlet {

    /**
     * Metodo irAPagina, utilizado para redireccionar una pagina
     * @param direccion Direccion a la que desea ir (absoluta o relativa)
     * @param solicitud Tipo HttpServletRequest
     * @param respuesta Tipo HttpServletResponse
     * @param contexto Tipo ServletContext
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     */
    protected static void irAPagina(String direccion, HttpServletRequest solicitud,
                            HttpServletResponse respuesta, ServletContext contexto)
            throws ServletException, IOException, IllegalStateException{
        direccion = respuesta.encodeURL(direccion);
        RequestDispatcher despachador = contexto.getRequestDispatcher(direccion);
        despachador.forward(solicitud, respuesta);
    }
    
    /**
     * Metodo autenticado, se debe utilizar en todos los servlets, (a excepcion del de autenticar),
     * este metodo permite saber si el usuario esta o no autenticado.
     * @param solicitud Tipo HttpServletRequest
     * @param respuesta Tipo HttpServletResponse
     * @return True si esta autenticado False si no lo esta y lo reenvia a la pagina de autenticacion
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     */
    protected static boolean autenticado(HttpSession sesion)
            throws ServletException, IOException{
        if (sesion == null || sesion.getAttribute("credencial") == null){ /* No autenticado */
          return (false);
        }
        return (true);
    }
    
    protected static boolean tienePermiso(Short tipoDeAccion, Short perfil, String objeto){
        NAutenticacion autenticacion = new NAutenticacion();
        return autenticacion.tienePermiso(tipoDeAccion, perfil, objeto);
    }
}
