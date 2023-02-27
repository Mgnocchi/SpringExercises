<%--
  Created by IntelliJ IDEA.
  User: magno
  Date: 14/02/2023
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Form</title>
</head>
<body>
<!-- modelAttribute must match the name of the attribute given to addAttribute -->
    <form:form action="processForm" modelAttribute="customer">
                            <!-- path must match the getters and setters -->
        First Name: <form:input path="name"   />
        <form:errors path="name" cssClass="error"/>
        <br>
        Last Name: <form:input path="surname" />
        <form:errors path="surname" cssClass="error"/> <!-- This is only shown if there are errors. Where are they stored? -->
        <br>

        <input type="submit" value="Submit">
    </form:form>
</body>
</html>
