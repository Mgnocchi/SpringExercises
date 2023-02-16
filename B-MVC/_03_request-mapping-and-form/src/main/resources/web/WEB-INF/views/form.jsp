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
    <form:form action="processForm" modelAttribute="student">
                            <!-- path must match the getters and setters -->
        First Name: <form:input path="name"   />
        <br>
        Last Name: <form:input path="surname" />
        <br>
        <label> Country:
            <form:select path="country">
                <form:options items="${countries}"/>
            </form:select>
        </label>

        <input type="submit" value="Submit">
    </form:form>
</body>
</html>
