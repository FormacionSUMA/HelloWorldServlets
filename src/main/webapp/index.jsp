<%@ page import="es.github.jpm33.helloWorld.domain.beans.UserBean" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%

    UserBean user = (UserBean) session.getAttribute("currentSessionUser");
    if (user == null || !user.isLoginValid()) {

        System.out.println(user);
        response.sendRedirect("login.jsp");

    }
    else {
%>
<html>
<head>
    <meta charset="utf-8">
    <title>Hello World | Index</title>
    <link type="text/css" rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans">
    <link type="text/css" rel="stylesheet" href="styles/web.css">
</head>
<body>
<h1>Hola, bienvenido <%= user.getFullName() %>.</h1>
<p>
    Tu datos:
    <ul>
        <ol>Login: <%= user.getLogin() %></ol>
        <ol>Fecha de Alta: <%= user.getCreatedAt() %></ol>
        <ol>Estado: <%= user.getStatus() %></ol>
    </ul>
</ul>
</p>
<a href="logout.jsp">Cerrar sesión</a>
<br>
<br>
<a href="ReportServlet">Generar PDF</a>
</body>
</html>
<% } // Cerrar: if (user == null || !user.isValid()) %>