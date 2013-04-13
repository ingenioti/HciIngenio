<%-- 
    Document   : inicio
    Created on : 13/04/2013, 05:11:32 PM
    Author     : Alexys
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Mi Inicio</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <% if(request.getAttribute("mensaje")!=null){
          out.println(request.getAttribute("mensaje"));  
        }
        %>
    </body>
</html>
