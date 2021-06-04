<%--
  Created by IntelliJ IDEA.
  User: j.perezm
  Date: 04/06/2021
  Time: 12:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%

    session.removeAttribute("currentSessionUser");
    response.sendRedirect("index.jsp");

%>