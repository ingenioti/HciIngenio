<%-- 
    Document   : inicio
    Created on : 13/04/2013, 05:11:32 PM
    Author     : Alexys
--%>
<%
    if(session.getAttribute("credencial")==null){
        response.sendRedirect("index.jsp");
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Mi Inicio</title>
    </head>
    <body>
        <jsp:include flush="true" page="encabezado.jsp" />
        <h1>Hello World!</h1>
        <% if(request.getAttribute("mensaje")!=null){
          out.println(request.getAttribute("mensaje"));  
        }
        %>
    </body>
</html>
