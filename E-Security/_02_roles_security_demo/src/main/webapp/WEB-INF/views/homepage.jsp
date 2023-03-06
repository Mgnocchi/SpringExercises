<!DOCTYPE html>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<body>
<h1>Home Page! fsdfs</h1>

<a href="${pageContext.request.contextPath}/users">
    <button type="button" >Go to users page</button>
</a>

<a href="${pageContext.request.contextPath}/admins">
    <button type="button" >Go to admins page</button>
</a>

<br>

<a href="${pageContext.request.contextPath}/logout" methods="POST">
    <button type="button" >Logout</button>
</a>

<br>

<c:if test="${param.logout != null}">
    <i>Logged out</i>
</c:if>

</body>
</html>