<%-- 
    Document   : displayAvengers
    Created on : 12-Nov-2019, 9:17:38 PM
    Author     : Hung-Han,Chen, Ali Cemilcan Ciftarslan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Here are the Avengers</h1> 

        <c:if test="${!empty error}">
            <h2>${error}</h2>
        </c:if>  

        <c:if test="${!empty avengers}">

            <c:forEach var="avenger" items="${avengers}">
                <h2>${avenger.name}, ${avenger.description}</h2> 
                Power Source: ${avenger.powerSource.description}<br><br>
            </c:forEach>
                
        </c:if>            

        <a href="index.html">Back to index</a>

    </body>
</html>
