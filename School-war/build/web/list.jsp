<%-- 
    Document   : list
    Created on : 21/03/2020, 08:45:32 PM
    Author     : Juan Pablo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${listName}</title>
        <link href="https://fonts.googleapis.com/css?family=Barlow:300,400,700&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="css/list.css"/>
    </head>
    <body>
        <main>
            <h1>${listName}</h1>
            <hr>

            <div class="studentTable">
                <table>
                    <c:forEach items="${allHeader}" var="top">
                        <th>${top}</th>
                        </c:forEach>


                    <c:forEach items="${allData}" var="data">
                        <tr class="rowStudent">
                            <c:forEach items="${data}" var="dato">
                                <td>${dato}</td>
                            </c:forEach>
                        </tr>
                    </c:forEach>

                </table>
            </div>



        </main>
    </body>
</html>
