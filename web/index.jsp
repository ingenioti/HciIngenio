<%-- 
    Document   : index
    Created on : 24/02/2013, 07:48:44 PM
    Author     : Alexys
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>JSP Page</title>
        <script src="js/jquery-1.9.1.min.js"></script>
        <link rel="stylesheet" href="css/estilo.css" />
    </head>
    <body>
        <header>
        <h1>HCI Ingenio T.I.</h1>
        </header>
        <section id="ingreso">
            <div id="ingresar">
                <form action="SAutenticar" method="post">
                    <fieldset>
                        <legend>Autenticación</legend>
                        <div class="datoFormulario">
                            <label for="txtUsr" class="lblEntrada">Usuario</label>
                            <input type="text" autofocus autocomplete="off" id="txtUsr" name="txtUsr" placeholder="Digita tu usuario" />
                        </div>
                        <div class="datoFormulario">
                            <label for="txtPwd" class="lblEntrada">Clave</label>
                            <input type="password" autocomplete="off" id="txtPwd" name="txtPwd" placeholder="Clave" />
                        </div>
                        <div class="datoFormulario">
                        <input type="submit" name="btnEnviar" value="Ingresar"/>
                        </div>
                        <% if(request.getAttribute("mensaje")!=null){
                        %>
                            <div class="error">
                                    <%= request.getAttribute("mensaje") %>
                            </div>
                        <%
                           }
                        %>
                    </fieldset>
                </form>
            </div>
        </section>
        <section>
            <div id="estadoContexto"></div>
        </section>
        <script>
            $(document).on('ready',cargaConfiguracion);
            function cargaConfiguracion(){
                $.ajax({
                    url: 'SContexto',
                    type: 'post',
                    dataType: 'xml',
                    success: function(informacion){
                        var elTipo = 0;
                        var elMensaje = "";
                        $(informacion).find('mensaje').each(function(){
                            elTipo = parseInt($(this).find('tipo').text());
                            elMensaje = $(this).find('info').text();
                        });
                        switch(elTipo){
                            case 0:
                                $("#estadoContexto").addClass("error");
                                break;
                            case 1:
                                $("#estadoContexto").addClass("info");
                                break;
                            case 2:
                                $("#estadoContexto").addClass("correcto");
                                break;
                        }
                        $("#estadoContexto").html(elMensaje);
                    },
                    error: function(jqXHR,estado,elerror){
                        $("#estadoContexto").html(elerror);
                        console.log(estado);
                        console.log(elerror);
                    }
                    //complete: function(jqXHR, estado){
                    //    console.log(estado);
                    //}
                });
            }
        </script>
    </body>
</html>
