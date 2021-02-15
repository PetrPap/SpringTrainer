<%-- 
    Document   : trainerForm
    Created on : Feb 10, 2021, 8:56:22 AM
    Author     : Petros
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<c:url value="/resources/newcss.css" />" rel="stylesheet">
        <title>Trainer Form</title>
    </head>
    <body>
        <h1>Create a new Trainer</h1>
        
   <c:if test="${trainerToEdit==null}">
       <c:url value="/trainer/create" var="link"/>
    </c:if>
    <c:if test="${trainerToEdit!=null}">
        <c:url  value="/trainer/update" var="link"/>
    </c:if>
        <form action="${link}" method="POST">
            <label hidden for="trainerID">Code:</label>
            <input hidden id="trainerID" type="number" name="trainerID" value="${trainerToEdit.trainerID}" readonly/>
            <br/>
            <label for="firstName">First Name:</label>
            <input id="firstName" type="text" name="firstName" value="${trainerToEdit.firstName}"/>
            <br/>
            <label for="lastName">Last Name:</label>
            <input id="lastName" type="text" name="lastName" value="${trainerToEdit.lastName}"/>
            <br/>
            <label for="subject">Subject:</label>
            <input id="subject" type="text" name="subject" value="${trainerToEdit.subject}"/>
            <br/>
            <input class ="update" type="submit" value="Submit"/>
        </form>
    </body>
</html>
