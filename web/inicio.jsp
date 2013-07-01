<%-- 
    Document   : inicio
    Created on : 13/04/2013, 05:11:32 PM
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
        <link rel="stylesheet" href="css/bootstrap-responsive.min.css" />
        <link rel="stylesheet" href="css/estilo.css" />
        <style>
            body{ /* Se hace para empujar un poco el cuerpo */
                padding-top: 60px;
            }
        </style>
    </head>
    <body>
        <header>
        <jsp:include flush="true" page="encabezado.jsp" />
        </header>
        <section>
            <div class="container">
                <h1>Bienvenido.</h1>
                <p>Inicie aquí su proyecto.</p>
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
