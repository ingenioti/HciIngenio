<%-- 
    Document   : tiposdedocumento
    Created on : 9/12/2013, 05:09:49 PM
    Author     : Alexys
--%>
<%@page import="java.util.ArrayList"%>
<%
    String usuario = "";
    ArrayList<objetos.ingenioti.org.OTiposDeDocumento> lista = new ArrayList<objetos.ingenioti.org.OTiposDeDocumento>();
    if (session.getAttribute("credencial") != null) {
        objetos.ingenioti.org.OCredencial credencial = (objetos.ingenioti.org.OCredencial) session.getAttribute("credencial");
        usuario = credencial.getUsuario().getNombre();
        if (usuario.length() <= 0) {
            response.sendRedirect("index.jsp");
        }
        if (request.getAttribute("lista") != null) {
            lista = (ArrayList<objetos.ingenioti.org.OTiposDeDocumento>) request.getAttribute("lista");
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
            <form class="form-horizontal" role="form" action="STiposDeDocumento" method="post">
                <h2>Tipos de documentos</h2>
                <div class="form-group">
                    <label for="idTipoDocumento" class="col-sm-2 control-label">ID</label>
                    <div class="col-sm-1">
                        <input type="number" class="form-control" id="idTipoDocumento" name="idTipoDocumento" placeholder="ID" disabled="disabled">
                    </div>
                </div>
                <div class="form-group">
                    <label for="abreviatura" class="col-sm-2 control-label">Abreviatura</label>
                    <div class="col-sm-1">
                        <input type="text" class="form-control" id="abreviatura" name="abreviatura" placeholder="Abreviatura" maxlength="2">
                    </div>
                </div>
                <div class="form-group">
                    <label for="tipoDocumento" class="col-sm-2 control-label">Tipo de Documento</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" id="tipoDocumento" name="tipoDocumento" placeholder="Tipo de Documento" maxlength="25">
                    </div>
                </div>
                <div class="form-group">
                    <label for="activo" class="col-sm-2 control-label">Activo</label>
                    <div class="col-sm-1">
                        <input class="form-control" type="checkbox" id="activo" name="activo" checked="checked">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-primary">Guardar</button>
                    </div>
                </div>
            </form>
            <%
                if (request.getAttribute("tipoMensaje") != null && request.getAttribute("mensaje") != null) {
                    out.print("<div class=\"alert ");
                    out.print(request.getAttribute("tipoMensaje"));
                    out.println("\">");
                    out.print(request.getAttribute("mensaje"));
                    out.println("</div>");
                }
            %>
        </section>
        <section>
            <div class="table-responsive">
                <table class="table table-hover table-bordered">
                    <caption><h3>Listado de Tipos de Documentos</h3></caption>
                    <thead>
                        <tr><th>ID</th><th>Abreviatura</th><th>Tipo de Documento</th><th>Activo</th><th>Acciones</th></tr>
                    </thead>
                    <tbody>
                        <%
                            for (objetos.ingenioti.org.OTiposDeDocumento tipoDocumento : lista) {
                                out.println("<tr>");
                                out.print("<td>");
                                out.print(tipoDocumento.getIdtipodedocumento());
                                out.println("</td>");
                                out.print("<td>");
                                out.print(tipoDocumento.getAbreviatura());
                                out.println("</td>");
                                out.print("<td>");
                                out.print(tipoDocumento.getTipodedocumento());
                                out.println("</td>");
                                out.print("<td>");
                                out.print("<input class=\"form-control\" type=\"checkbox\" disabled=\"disabled\"");
                                if(tipoDocumento.isActivo()){
                                        out.print(" checked=\"checked\"");
                                }
                                out.print(">");
                                out.println("</td>");
                                out.print("<td>");
                                out.print("Actualizar | Eliminar");
                                out.println("</td>");
                                out.println("</tr>");
                            }
                        %>
                    </tbody>
                </table>
            </div>
        </section>
    </body>
</html>
