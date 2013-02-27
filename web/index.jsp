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
        <script>
            $(document).on('ready',cargaConfiguracion);
            function cargaConfiguracion(){
                $.ajax({
                    url: 'SContexto',
                    type: 'post',
                    dataType: 'xml',
                    success: function(informacion){
                        var elMensaje = "";
                        $(informacion).find('mensaje').each(function(){
                            elMensaje = $(this).find('info').text();
                        });
                        $("#estadoContexto").html(elMensaje);
                        console.log(informacion);
                    },
                    error: function(jqXHR,estado,elerror){
                        $("#estadoContexto").html(elerror);
                        console.log(estado);
                        console.log(elerror);
                    },
                    complete: function(jqXHR, estado){
                        console.log(estado);
                    }
                });
            }
        </script>
    </head>
    <body>
        <h1>Hello World!</h1>
        <div id="estadoContexto"></div>
    </body>
</html>
