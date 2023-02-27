<%--
  Created by IntelliJ IDEA.
  User: magno
  Date: 15/02/2023
  Time: 15:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Customers list</title>
</head>
<body>
    <h3>Registered Customers:</h3>
<c:if test="${empty customerSet}">
        None yet!
    </c:if>
    <c:if test="${not empty customerSet}">
        <c:forEach items="${customerSet}" var="student">
            <tr>
                <td>Name: <c:out value="${student.name}"/></td>
                <td>Surname: <c:out value="${student.surname}"/></td>
            </tr>
            <br>
        </c:forEach>
    </c:if>
</body>
</html>
