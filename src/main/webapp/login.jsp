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
    boolean isFormSubmited = "POST".equals(request.getMethod().toUpperCase()) && request.getParameter("btnLoginServlet") != null;
    UserBean user = (UserBean) session.getAttribute("currentSessionUser");

    if (isFormSubmited && user != null) {
            loginFail = !user.isLoginValid();
    }

//    if (request.getParameter("btnLoginServlet") != null) {
//
//    }

%>
<html>
<head>
    <meta charset="utf-8">
    <title>Hello World | Login</title>
    <link type="text/css" rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans">
    <link type="text/css" rel="stylesheet" href="styles/web.css">
</head>
<body>

    loginFail = <%= loginFail %>

    <form id="loginFrm" action="LoginServlet" method="post">
        <fieldset>
            <legend>Login Form</legend>
                Username <input type="text" name="un" placeholder="Please enter your username" autofocus /><br>
                Password <input type="password" name="pw" placeholder="Please enter your password" /><br><hr>
                         <input type="submit" name="btnLoginServlet" value="submit">
        </fieldset>
    </form>
<%--    <c:if test="${loginFail == true}">--%>
<%--        <p>Login or password not valid!</p>--%>
<%--    </c:if>--%>

    <% if (isFormSubmited && loginFail) { %>
        <p class="errorMsg">Login or password not valid!</p>
    <% } %>

</body>
</html>
