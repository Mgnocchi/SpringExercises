<%--
  Created by IntelliJ IDEA.
  User: magno
  Date: 14/02/2023
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Success!</title>
</head>
<body>
    <h3>
      Successfully added student ${Student.name} ${Student.surname}
    </h3>
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
