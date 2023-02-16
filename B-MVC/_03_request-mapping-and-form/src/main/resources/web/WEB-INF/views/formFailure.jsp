<%--
  Created by IntelliJ IDEA.
  User: magno
  Date: 15/02/2023
  Time: 16:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Failure!</title>
</head>
<body>
<h3>
  Failed to add student: ${Student.name} ${Student.surname}
</h3>
<h4>
  Name and surname must contain only letters
</h4>
<br><br>
<a href="${pageContext.request.contextPath}/form">
  <button type="button" >Add another User</button>
</a>
<a href="${pageContext.request.contextPath}/list">
  <button type="button">View Registered Users</button>
</a>
<a href="${pageContext.request.contextPath}/">
  <button type="button">Go to Homepage</button>
</a>
</body>
</html>
