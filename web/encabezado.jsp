<%
    String usuario="";
    if(session.getAttribute("credencial")!=null){
        objetos.ingenioti.org.OCredencial credencial = (objetos.ingenioti.org.OCredencial) session.getAttribute("credencial");
        usuario = credencial.getUsuario().getNombre();
    }
%>
<header>
    <div id="divEncabezado">
        <div id="divLogo">
            <h1>HCI Total</h1>
            <h2>Herramientas para el control de informaci&oacute;n</h2>
        </div>
        <div id="divContenidoEncabezado">
            <div id="bienvenidaUsuario">Bienvenido <%=usuario%></div>
            <p>Aqu&iacute; va un men&uacute; principal</p>
        </div>
    </div>
</header>
