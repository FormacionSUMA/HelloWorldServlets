<%@ page import="es.github.jpm33.helloWorld.domain.beans.UserBean" %><%--
  Created by IntelliJ IDEA.
  User: j.perezm
  Date: 04/06/2021
  Time: 11:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%

    boolean loginFail = false;
    if (request.getParameter("btnLoginServlet") != null) {
        UserBean user = (UserBean) session.getAttribute("currentSessionUser");
        loginFail = user == null || !user.isValid();
    }

%>
<html>
<head>
    <meta charset="utf-8">
    <title>Hello World | Login</title>
    <link type="text/css" rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans">
    <style type="text/css" >
        body { font-family: 'Open Sans', serif; }
    </style>
</head>
<body>
    <form action="LoginServlet" method="post">
        <fieldset>
            <legend>Login Form</legend>
                Username <input type="text" name="un" placeholder="Please enter your username" autofocus /><br>
                Password <input type="password" name="pw" placeholder="Please enter your password" /><br><hr>
                         <input type="submit" name="btnLoginServlet" value="submit">
        </fieldset>
    </form>
    <c:if test="loginFail">
        <p>Login or password not valid!</p>
        <%= loginFail %>
    </c:if>
</body>
</html>
