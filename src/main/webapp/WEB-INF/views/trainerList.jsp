
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<c:url value="/resources/newcss.css" />" rel="stylesheet">
        <title>Trainers</title>
    </head>
    <body>
        <h1>This is the Trainers List</h1>
        <br>
        <div>
<!--            <h3>Trainers</h3>-->
            <p>
                ${message}
            </p>
            
            <a class ="update" style="font-size: 25px" href="${pageContext.request.contextPath}/trainer/create">Add trainer</a>
            <br>
            <br>
            <table border="4" style="font-size: 20px">
                <thead>
                    <tr>
                        <th>Code</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Subject</th>
                        <th>Update</th>
                        <th>Delete</th>
                    </tr>
                </thead>
                <c:forEach items="${listOfTrainers}" var = "trainer">
                    <tr>
                        <td>${trainer.trainerID}</td>
                        <td>${trainer.firstName}</td>
                        <td>${trainer.lastName}</td>
                        <td>${trainer.subject}</td>
                        <td>      
                            <a class ="update" href="${pageContext.request.contextPath}/trainer/update/${trainer.trainerID}">Update</a>
                        </td>
                        <td>
                            <a class ="delete" href="${pageContext.request.contextPath}/trainer/delete?id=${trainer.trainerID}">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
