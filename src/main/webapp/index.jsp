<%@ page import="es.github.jpm33.helloWorld.domain.beans.UserBean" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%

    UserBean user = (UserBean) session.getAttribute("currentSessionUser");
    if (user == null || !user.isValid()) {
        response.sendRedirect("login.jsp");
        user = new UserBean();
    }

%>
<html>
<head>
    <meta charset="utf-8">
    <title>Hello World | Index</title>
    <link type="text/css" rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans">
    <style type="text/css" >
        body { font-family: 'Open Sans', serif; }
    </style>
</head>
<body>
<h1>Hola, bienvenido <%= user.getUserName() %>.</h1>
<a href="logout.jsp">Cerrar sesión</a>
</body>
</html>
