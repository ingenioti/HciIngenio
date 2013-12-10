<%-- 
    Document   : cambiarclave
    Created on : 07/12/2013, 05:11:32 PM
    Author     : Alexys
--%>
<%
    String usuario="";
    if(session.getAttribute("credencial")!=null){
        objetos.ingenioti.org.OCredencial credencial = (objetos.ingenioti.org.OCredencial) session.getAttribute("credencial");
        usuario = credencial.getUsuario().getNombre();
        if(usuario.length()<=0){
            response.sendRedirect("index.jsp");
        }
    } else {
        response.sendRedirect("index.jsp");
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="Herramientas para el control de información">
        <meta name="author" content="Alexys Lozada">
        <title>H.C.I. Herramientas para el control de información</title>
        <script src="js/jquery-1.9.1.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="css/bootstrap.min.css" />
        <link rel="stylesheet" href="css/estilo.css" />
    </head>
    <body>
        <header>
        <jsp:include flush="true" page="encabezado.jsp" />
        </header>
        <section>
            <div class="container">
                <h1>Cambio de Clave.</h1>
                <p>Formulario para el cambio de clave.</p>
                <form action="SCambiarClave" method="post" class="form-signin">
                    <h2 class="form-signin-heading">Cambio de clave</h2>
                    <input type="hidden" name="ts" value="normal">
                    <input class="input-block-level" autofocus autocomplete="off" type="password" id="txtAnterior" name="txtAnterior" placeholder="Clave Actual">
                    <input class="input-block-level" autocomplete="off" type="password" id="txtNueva" name="txtNueva" placeholder="Clave Nueva">
                    <input class="input-block-level" autocomplete="off" type="password" id="txtConfirma" name="txtConfirma" placeholder="Confirmar Clave">
                    <input class="btn btn-large btn-primary" type="submit" name="btnCambiar" value="Cambiar Contraseña">
                </form>
                    
                <p>
                    <% 
                        if(request.getAttribute("mensaje")!=null){
                            out.println(request.getAttribute("mensaje"));  
                        }
                    %>
                </p>
            </div>
        </section>
    </body>
</html>
