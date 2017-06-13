<%--
  Created by IntelliJ IDEA.
  User: DelMonroe
  Date: 6/12/17
  Time: 4:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Users" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="container">
    <h1>Created users</h1>

    <c:forEach var="user" items="${profile}">
        <div class="col-md-6">
            <h2>${user.username}</h2>
            <p>${user.email}</p>
        </div>
    </c:forEach>
</div>

</body>
</html>