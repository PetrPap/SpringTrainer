<%-- 
    Document   : home
    Created on : Feb 8, 2021, 3:21:35 PM
    Author     : Petros
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<c:url value="/resources/newcss.css" />" rel="stylesheet">
        <title>Home Page</title>
    </head>
    <body>
            <h1>${myMessage}</h1>
            <br>
            <br>
            <br>
            <a class ="update" style="font-size: 25px" href="${pageContext.request.contextPath}/trainer">Trainers</a>
    </body>
</html>
